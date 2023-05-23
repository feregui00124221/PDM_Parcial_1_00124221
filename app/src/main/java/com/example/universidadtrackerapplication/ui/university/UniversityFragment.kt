package com.example.universidadtrackerapplication.ui.university

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.universidadtrackerapplication.data.model.UniversityModel
import com.example.universidadtrackerapplication.databinding.FragmentUniversityBinding
import com.example.universidadtrackerapplication.ui.university.viewmodel.UniversityViewModel

class UniversityFragment: Fragment() {

    private lateinit var binding: FragmentUniversityBinding
    private val movieViewModel: UniversityViewModel by activityViewModels{
        UniversityViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUniversityBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = movieViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }
}