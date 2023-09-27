package com.example.amphibian

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amphibian.databinding.FragmentItemViewsBinding
import androidx.navigation.fragment.findNavController



class ItemViews : Fragment() {

    private lateinit var binding: FragmentItemViewsBinding
    private val viewModel: OverViewModel by activityViewModels()


    companion object {
        private const val TAG = "ItemViewsFragment"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_item_views,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        Log.d(TAG, "onCreateView called")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "the first data is = ${viewModel.amphibianData.value?.size}")

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // does that whenever something change with the data then it will fetch the data from the internet again??
        viewModel.amphibianData.observe(viewLifecycleOwner) { data ->
            if (data.isNotEmpty()) {
                val adapter = AmphibianViewAdapter(data) { clickedData ->
                    // Bundle to pass data

                    val bundle = Bundle()
                    bundle.putString("name", clickedData.name)
                    Log.d(TAG, "Item clicked: ${clickedData.name}")
                    bundle.putString("description", clickedData.description)

                    // Navigate using NavController and pass the bundle
                    //findNavController().navigate(R.id.items_description, bundle)
                    Log.d(TAG, "onCreateView called and data parsed")
                    Log.d(TAG, "the data is = ${data.size}")

                    findNavController().navigate(R.id.action_item_views_to_items_description, bundle)

                }

                Log.d("Data Count = ","${adapter.itemCount}")

                recyclerView.adapter = adapter
            }
        }

    }
}