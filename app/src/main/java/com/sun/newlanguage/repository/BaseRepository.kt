package com.sun.newlanguage.repository

import com.sun.newlanguage.bean.BaseNetBean
import com.sun.newlanguage.bean.ResultBean

open class BaseRepository{

    suspend fun <T : Any> apiCall(call: suspend () -> BaseNetBean<T>): BaseNetBean<T> {
        return call.invoke()
    }

//    suspend fun <T:Any> safeApiCakk(call:suspend ()-> ResultBean<T>, errorMessage:String ): ResultBean<T> {
//        return try {
//            call()
//        } catch (e: Exception) {
//            ResultBean.Error(e)
//        }
//
//    }

//    suspend fun <T : Any> safeApiCall(call: suspend () -> Result<T>, errorMessage: String): {
//
//    }



}