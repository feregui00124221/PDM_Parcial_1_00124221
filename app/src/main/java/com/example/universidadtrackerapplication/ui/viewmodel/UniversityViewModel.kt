package com.example.universidadtrackerapplication.ui.viewmodel

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.universidadtrackerapplication.UniversityTrackerApplication
import com.example.universidadtrackerapplication.data.model.UniversityModel
import com.example.universidadtrackerapplication.repository.UniversityRepository

class UniversityViewModel(private val repository: UniversityRepository): ViewModel() {

    //  Declaracion de variables a utilizar
    var name = MutableLiveData<String>("")
    var location = MutableLiveData<String>("")
    var status = MutableLiveData<String>("")

    fun getUniversities(): List<UniversityModel> = repository.getUniversities()

    fun addUniversity(newUniversity: UniversityModel) {
        repository.addUniversity(newUniversity)
    }

    private fun isUniversityValid(): Boolean = !(name.value.isNullOrEmpty() || location.value.isNullOrEmpty())

    fun createUniversity(){

        if(!isUniversityValid()){
            status.value = INVALID
            return
        }

        val newUniversity = UniversityModel(name.value.toString(), location.value.toString())

        addUniversity(newUniversity)

        status.value = CREATED
    }

    fun clearData(){
        name.value = ""
        location.value = ""
    }

    fun clearStatus(){
        status.value = BASE
    }

    fun setSelectedUniversity(_university: UniversityModel){
        name.value = _university.name
        location.value = _university.location
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as UniversityTrackerApplication

                UniversityViewModel(app.AppUniversityRepository)
            }
        }

        const val CREATED = "University has been successfully created and added to the app."
        const val INVALID = "Either data is empty or field are filled wrongfully. Please check."
        const val BASE = "Base state of university has been set."

    }
}