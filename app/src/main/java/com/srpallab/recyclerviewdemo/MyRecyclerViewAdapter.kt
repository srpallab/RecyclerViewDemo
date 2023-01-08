package com.srpallab.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    private val fruitsList: List<Fruits>,
    private val clickListener: (Fruits)->Unit
) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruitsList[position]
        holder.bind(fruit, clickListener)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }
}

class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruits, clickListener: (Fruits)->Unit){
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name

        view.setOnClickListener{
            clickListener(fruit)
        }
    }

}