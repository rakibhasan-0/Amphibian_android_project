package com.example.amphibian

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.util.Log

class OverViewModel : ViewModel() {

    private val _amphibianData = MutableLiveData<List<AmphibianData>>()
    val amphibianData: LiveData<List<AmphibianData>> get() = _amphibianData

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                val data = AmphibianAPI.retrofitService.getPhotos()
                _amphibianData.value = data
            } catch (e: Exception) {
                Log.e("OverViewModel", "Error fetching data:", e)
            }
        }
    }

}
