package com.example.taskdvm02

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdvm02.model.DataModel
import com.example.taskdvm02.model.Value

class CustomAdapter(var theList:DataModel, val context: Context):RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list, parent, false))
    }

    override fun getItemCount(): Int {
        return theList.value.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val value=theList.value.get(position)

        holder.id.text=value.id

        holder.joke.text=value.joke
    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {

           val id=itemLayoutView.findViewById<TextView>(R.id.id)
           val joke=itemLayoutView.findViewById<TextView>(R.id.joke)
        }

    }