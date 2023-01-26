package com.example.palette

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class PaletteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette)

        val bundle = intent.extras
        val imagen = bundle?.get("image") as Int
        val imageView = findViewById<ImageView>(R.id.imageView)

    imageView.setImageResource(imagen)
        //usar imagen y no imageView para sacar colores
// para color de la barra de notificaciones --> window.statusBarColor=
    }
}

