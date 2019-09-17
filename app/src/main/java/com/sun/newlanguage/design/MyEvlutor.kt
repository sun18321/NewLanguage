package com.sun.newlanguage.design

import android.animation.TypeEvaluator
import android.graphics.PointF
import android.util.Log
import kotlin.math.*

class MyEvlutor:TypeEvaluator<PointF> {
    override fun evaluate(fraction: Float,startPoint: PointF?, endPoint: PointF?): PointF {

        Log.d("evaluator", "fraction:$fraction---start:$startPoint----end:$endPoint")

        val firstPoint = PointF(540f, 632f)
        val secondPoint = PointF(540f, 1032f)




        val xDistance = secondPoint.x - firstPoint.x
        val yDistance = secondPoint.y - firstPoint.y
        val radius = sqrt(xDistance.pow(2) + yDistance.pow(2)) / 2
        val center = PointF((secondPoint.x + firstPoint.x) / 2, (secondPoint.y + firstPoint.y) / 2)

        var angle = Math.toRadians((fraction * 360).toDouble())

//        Log.d("evaluator", "radius:$radius---center:$center---sin:${sin(Math.toRadians(angle))}")

        val returnX = (center.x + radius * sin(angle)).toFloat()
        val returnY = (center.y + radius * cos(angle)).toFloat()

        Log.d("evaluator", "angle before:${(fraction * 360).toDouble()}-----angle:$angle----sin:${sin(Math.toRadians(angle))}return x:$returnX-----return y:$returnY")
        return PointF(returnX, returnY)


    }
}