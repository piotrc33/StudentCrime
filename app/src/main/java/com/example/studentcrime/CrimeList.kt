package com.example.studentcrime

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

object CrimeList {
    lateinit var x: Number
    var crimeList: ArrayList<Crime> = arrayListOf()

    fun generate() {
        for(i in 1..20) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val formatted = current.format(formatter)
            crimeList.add(Crime(i, "crime #$i", formatted, "crime description #$i", Random.nextBoolean() ))
        }
    }
}