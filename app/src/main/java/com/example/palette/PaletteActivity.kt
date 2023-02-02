package com.example.palette

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette

class PaletteActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette)

        val bundle = intent.extras
        val imagen = bundle?.get("image") as Int
        val transicion = bundle.getString("transicionFoto") as String
        val imageView = findViewById<ImageView>(R.id.imageView)
        val toolbar = findViewById(R.id.toolc) as androidx.appcompat.widget.Toolbar

        imageView.transitionName = transicion

        val lightVibrantText = findViewById<TextView>(R.id.LightVibrant)
        val mutedText = findViewById<TextView>(R.id.Muted)
        val DarkMutedText = findViewById<TextView>(R.id.DarkMuted)
        val lightMutedText = findViewById<TextView>(R.id.LightMuted)

        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, imagen)

        Palette.from(bitmap).generate() { palette ->

            val vibrant: Palette.Swatch? = palette?.vibrantSwatch
            val darkVibrant: Palette.Swatch? = palette?.darkVibrantSwatch
            val lightVibrant: Palette.Swatch? = palette?.lightVibrantSwatch
            val muted: Palette.Swatch? = palette?.mutedSwatch
            val darkMuted: Palette.Swatch? = palette?.darkMutedSwatch
            val lightMuted: Palette.Swatch? = palette?.lightMutedSwatch

            if (vibrant != null) {
                toolbar.setBackgroundColor(vibrant.rgb)
                toolbar.setTitleTextColor(vibrant.titleTextColor)
            }
            if (darkVibrant != null) {
                window.statusBarColor = darkVibrant.rgb
            }
            if (lightVibrant != null) {
                lightVibrantText.setBackgroundColor(lightVibrant.rgb)
                lightVibrantText.text = "Light Vibrant"
                lightVibrantText.setTextColor(lightVibrant.titleTextColor)
            } else
                lightVibrantText.height = 0
            if (muted != null) {
                mutedText.setBackgroundColor(muted.rgb)
                mutedText.text = "Muted"
                mutedText.setTextColor(muted.titleTextColor)
            } else
                mutedText.height = 0
            if (darkMuted != null) {
                DarkMutedText.setBackgroundColor(darkMuted.rgb)
                DarkMutedText.text = "Dark Muted"
                DarkMutedText.setTextColor(darkMuted.titleTextColor)
            } else
                DarkMutedText.height = 0
            if (lightMuted != null) {
                lightMutedText.setBackgroundColor(lightMuted.rgb)
                lightMutedText.text = "Light Muted"
                lightMutedText.setTextColor(lightMuted.titleTextColor)
            } else
                lightMutedText.height = 0
        }

        imageView.setImageResource(imagen)

// para color de la barra de notificaciones --> window.statusBarColor=
    }
}

