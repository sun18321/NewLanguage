package com.sun.newlanguage.activity

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Toast
import android.widget.ViewAnimator
import androidx.core.view.postDelayed
import com.sun.newlanguage.R
import com.sun.newlanguage.design.MyEvlutor
import kotlinx.android.synthetic.main.activity_rotate.*
import kotlinx.android.synthetic.main.text.*
import kotlin.math.log

class RotateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate)

        init()
    }

    private fun init() {
        val anim = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f)
        anim.duration = 3000
        anim.repeatCount = ValueAnimator.INFINITE
        anim.interpolator = LinearInterpolator()
        anim.start()


        val redAnim = ObjectAnimator.ofFloat(img_red, "rotation", 0f, 360f)
        redAnim.duration = 5000
        redAnim.repeatCount = ValueAnimator.INFINITE
        redAnim.interpolator = LinearInterpolator()
        redAnim.start()


        val xHolder = PropertyValuesHolder.ofFloat("scaleX", 1f, 3f)
        val yHolder = PropertyValuesHolder.ofFloat("scaleY", 1f, 3f)
        val alphaHolder = PropertyValuesHolder.ofFloat("alpha", 1f, 0f)

        val scaleAnim = ObjectAnimator.ofPropertyValuesHolder(img_two, xHolder, yHolder,alphaHolder)
        scaleAnim.duration = 5000
        scaleAnim.repeatCount = ValueAnimator.INFINITE
        scaleAnim.interpolator = LinearInterpolator()
        scaleAnim.addListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                img_two.visibility = View.INVISIBLE
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
                img_two.visibility = View.VISIBLE
            }

        })


        scaleAnim.start()

        val threeAnim = ObjectAnimator.ofPropertyValuesHolder(img_three, xHolder, yHolder, alphaHolder)
        threeAnim.duration = 5000
        threeAnim.repeatCount = ValueAnimator.INFINITE
        threeAnim.interpolator = LinearInterpolator()
        threeAnim.addListener(object :Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {
                Log.d("life","anim repeat")
            }

            override fun onAnimationEnd(p0: Animator?) {
                img_three.visibility = View.INVISIBLE

                Log.d("life","anim end")
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
                img_three.visibility = View.VISIBLE

                Log.d("life","anim start")
            }

        })


        img_three.postDelayed({
            threeAnim.start()
        },2000)


        val transAnim = ObjectAnimator.ofFloat(img_trans, "translationY", 0f, 1600f)
        transAnim.duration = 6000
        transAnim.interpolator = LinearInterpolator()

        anim_switch.setOnClickListener {
            Log.d("anim", "pause:${transAnim.isPaused}-----running:${transAnim.isRunning}")


            when {
                transAnim.isRunning && !transAnim.isPaused -> transAnim.pause()
                transAnim.isPaused -> {
                    Log.d("anim","do anim pause")
                    transAnim.resume()
                }
                else -> transAnim.start()
            }

        }




    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        Log.d("location","x:${img_trans.x}---y:${img_trans.y}---height:${img_trans.height}---width:${img_trans.width}")

        val radius: Float = 200f
        val x = img_red.x + img_red.width / 2
        val y = img_red.y + img_red.height / 2

        Log.d("location", "width:${img_red.width}----height:${img_red.height}")

        var tvHeight = tv_rotate.height
        val tvWidth = tv_rotate.width

//        tv_rotate.x = img_red.x
//        tv_rotate.y =img_red.y


//        val valueAnimator = ValueAnimator.ofObject(MyEvlutor(), PointF(x, y-radius), PointF(x, y+radius))
        val valueAnimator = ValueAnimator.ofObject(MyEvlutor(), PointF(0f, 0f), PointF(0f, 0f))
//        valueAnimator.setTarget(tv_rotate)
        valueAnimator.duration = 8000
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.addUpdateListener {
            val value:PointF = it.animatedValue as PointF
            tv_rotate.x = value.x - tvWidth / 2
            tv_rotate.y = value.y - tvHeight / 2



        }
        valueAnimator.start()


        val fractionAnim = ValueAnimator.ofInt(0, 1)
        fractionAnim.duration = 3000
        fractionAnim.addUpdateListener {
            Log.d("fraction_test", "progress:${it.animatedFraction}")
        }
        fractionAnim.start()


    }
}
