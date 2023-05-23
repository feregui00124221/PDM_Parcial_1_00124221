package com.example.universidadtrackerapplication.repository

import com.example.universidadtrackerapplication.data.model.UniversityModel

class UniversityRepository (private val universityList: MutableList<UniversityModel>){

    fun getUniversities():MutableList<UniversityModel> = universityList

    fun addUniversity(newUniversity: UniversityModel) {
        universityList.add(0, newUniversity)
    }

}