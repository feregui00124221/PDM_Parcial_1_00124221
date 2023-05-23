package com.example.universidadtrackerapplication.ui.university.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.universidadtrackerapplication.data.model.UniversityModel
import com.example.universidadtrackerapplication.databinding.UniversityItemBinding
import com.example.universidadtrackerapplication.ui.viewmodel.UniversityViewModel

class UniversityRecyclerViewHolder (private val binding: UniversityItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(_university: UniversityModel, clickListener: (UniversityModel) -> Unit) {

        binding.txtName.text = _university.name

        binding.txtLocation.text = _university.location

        binding.universityItemCardView.setOnClickListener{
            clickListener(_university)
        }
    }
}