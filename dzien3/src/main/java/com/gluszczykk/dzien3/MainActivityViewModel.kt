package com.gluszczykk.dzien3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.concurrent.TimeUnit

class MainActivityViewModel : ViewModel() {

    private val actionStream = MutableLiveData<State>()

    val actionObservableStream = actionStream as LiveData<State>

    fun action(action: Brightness) {
        Thread {
            actionStream.postValue(State.Laduj)
            repeat(10) {
                longOperation()
            }
            actionStream.postValue(State.Zaladowano(action))
        }.start()
    }

    private fun longOperation() {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1))
    }

    sealed class State {
        data class Zaladowano(val brightness: Brightness) : State()
        object Laduj : State()
    }

}