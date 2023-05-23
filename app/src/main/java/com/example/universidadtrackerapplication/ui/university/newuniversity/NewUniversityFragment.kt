package com.example.universidadtrackerapplication.ui.university.newuniversity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.universidadtrackerapplication.databinding.FragmentNewUniversityBinding
import com.example.universidadtrackerapplication.ui.university.viewmodel.UniversityViewModel

class NewUniversityFragment: Fragment() {

    private lateinit var binding: FragmentNewUniversityBinding

    private val viewModel: UniversityViewModel by activityViewModels{
        UniversityViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_new_movie, container, false)
        binding = FragmentNewUniversityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        setObserver()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun setObserver(){
        viewModel.status.observe(viewLifecycleOwner) {status ->
            when{
                status.equals(UniversityViewModel.CREATED) -> {
                    Log.d("TAG APP", status)
                    Log.d("TAG APP", viewModel.getUniversities().toString())

                    Toast.makeText(this.context, status, Toast.LENGTH_SHORT).show()

                    viewModel.clearData()
                    viewModel.clearStatus()

                    findNavController().popBackStack()
                }status.equals(UniversityViewModel.INVALID) -> {
                Log.d("TAG APP", status)

                Toast.makeText(this.context, status, Toast.LENGTH_SHORT).show()
            }
            }
            Toast.makeText(this.context, status, Toast.LENGTH_SHORT).show()
        }
    }

}