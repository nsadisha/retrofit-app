package com.nsadisha.retrofitapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsadisha.retrofitapp.adapter.VideoAdapter
import com.nsadisha.retrofitapp.databinding.FragmentHomeBinding
import com.nsadisha.retrofitapp.util.Utility.Companion.p
import com.nsadisha.retrofitapp.util.Utility.Companion.showErrorAlert
import com.nsadisha.retrofitapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private val adapter = VideoAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding =  FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupRecyclerview()

        viewModel.videos.observe(viewLifecycleOwner) {
            if (it.isSuccessful) {
                val res = it.body()
                adapter.setData(res!!.videos)
            } else {
                p("Unsuccessful")
            }
        }

        viewModel.isLoadingCompleted.observe(viewLifecycleOwner) {
            if (it) binding.progressBar.visibility = View.GONE
        }

        viewModel.onErrorOccurred.observe(viewLifecycleOwner){
            if(it) showErrorAlert(requireContext(), "Error loading data!")
        }

        return binding.root
    }

    private fun setupRecyclerview(){
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
    }
}