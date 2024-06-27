package com.example.user.uiexample

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Property
import android.view.View
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import com.example.user.uiexample.interpolators.SpringInterpolator

class Animation1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_animation1)

        val layoutBPolice: View = findViewById(R.id.layoutBPolice)
        val layoutBIncident: View = findViewById(R.id.layoutBIncident)
        val layoutBottom: View = findViewById(R.id.layoutBottom)
        val ivVideo: View = findViewById(R.id.ivVideo)
        val tvNearest: View = findViewById(R.id.tvNearest)
        val tvDistance: View = findViewById(R.id.tvDistance)
        val tvPlace: View = findViewById(R.id.tvPlace)
        val ivSun: View = findViewById(R.id.ivSun)
        val ivChild: View = findViewById(R.id.ivChild)

        animateView(layoutBPolice, 0, 1000, SpringInterpolator(), View.TRANSLATION_Y, 300f, 0f, Animation.ABSOLUTE, false)
        animateView(layoutBIncident, 400, 1000, SpringInterpolator(), View.TRANSLATION_Y, 300f, 0f, Animation.ABSOLUTE, false)
        animateView(layoutBottom, 300, 1000, SpringInterpolator(), View.TRANSLATION_Y, 500f, 0f, Animation.ABSOLUTE, false)
        animateView(ivVideo, 600, 300, AccelerateInterpolator(), View.TRANSLATION_X, -300f, 0f, Animation.ABSOLUTE, false)
        animateView(tvNearest, 500, 500, LinearInterpolator(), View.ALPHA, 0f, 1.0f, Animation.ABSOLUTE, false)
        animateView(tvDistance, 800, 500, LinearInterpolator(), View.ALPHA, 0f, 1.0f, Animation.ABSOLUTE, false)
        animateView(tvPlace, 1100, 500, LinearInterpolator(), View.ALPHA, 0f, 1.0f, Animation.ABSOLUTE, false)

        animateView(ivSun, 0, 5000, LinearInterpolator(), View.ALPHA, 0f, 1.0f, Animation.ABSOLUTE, false)
        animateView(ivSun, 0, 5000, SpringInterpolator(), View.ROTATION_X, 0f, 180f, Animation.ABSOLUTE, false)

        animateView(ivChild, 0, 2000, LinearInterpolator(), View.ROTATION_Y, 0f, 360f, Animation.INFINITE, false)
    }

    private fun animateView(view: View, startDelay: Long, duration: Long, interpolator: Interpolator, property: Property<View, Float>, from: Float, to: Float, repeatCount: Int, isInterpolationOnce: Boolean) {
        val oa = ObjectAnimator.ofFloat(view, property, from, to)
        view.visibility = View.INVISIBLE
        oa.interpolator = interpolator
        oa.startDelay = startDelay
        oa.repeatCount = repeatCount
        oa.duration = duration
        oa.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                if (isInterpolationOnce)
                    animation?.interpolator = LinearInterpolator()
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
                view.visibility = View.VISIBLE
            }
        })
        oa.start()
    }
}
