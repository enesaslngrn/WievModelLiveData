package com.enesas.wievmodellivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel(){

    var number = 0

    val currentNumber = MutableLiveData<Int>()
    val currentBoolean = MutableLiveData<Boolean>()


}