package com.example.pong

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class PongView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    // Set up the initial position and velocity of the ball
    private var ballX = 50f
    private var ballY = 50f
    private val ballRadius = 20f
    private var ballSpeedX = 5f
    private var ballSpeedY = 5f

    // Set up the paint objects for drawing
    private val ballPaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw the ball at its current position
        canvas.drawCircle(ballX, ballY, ballRadius, ballPaint)

        // Update the position of the ball
        ballX += ballSpeedX
        ballY += ballSpeedY

//         Bounce the ball off the edges of the view
        if (ballX + ballRadius > width || ballX - ballRadius < 0) {
            ballSpeedX = -ballSpeedX
        }
        if (ballY + ballRadius > height || ballY - ballRadius < 0) {
            ballSpeedY = -ballSpeedY
        }

        // Redraw the view
        invalidate()
    }
}
