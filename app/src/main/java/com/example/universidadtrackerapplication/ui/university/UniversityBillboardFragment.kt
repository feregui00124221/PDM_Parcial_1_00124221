package com.example.universidadtrackerapplication.ui.university

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.universidadtrackerapplication.R
import com.example.universidadtrackerapplication.data.model.UniversityModel
import com.example.universidadtrackerapplication.databinding.FragmentUniversitiesBillboardBinding
import com.example.universidadtrackerapplication.ui.university.recyclerview.UniversityRecyclerViewAdapter
import com.example.universidadtrackerapplication.ui.viewmodel.UniversityViewModel

class UniversityBillboardFragment: Fragment() {

    //  BINDING and VM block variable declaration
    private lateinit var binding: FragmentUniversitiesBillboardBinding

    private val universityViewModel: UniversityViewModel by activityViewModels {
        UniversityViewModel.Factory
    }

    private lateinit var adapter: UniversityRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUniversitiesBillboardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnCreteNewUniversity.setOnClickListener {
            universityViewModel.clearData()
            universityViewModel.clearStatus()
//            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }
    }

    private fun showSelectedItem(_university: UniversityModel) {

        universityViewModel.setSelectedUniversity(_university)

//        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)

    }

        fun setRecyclerView(view: View) {
            binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

            adapter = UniversityRecyclerViewAdapter { selectedUniversity ->
                showSelectedItem(selectedUniversity)
            }

            binding.recyclerView.adapter = adapter

            displayUniversities()

        }

        fun displayUniversities() {

            adapter.setData(universityViewModel.getUniversities())

            adapter.notifyDataSetChanged()

        }
    }