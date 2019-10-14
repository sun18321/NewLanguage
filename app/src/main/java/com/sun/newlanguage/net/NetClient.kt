package com.sun.newlanguage.net

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.sun.newlanguage.util.LanguageApplication
import com.sun.newlanguage.util.NetWorkUtils
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okio.Timeout
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class NetClient {
    companion object{
        const val TIME_OUT = 20

    }
    private val cookJar by lazy { PersistentCookieJar(SetCookieCache(),SharedPrefsCookiePersistor(LanguageApplication.CONTEXT)) }


    private val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder().connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            //缓存
            val cacheDirectory = File(LanguageApplication.CONTEXT.cacheDir, "http")
            val cacheSize = 10 * 1024 * 1024L
            val cache = Cache(cacheDirectory,cacheSize)
            builder.cache(cache)
                .cookieJar(cookJar)
                .addInterceptor {
                    val request = it.request()
                    val response = it.proceed(request)
                    if (!NetWorkUtils.isNetworkAvailable(LanguageApplication.CONTEXT)) {
                        val maxAge = 60 * 60
                        response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control","public, max-age = $maxAge").build()
                    }else{
                        val maxStale = 60 * 60 * 24 * 28
                        response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control","public,only-if-cached,max-stale=$maxStale")
                            .build()
                    }
                   response
                }

                return builder.build()
        }

    fun <T> getService(serviceClass: Class<T>, baseUrl: String): T {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build().create(serviceClass)
    }
}