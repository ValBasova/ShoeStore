package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private lateinit var myShoeList: MutableList<Shoe>

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        setList()
        _shoeList.value = myShoeList
    }

    private fun setList() {
        myShoeList = mutableListOf<Shoe>(
            Shoe("Sneakers", 6.0, "Company1", "yellow"),
            Shoe("Boots", 9.5, "Company1", "high heels, green"),
            Shoe("Raining boots", 3.0, "Company1", "blue and yellow"),
            Shoe("Kids Sneakers", 6.5, "Company2", "waterproof"),
            Shoe("Shoes", 4.0, "Company2", "just shoes"),
            Shoe("Sneakers", 5.0, "Company2", "another sneakers"),
            Shoe("Sandals", 7.0, "Company2", "for summer fun"),
            Shoe("Uggs", 7.5, "Company3", "for winter fun"),
            Shoe("Sneakers", 7.0, "Company3", "one more"),
            Shoe("Sandals", 9.0, "Company3", "for warm weather"),
            Shoe("Uggs", 11.0, "Company3", "another uggs"),
            Shoe("Mary jane shoes", 4.5, "Company3", "beautiful ones")
        )
    }

    fun addNewShoe(shoe: Shoe) {
        myShoeList.add(shoe)
    }
}