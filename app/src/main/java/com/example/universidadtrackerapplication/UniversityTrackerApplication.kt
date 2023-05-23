package com.example.universidadtrackerapplication

import android.app.Application
import com.example.universidadtrackerapplication.data.universitiesListDummyData
import com.example.universidadtrackerapplication.repository.UniversityRepository

class UniversityTrackerApplication: Application() {

    val AppUniversityRepository: UniversityRepository by lazy {
        UniversityRepository(universitiesListDummyData)
    }
}