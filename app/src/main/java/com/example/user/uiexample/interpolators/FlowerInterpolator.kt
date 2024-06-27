package com.example.user.uiexample.interpolators

import android.view.animation.Interpolator

class FlowerInterpolator : Interpolator {
    override fun getInterpolation(t: Float): Float {
        return getInterpolator(t).toFloat()
    }

    private fun getInterpolator(t: Float): Double {
        return Math.cos(3.toDouble() * t) + Math.sin(4 * t.toDouble()) + 2
    }
}