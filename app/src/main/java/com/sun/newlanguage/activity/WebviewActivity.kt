package com.sun.newlanguage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.*
import com.sun.newlanguage.R
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val settings = web_view.settings
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.setSupportZoom(true)
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.userAgentString = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36"

        web_view.setWebChromeClient(object : WebChromeClient() {
                        override fun onReceivedTitle(view: WebView?, title: String?) =
                            super.onReceivedTitle(view, title)
        })

        web_view.webViewClient = object :WebViewClient(){
            override fun shouldInterceptRequest(view: WebView?, url: String?): WebResourceResponse? {
                Log.d("address","url:$url")
                return super.shouldInterceptRequest(view, url)

            }
        }



        web_view.loadUrl("https://music.163.com")
    }
}
