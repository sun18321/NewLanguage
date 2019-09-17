package com.sun.newlanguage.design

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

class CircleProgress @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    init {
      init()
    }

    private var mProgress = 0
    private lateinit var mAllPaint: Paint
    private lateinit var mProgressPaint: Paint
    private lateinit var mTextPaint: Paint


    private fun init() {
        mAllPaint = Paint()
        mAllPaint.isAntiAlias = true
        mAllPaint.style = Paint.Style.STROKE
        mAllPaint.strokeWidth = 3f
        mAllPaint.color = Color.GRAY

        mProgressPaint = Paint()
        mProgressPaint.isAntiAlias = true
        mProgressPaint.style = Paint.Style.FILL
        mProgressPaint.color = Color.RED

        mTextPaint = Paint()
        mTextPaint.isAntiAlias = true
        mTextPaint.color = Color.BLUE
        mTextPaint.textSize = 30f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(200,200)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        canvas?.drawCircle(100f, 100f, 100f, mAllPaint)

        canvas?.drawArc(0f, 0f, 200f, 200f, 0f, (mProgress * 360 / 100).toFloat(), true, mProgressPaint)

        val textHeight = mTextPaint.descent() + mTextPaint.ascent()

        var text = "$mProgress"

        canvas?.drawText(text,(200-mTextPaint.measureText(text))/2.toFloat(),(200-textHeight)/2.toFloat(),mTextPaint)

    }

    fun startProgress() {
        val animator = ValueAnimator.ofInt(0, 100)
        animator.duration = 10000
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener {
            mProgress = it.animatedValue as Int

            invalidate()
        }
        animator.start()

    }
}