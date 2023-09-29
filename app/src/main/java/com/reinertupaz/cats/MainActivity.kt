package com.reinertupaz.cats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var btnGetCats: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetCats = findViewById(R.id.btnGetCats)

        btnGetCats.setOnClickListener{
            val intent = Intent(this, CatsListActivity::class.java)
            //intent.putExtra("key", value)
            startActivity(intent)
        }
    }

}