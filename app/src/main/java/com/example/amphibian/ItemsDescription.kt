package com.example.amphibian

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.amphibian.databinding.FragmentItemsDescriptionBinding

class ItemsDescription : Fragment() {

    private lateinit var binding: FragmentItemsDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using DataBindingUtil
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_items_description, container, false)

        // Receive the data passed from the previous fragment
        val name = arguments?.getString("name")
        val description = arguments?.getString("description")

        // Bind the received data to the XML
        binding.name = name
        binding.description = description

        // Set the lifecycle owner so that LiveData can observe lifecycle changes
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}
