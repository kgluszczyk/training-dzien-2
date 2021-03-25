package com.gluszczykk.dzien3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class MainActivityViewModel : ViewModel() {

    private val actionStream = MutableLiveData<State>()

    val actionObservableStream = actionStream as LiveData<State>
    var operacja: Job? = null

    fun action(action: Brightness) {
        operacja?.cancel()
        operacja = viewModelScope.launch {
            actionStream.postValue(State.Laduj)
            withContext(Dispatchers.Default) {
                repeat(10) {
                    longOperation()
                }
            }
            actionStream.postValue(State.Zaladowano(action))
        }
    }

    private fun longOperation() {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1))
    }

    sealed class State {
        data class Zaladowano(val brightness: Brightness) : State()
        object Laduj : State()
    }

}