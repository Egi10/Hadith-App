package id.buaja.hadith.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.domain.ResultState
import id.buaja.domain.usecase.HadithUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HadithViewModel @Inject constructor(private val useCase: HadithUseCase) : ViewModel() {
    private var _success = MutableLiveData<Boolean?>()
    val success: LiveData<Boolean?> get() = _success

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> get() = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    init {
        getHadith()
    }

    private fun getHadith() {
        viewModelScope.launch {
            useCase.getHadith()
                .onStart {
                    _loading.value = true
                }
                .onCompletion {
                    _loading.value = false
                }
                .collect {
                    when (it) {
                        is ResultState.Success -> {
                            _success.postValue(it.data)
                        }

                        is ResultState.Error -> {
                            _error.postValue(it.exception)
                        }
                    }
                }
        }
    }
}