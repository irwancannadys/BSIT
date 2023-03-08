package com.irwan.bsit.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irwan.bsit.domain.usecase.TransactionUseCase
import com.irwan.bsit.model.TransactionResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val transactionUseCase: TransactionUseCase
) : ViewModel() {

    private val _transaction = MutableLiveData<List<TransactionResponse>>()
    val transaction: LiveData<List<TransactionResponse>>
        get() = _transaction

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean>
        get() = _showLoading

    fun getTransaction() = viewModelScope.launch {
        _showLoading.postValue(true)
        transactionUseCase.getTransaction().let {
            if (it.isSuccessful) {
                _transaction.postValue(it.body())
                _showLoading.postValue(false)
            } else {
                _errorMessage.postValue(it.message())
                _showLoading.postValue(false)
            }
        }
    }
}