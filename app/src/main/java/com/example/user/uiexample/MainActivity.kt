package com.example.user.uiexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabPlay = findViewById<FloatingActionButton>(R.id.fabPlay)
        val ivMain = findViewById<ImageView>(R.id.ivMain)
        val layoutParent = findViewById<View>(R.id.layoutParent)

        ivMain.startAnimation(
            AnimationUtils.loadAnimation(
                this,
                R.anim.anim_main_transition_to_right
            )
        )

        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_fab_right_to_left)
        fabPlay.startAnimation(animation)

        ivMain.setOnClickListener {
            startActivity(Intent(this, Animation1Activity::class.java))
        }

        fabPlay.setOnClickListener {
            startActivity(Intent(this, BlurActivity::class.java))
        }

        layoutParent.setOnClickListener {
            startActivity(Intent(this, Animation4Activity::class.java))
        }
    }
}
