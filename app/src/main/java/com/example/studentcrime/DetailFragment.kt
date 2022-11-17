package com.example.studentcrime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import kotlinx.coroutines.NonDisposableHandle.parent

class DetailFragment : Fragment(), CrimeAdapter.Callbacks {
    private val viewModel: CrimeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val dateTextView : TextView = view.findViewById(R.id.crime_date)
        val titleTextView : TextView = view.findViewById(R.id.crime_title)
        val descTextView : TextView = view.findViewById(R.id.crime_desc)
        titleTextView.text = viewModel.chosenCrime.title
        descTextView.text = viewModel.chosenCrime.desc
        dateTextView.text = viewModel.chosenCrime.date
        // Inflate the layout for this fragment
        return view
    }

    override fun handleUserData(data: Crime) {
        println("handlerDetail")
    }
}