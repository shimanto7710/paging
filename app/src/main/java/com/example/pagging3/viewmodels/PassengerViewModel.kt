package com.example.pagging3.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pagging3.repository.PassengerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PassengerViewModel @Inject constructor(private val repository: PassengerRepository) : ViewModel() {
    val list = repository.getQuotes().cachedIn(viewModelScope)
}