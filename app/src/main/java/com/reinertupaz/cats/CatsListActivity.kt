package com.reinertupaz.cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reinertupaz.cats.adapter.CatsAdapter
import com.reinertupaz.cats.rest.ApiInterface
import com.reinertupaz.cats.rest.RetrofitClient

class CatsListActivity : AppCompatActivity() {

    private lateinit var rcvCats: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats_list)

        rcvCats = findViewById(R.id.rcvCats)

        doGetCats();
    }

    fun doGetCats() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getCats()
                if (response.isSuccessful()) {
                    var cats = response.body()
                    if (cats != null) {
                        rcvCats.layoutManager = LinearLayoutManager(this@CatsListActivity, LinearLayoutManager.VERTICAL, false)
                        val catsAdapter = CatsAdapter(cats)
                        rcvCats.adapter = catsAdapter
                    }
                } else {
                    Toast.makeText(
                        this@CatsListActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }
        lifecycleScope.launchWhenStarted {

        }
    }
}