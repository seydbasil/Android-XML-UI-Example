package com.example.user.uiexample.interpolators

import android.view.animation.Interpolator

class SpringInterpolator : Interpolator {
    override fun getInterpolation(t: Float): Float {
//        val x = 2.0f * t - 1.0f
//        return 0.5f * (x * x * x + 1.0f)
//        return 1.0f * t
//        val factor = 5
//        val power = 2 * factor
//        return findPower(t, power)
        return getSpringInterpolator(t).toFloat()
    }

    private fun findPower(value: Float, power: Int): Float {
        var result = 1f
        for (i in 0 until power) {
            result *= value
        }
        return result
    }


    private fun getSpringInterpolator(t: Float): Double {
        val factor = 0.3f
        return (Math.pow(2.toDouble(), (-10f * t).toDouble()) * Math.sin(((2 * Math.PI) * (t - (factor / 4))) / factor) + 1)
    }
}