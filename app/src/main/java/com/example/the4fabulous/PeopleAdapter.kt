package com.example.the4fabulous

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class PeopleAdapter(
    var peopleNameList : ArrayList<String>,
    var peopleDetailsList : ArrayList<String>,
    var imageList : ArrayList<Int>,
    var context : Context) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>(){

    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var textViewPersonName : TextView = itemView.findViewById(R.id.textViewIme)
        var textViewDetail : TextView = itemView.findViewById(R.id.textViewOpis)
        var imageView : CircleImageView = itemView.findViewById(R.id.profile_image)
        var cardView : CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_design, parent, false)
        return PeopleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return peopleNameList.size
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {

        holder.textViewPersonName.text = peopleNameList.get(position)
        holder.textViewDetail.text = peopleDetailsList.get(position)
        holder.imageView.setImageResource(imageList.get(position))

        holder.cardView.setOnClickListener {
            Toast.makeText(context, "You selected: ${peopleNameList.get(position)}", Toast.LENGTH_SHORT).show()

        }

    }


}