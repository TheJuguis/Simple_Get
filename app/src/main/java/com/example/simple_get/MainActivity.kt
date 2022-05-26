package com.example.simple_get

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var queve: RequestQueue
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        queve = Volley.newRequestQueue(this)
    }

    fun getPokemonList(listAmount: Int){
        val url ="https://pokeapi.co/api/v2/pokemon/?limit=${listAmount}"

        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{ response->
            //  PENDIENTE
        },
        Response.ErrorListener {
            // PENDIENTE
        })

        queve.add(jsonRequest)
    }

    override fun onStop() {
        super.onStop()
        queve.cancelAll("Detenido")
    }
}