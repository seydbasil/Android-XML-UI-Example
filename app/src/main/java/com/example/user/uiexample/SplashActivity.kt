package com.example.user.uiexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        val imageView = findViewById<ImageView>(R.id.iv)
        val iv1 = findViewById<ImageView>(R.id.iv1)
        val iv2 = findViewById<ImageView>(R.id.iv2)
        val iv3 = findViewById<ImageView>(R.id.iv3)
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_translation_sample)
        imageView.startAnimation(animation)

        val animationIv1 = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.anim_scale_sample)

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                iv1.startAnimation(animationIv1)
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })

        animationIv1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                val animationIv2 = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.anim_scale_sample)
                iv2.startAnimation(animationIv2)
                animationIv2.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        val animationIv3 = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.anim_scale_sample)
                        iv3.startAnimation(animationIv3)
                        animationIv3.setAnimationListener(object : Animation.AnimationListener {
                            override fun onAnimationRepeat(animation: Animation?) {

                            }

                            override fun onAnimationEnd(animation: Animation?) {
                                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                                finish()
                            }

                            override fun onAnimationStart(animation: Animation?) {
                            }
                        })
                    }

                    override fun onAnimationStart(animation: Animation?) {
                    }
                })

            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })

        val glow = findViewById<RelativeLayout>(R.id.glow)
        val animationGlow = AnimationUtils.loadAnimation(this, R.anim.anim_glow)
        glow.startAnimation(animationGlow)
    }
}
