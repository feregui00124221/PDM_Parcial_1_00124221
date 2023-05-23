package com.example.universidadtrackerapplication.ui.university.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.universidadtrackerapplication.data.model.UniversityModel
import com.example.universidadtrackerapplication.databinding.UniversityItemBinding

class UniversityRecyclerViewAdapter(private val clickListener: (UniversityModel) -> Unit ): RecyclerView.Adapter<UniversityRecyclerViewHolder>(){

    private val universities = ArrayList<UniversityModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UniversityRecyclerViewHolder {
        val binding = UniversityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return UniversityRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UniversityRecyclerViewHolder, position: Int) {
        val _university = universities[position]

        holder.bind(_university, clickListener)
    }

    override fun getItemCount(): Int {
        return universities.size
    }

    fun setData(_universitiesList: List<UniversityModel>){
        universities.clear()
        universities.addAll(_universitiesList)
    }
}