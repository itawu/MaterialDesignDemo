package com.yurensan.palette

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.pg)
        val tvDarkMutedColor = findViewById<TextView>(R.id.tvDarkMutedColor)
        val tvDarkVibrantColor = findViewById<TextView>(R.id.tvDarkVibrantColor)
        val tvLightVibrantColor = findViewById<TextView>(R.id.tvLightVibrantColor)
        val tvLightMutedColor = findViewById<TextView>(R.id.tvLightMutedColor)
        val tvVibrantColor = findViewById<TextView>(R.id.tvVibrantColor)
        val tvMutedColor = findViewById<TextView>(R.id.tvMutedColor)
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageBitmap(bitmap)

        Palette.from(bitmap).generate { palette ->
            val darkMutedColor: Int = palette!!.getDarkMutedColor(Color.BLUE)
            val darkVibrantColor: Int = palette.getDarkVibrantColor(Color.BLUE)
            val lightVibrantColor: Int = palette.getLightVibrantColor(Color.BLUE)
            val lightMutedColor: Int = palette.getLightMutedColor(Color.BLUE)
            val vibrantColor: Int = palette.getVibrantColor(Color.BLUE)
            val mutedColor: Int = palette.getMutedColor(Color.BLUE)
            tvDarkMutedColor.setBackgroundColor(darkMutedColor)
            tvDarkVibrantColor.setBackgroundColor(darkVibrantColor)
            tvLightMutedColor.setBackgroundColor(lightMutedColor)
            tvLightVibrantColor.setBackgroundColor(lightVibrantColor)
            tvMutedColor.setBackgroundColor(mutedColor)
            tvVibrantColor.setBackgroundColor(vibrantColor)
        }
    }
}