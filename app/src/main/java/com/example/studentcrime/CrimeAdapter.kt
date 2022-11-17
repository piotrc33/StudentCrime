package com.example.studentcrime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity
import com.example.studentcrime.ListFragment as ListFragment1

class CrimeAdapter(private val crimeList: ArrayList<Crime>, val handler: CrimeAdapter.Callbacks)
    : RecyclerView.Adapter<CrimeAdapter.CrimeViewHolder>(){
    class CrimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView : TextView = itemView.findViewById(R.id.crime_title)
        val dateTextView : TextView = itemView.findViewById(R.id.crime_date)
        val crimeCardView : CardView = itemView.findViewById(R.id.crime_card_view)
//        private val viewModel = ViewModelProvider(MainAc)[CrimeViewModel::class.java]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crime_item, parent, false)
        return CrimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
        val crime = crimeList[position]
        holder.titleTextView.text = crime.title
        holder.dateTextView.text = crime.date
        if(crime.isSolved)
            holder.imageView.setImageResource(R.drawable.checkmark)
        else
            holder.imageView.setImageResource(0)

        holder.crimeCardView.setOnClickListener {
            holder.crimeCardView.findNavController().navigate(R.id.action_listFragment_to_detailFragment)
            handler.handleUserData(crime)
        }
    }

    override fun getItemCount(): Int {
        return crimeList.size
    }

    interface Callbacks {
        fun handleUserData(data: Crime)
    }
}