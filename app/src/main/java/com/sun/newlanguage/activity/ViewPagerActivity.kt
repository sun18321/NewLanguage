package com.sun.newlanguage.activity

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.sun.newlanguage.R
import kotlinx.android.synthetic.main.activity_rotate.*
import kotlinx.android.synthetic.main.activity_view_pager.*
import kotlinx.android.synthetic.main.viewpager_item.view.*

class ViewPagerActivity : AppCompatActivity() {
    private var mCurrentItem = 1
    private var mSecondCurrent = 1
    private var mLastX = 0
    private var mLastY = 0
    private lateinit var mParams: ConstraintLayout.LayoutParams
    private var mImgWidth = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        init()

    }

    private fun init() {
        edit_location.setOnClickListener {
            img_move.x = 100f
            img_move.y = 100f
            constraint.invalidate()
        }


        viewpager.adapter = MyAdapter(this)
        viewpager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                if (state != ViewPager.SCROLL_STATE_IDLE) {
                    return
                }

                    if (mCurrentItem == 0) {
                        viewpager.setCurrentItem(3,false)
                    }
                    if (mCurrentItem == 4) {
                        viewpager.setCurrentItem(1,false)
                    }




            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                Log.d("offset","distance:$positionOffset-----position:$position")

//                if (positionOffset == 0f) {
//                    return
//                }

//                左
                if (mCurrentItem == position) {
                    img_move.x = -mImgWidth *positionOffset

                } else {
                    img_move.x = mImgWidth * (1 - positionOffset)
                }

                if (img_move.x > 0.95 * mImgWidth || img_move.x < -0.95 * mImgWidth) {
                    img_move.visibility = View.INVISIBLE
                } else {
                    img_move.visibility = View.VISIBLE

                }


                constraint.invalidate()



            }

            override fun onPageSelected(position: Int) {
//                if (position > 3) {
//                    viewpager.currentItem = 1
//                }
//                if (position < 1) {
//                    viewpager.currentItem = 3
//
//                }
                mCurrentItem = position

            }
        })

        viewpager.currentItem = 1




        second_viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                mSecondCurrent = position
            }

            override fun onPageScrollStateChanged(state: Int) {
                if (state != ViewPager.SCROLL_STATE_IDLE) {
                    return
                }


                if (mSecondCurrent == 0 || mSecondCurrent == 2) {
                    second_viewpager.setCurrentItem(1, false)
                }


            }

        })

        second_viewpager.adapter = SecondAdapter(this)
        second_viewpager.setCurrentItem(1,false)



        tv_location.setOnTouchListener { view, motionEvent ->
            val layoutParams:ConstraintLayout.LayoutParams = view.layoutParams as ConstraintLayout.LayoutParams
            when (motionEvent.action) {

                MotionEvent.ACTION_DOWN -> {
//                    mLastX = view.x.toInt()
//                    mLastY = view.y.toInt()

                    val rawX = motionEvent.rawX.toInt()
                    val rawY = motionEvent.rawY.toInt()

                    mLastX = motionEvent.rawX.toInt()
                    mLastY = motionEvent.rawY.toInt()

                    Log.d("location", "x:$mLastX----y:$mLastY---rawX:$rawX----rawY:$rawY")


                }
                MotionEvent.ACTION_MOVE -> {
                    val newX = motionEvent.rawX.toInt()
                    val newY = motionEvent.rawY.toInt()

                    mLastX = newX
                    mLastY = newY

                    layoutParams.topToTop = R.id.constraint
                    layoutParams.leftToLeft = R.id.constraint
                    layoutParams.topMargin = mLastY
                    layoutParams.leftMargin = mLastX
                    tv_location.layoutParams = layoutParams



                }

                MotionEvent.ACTION_UP ->{

                }

            }

            constraint.invalidate()


//            layoutParams.top

            true
        }


    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        Log.d("window", "height:${tv_location.height}----width:${tv_location.width}")
        Log.d("window","top:${tv_location.top}----left:${tv_location.left} ---x:${tv_location.x}----y:${tv_location.y}" )

        mParams = img_move.layoutParams as ConstraintLayout.LayoutParams
        mImgWidth = img_move.width
    }


    class MyAdapter(context: Context) : PagerAdapter() {
        private var mContext: Context = context


        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_item, container, false)

            var realPosition = position % 3
            view.tv_real.text = position.toString()

            view.tv.text = realPosition.toString()
            when (realPosition) {
                0 -> {
                    view.setBackgroundColor(Color.BLUE)
                }
                1 -> {
                    view.setBackgroundColor(Color.GREEN)
                }
                2->{
                    view.setBackgroundColor(Color.BLACK)
                }
            }
            container.addView(view)
            return view
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
           return view == `object`
        }

        override fun getCount(): Int {
            return 5
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

    }


    class SecondAdapter(context: Context):RecyclerView.Adapter<SecondAdapter.SecondHolder>(){
        private var mContext = context

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondHolder {
            val view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_item, parent, false)
            return SecondHolder((view))

        }

        override fun getItemCount(): Int {
            return 3
        }

        override fun onBindViewHolder(holder: SecondHolder, position: Int) {
            var realPosition = position % 3


            holder.itemView.tv.text = realPosition.toString()
            when (realPosition) {
                0 -> {
                    holder.itemView.setBackgroundColor(Color.BLUE)
                }
                1 -> {
                    holder.itemView.setBackgroundColor(Color.GREEN)
                }
                2 -> {
                    holder.itemView.setBackgroundColor(Color.BLACK)
                }
            }
        }


        class SecondHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    }
}
