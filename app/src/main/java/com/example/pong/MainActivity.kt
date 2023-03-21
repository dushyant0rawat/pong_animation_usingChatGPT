package com.example.pong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Transformation

class MainActivity : AppCompatActivity() {

    private lateinit var pongView: PongView
    private lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a reference to the PongView from the layout file
        pongView = findViewById(R.id.pong_view)

        // Create an Animation object to update the position of the ball on each frame
        animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {

            }
        }

        // Set some properties of the Animation object
        animation.apply {
            duration = 16   // 60 FPS
            repeatCount = Animation.INFINITE
        }

        // Start the animation
        pongView.startAnimation(animation)
    }
}
