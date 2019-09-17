package com.sun.newlanguage.design

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView
import com.sun.newlanguage.R

class RoundImage @JvmOverloads constructor(
    private val mContext: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(mContext, attrs, defStyleAttr) {

    private lateinit var mPath: Path
    private lateinit var mBitmap: Bitmap
    private lateinit var mPaint: Paint

    init {
        initData()
    }

    private fun initData() {
        mBitmap = BitmapFactory.decodeResource(resources, R.mipmap.test)
        mPath = Path()
        mPath.addArc(0f, 0f, mBitmap.width.toFloat(), mBitmap.height.toFloat(), 0f, 360f)

        mPaint = Paint()
        mPaint.isAntiAlias = true
        mPaint.isFilterBitmap = true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(mBitmap.height, mBitmap.width)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.clipPath(mPath)
        canvas?.drawBitmap(mBitmap, 0f, 0f, mPaint)



    }
}