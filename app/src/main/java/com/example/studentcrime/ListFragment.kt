package com.example.studentcrime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

class ListFragment : Fragment(), CrimeAdapter.Callbacks {
    private lateinit var recyclerView: RecyclerView
    private lateinit var crimeList: ArrayList<Crime>
    private lateinit var crimeAdapter: CrimeAdapter
    private val viewModel: CrimeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)
        val bundle = arguments
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        crimeList = ArrayList()
        for(i in 1..20) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val formatted = current.format(formatter)
            crimeList.add(Crime(i, "crime #$i", formatted, "crime description #$i", Random.nextBoolean() ))

        }

        crimeAdapter = CrimeAdapter(crimeList, this)
        recyclerView.adapter = crimeAdapter

        return view
    }

    override fun handleUserData(data: Crime) {
        viewModel.chosenCrime = data
        print("crime Clicked: ")
        println(data.id)
    }
}