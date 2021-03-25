package com.gluszczykk.dzien3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val actionStream = MutableLiveData<Brightness>()
}