package com.example.palette

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityOptionsCompat
import androidx.palette.graphics.Palette

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.appbar)
        setSupportActionBar(toolbar)

        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.image1)

        Palette.from(bitmap).generate() { palette ->

            val vibrant: Palette.Swatch? = palette?.vibrantSwatch
            val darkVibrant: Palette.Swatch? = palette?.darkVibrantSwatch
            val lightVibrant: Palette.Swatch? = palette?.lightVibrantSwatch
            val muted: Palette.Swatch? = palette?.mutedSwatch
            val darkMuted: Palette.Swatch? = palette?.darkMutedSwatch
            val lightMuted: Palette.Swatch? = palette?.lightMutedSwatch
        }


        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.drawable.image1))
        items.add(Tarjeta(R.drawable.image2))
        items.add(Tarjeta(R.drawable.image3))
        items.add(Tarjeta(R.drawable.image4))
        items.add(Tarjeta(R.drawable.image5))
        items.add(Tarjeta(R.drawable.image6))
        items.add(Tarjeta(R.drawable.image7))
        items.add(Tarjeta(R.drawable.image8))

        val recView = findViewById<RecyclerView>(R.id.recview)

        recView.setHasFixedSize(true)

        val adaptador = CardsAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adaptador.onClick = {

            val imagen =  items.get(recView.getChildAdapterPosition(it)).imagen

            val intent = Intent(this, PaletteActivity::class.java)
            intent.putExtra("image",imagen)

            startActivity(intent)
        }
    }
}