package com.example.user.uiexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Animation2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation2)

        val fab1: FloatingActionButton = findViewById(R.id.fab1)
        startSpringAnimation(fab1)
    }

    private fun startSpringAnimation(view: View) {
        val animation = SpringAnimation(view, SpringAnimation.X)
        val spring = SpringForce()
        spring.finalPosition = 300f
        spring.stiffness = SpringForce.STIFFNESS_VERY_LOW
        spring.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        animation.spring = spring
        animation.start()
    }
}
