package com.srpallab.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val fruitsList = listOf<Fruits>(
        Fruits("Mango" , "BD"),
        Fruits("Apple" , "BD"),
        Fruits("Banana" , "BD"),
        Fruits("Guava" , "BD"),
        Fruits("Lemon" , "BD"),
        Fruits("Pear" , "BD"),
        Fruits("Orange" , "BD"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.CYAN)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitsList) { selectedItem: Fruits ->
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruit: Fruits){
        Toast.makeText(
           this@MainActivity, "Supplier is : ${fruit.supplier}", Toast.LENGTH_LONG
        ).show()
    }
}