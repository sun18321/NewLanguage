package com.sun.newlanguage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sun.newlanguage.R
import com.sun.newlanguage.adapter.BaseHolder
import kotlinx.android.synthetic.main.activity_nested.*

class NestedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested)

        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = NestAdapter()
    }


    class NestAdapter():RecyclerView.Adapter<BaseHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
            return BaseHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_nested,parent,false))
        }

        override fun getItemCount(): Int {
            return 10
        }

        override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        }

    }
}
