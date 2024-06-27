package com.beegains.heartofvolley.widgets

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.RelativeLayout


/**
 * Created by User on 24-01-2018.
 */
class RoundedRelativeLayout : RelativeLayout {
    companion object {
        private const val RADIUS = 50f
    }

    private val path = Path()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        // CIRCLE
        // compute the path
//        val halfWidth = w / 2f
//        val halfHeight = h / 2f
//        path.reset()
//        path.addCircle(halfWidth, halfHeight, Math.min(halfWidth, halfHeight), Path.Direction.CW)
//        path.close()

        // ROUNDED RECTANGLE
        val rect = RectF()
        path.reset()
        rect.set(0f, 0f, w.toFloat(), h.toFloat())
        path.addRoundRect(rect, RADIUS, RADIUS, Path.Direction.CW)
        path.close()
    }

    override fun dispatchDraw(canvas: Canvas) {
        val save = canvas.save()
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }
}