package com.sun.newlanguage.activity

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import android.util.Log
import com.sun.newlanguage.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

//        val player = MediaPlayer()
//        player.reset()
//        player.setDataSource("https://m801.music.126.net/20190828080403/a3e494f4ab6cb6464974a33d6e57cdc0/jdyyaac/5558/0052/550c/b26bf204b4781483b72cbfcc9d09dadc.m4a")
//        player.prepareAsync()
//        player.setOnPreparedListener {
//            Log.d("sound","duration:${it.duration}")
//
//            it.start()
//        }








        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button_anim.setOnClickListener {
            startActivity(Intent(this, RotateActivity::class.java))
        }

        progress.setOnClickListener {
            startActivity(Intent(this, ProgressActivity::class.java))
        }

        viewpager.setOnClickListener {
            startActivity(Intent(this,ViewPagerActivity::class.java))
        }

        web.setOnClickListener {
            startActivity(Intent(this,WebviewActivity::class.java))
        }

        collapse.setOnClickListener {
            startActivity(Intent(this, CollapseActivity::class.java))
        }

        send.setOnClickListener {
            startActivity(Intent(this, SendActivity::class.java))
        }

        model.setOnClickListener {
            startActivity(Intent(this, ModelActivity::class.java))
        }

        add_view.setOnClickListener {
            startActivity(Intent(this, AddViewActivity::class.java))
        }

        button_view.setOnClickListener {
            startActivity(Intent(this, CommonViewPageActivity::class.java))
        }

        button_transparent.setOnClickListener {
            startActivity(Intent(this, TransparentActivity::class.java))
        }

        button_kill.setOnClickListener {
            Process.killProcess(Process.myPid())
        }

        button_data.setOnClickListener {
            startActivity(Intent(this, DataBindingActivity::class.java))
        }

    }
}
