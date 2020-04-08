package com.sun.newlanguage.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.newlanguage.R
import com.sun.newlanguage.adapter.BaseHolder
import kotlinx.android.synthetic.main.activity_common_view_page.*

class CommonViewPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_view_page)


        //test profile
        view_pager.offscreenPageLimit = 10
        view_pager.adapter = ImageAdapter()

    }


    class ImageAdapter:RecyclerView.Adapter<BaseHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
            return BaseHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent,false))
        }

        override fun getItemCount(): Int {
            return 10000
        }

        override fun onBindViewHolder(holder: BaseHolder, position: Int) {

        }

        override fun onBindViewHolder(holder: BaseHolder, position: Int, payloads: MutableList<Any>) {
            super.onBindViewHolder(holder, position, payloads)
        }

    }
}
