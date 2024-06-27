package com.example.user.uiexample

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Property
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.user.uiexample.interpolators.SpringInterpolator
import kotlin.reflect.KFunction0

class Animation4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation4)

        val rv: RecyclerView = findViewById(R.id.rv)
        val list = ArrayList<String>()
        addData(list)

        rv.adapter = RvAdapter(list)
    }

    inner class RvAdapter(private val list: ArrayList<String>) :
        RecyclerView.Adapter<RvAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_anim_example, parent, false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            animateView(
                holder.itemView,
                0,
                700,
                SpringInterpolator(),
                View.TRANSLATION_X,
                -200f,
                0f,
                0,
                Animation.ABSOLUTE,
                false,
                50f,
                50f,
                null
            )

            holder.itemView.setOnClickListener {
                if (holder.adapterPosition % 2 == 0) animateView(
                    holder.itemView,
                    0,
                    100,
                    LinearInterpolator(),
                    View.ROTATION_X,
                    0f,
                    -5f,
                    1,
                    Animation.REVERSE,
                    false,
                    50f,
                    0f,
                    ::openView
                )
                else animateView(
                    holder.itemView,
                    0,
                    100,
                    LinearInterpolator(),
                    View.ROTATION_Y,
                    0f,
                    5f,
                    1,
                    Animation.REVERSE,
                    false,
                    0f,
                    50f,
                    ::openView
                )
//                Handler().postDelayed({
//                    val intent = Intent(this@Animation4Activity, Animation5Activity::class.java)
//                    startActivity(intent)
//                    overridePendingTransition(R.anim.anim_scale_up, R.anim.anim_blank)
//                }, 200)
            }
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        private fun animateView(
            view: View,
            startDelay: Long,
            duration: Long,
            interpolator: Interpolator,
            property: Property<View, Float>,
            from: Float,
            to: Float,
            repeatCount: Int,
            repeatMode: Int,
            isInterpolationOnce: Boolean,
            pivotX: Float,
            pivotY: Float,
            workFunctionOnEnd: KFunction0<Unit>?
        ) {
            // WHERE PIVOT IS PERCENTAGE VALUE START FROM 0 TO 100
            // WHERE workFunctionOnEnd IS THE FUNCTION WHICH WANT TO BE WORKED ON END ANIMATION
            view.post({
                val oa = ObjectAnimator.ofFloat(view, property, from, to)
                view.visibility = View.INVISIBLE
                oa.interpolator = interpolator
                oa.startDelay = startDelay
                oa.repeatCount = repeatCount
                oa.repeatMode = repeatMode
                oa.duration = duration
                view.pivotX = (view.width * pivotX) / 100
                view.pivotY = (view.height * pivotY) / 100
                oa.addListener(object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(animation: Animator?) {
                        if (isInterpolationOnce) animation?.interpolator = LinearInterpolator()
                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        if (workFunctionOnEnd != null) workFunctionOnEnd()
                    }

                    override fun onAnimationCancel(animation: Animator?) {
                    }

                    override fun onAnimationStart(animation: Animator?) {
                        view.visibility = View.VISIBLE
                    }
                })
                oa.start()
            })
        }
    }

    private fun openView() {
        val intent = Intent(this, Animation5Activity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.anim_scale_up, R.anim.anim_blank)
    }

    private fun addData(list: ArrayList<String>) {
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
        list.add("ABCD")
    }
}
