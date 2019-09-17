package com.sun.newlanguage.design

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ViewAnimator


class ProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {

    private var mProgress = 0
    private var mHeight = 100
    private var mWidth = 300

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        Log.d("size", "view:$widthMeasureSpec---$heightMeasureSpec")

//        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
//        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
//        Log.d("size","measurespec height:$heightSize----width:$widthSize")


        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        mWidth = if (widthMode == MeasureSpec.EXACTLY) {
            widthSize
        } else {
            Math.min(mWidth,widthSize)
        }

        mHeight = if (heightMode == MeasureSpec.EXACTLY) {
            heightSize
        } else {
            Math.min(mHeight, heightSize)
        }

        setMeasuredDimension(mWidth,mHeight)


    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.RED
        paint.style = Paint.Style.FILL

        val sidePaint = Paint()
        sidePaint.isAntiAlias = true
        sidePaint.color = Color.BLUE
        sidePaint.style = Paint.Style.FILL

        canvas?.drawRect(0f, 0f, mWidth.toFloat(), mHeight.toFloat(), sidePaint)

        canvas?.drawRect(0f, 0f, (mProgress * mWidth/100).toFloat(), mHeight.toFloat(), paint)


    }

    public fun startProgress() {
        val animator = ValueAnimator.ofInt(0, 100)
        animator.duration = 10000
        animator.addUpdateListener {
            mProgress = it.animatedValue as Int
            Log.d("progress","progress:$mProgress")

            invalidate()

        }
        animator.start()



    }



}