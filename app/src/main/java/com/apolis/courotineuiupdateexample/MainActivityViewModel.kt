package com.apolis.courotineuiupdateexample

import android.database.Observable
import android.util.Log
import android.view.View
import androidx.databinding.ObservableLong
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivityViewModel: ViewModel() {
    val simpleDateFormat = SimpleDateFormat("mm:ss")
    val url = "https://images.idgesg.net/images/article/2020/08/android-awkward-timing-100855433-large.jpg"
    val time = ObservableLong(0)

    val cs = MutableLiveData<CounterState>()

    fun initTime() {
        cs.value = CounterState.STARTED
        time.set(simpleDateFormat.parse("01:00").time)
    }

    fun decrementCounter() {
        time.set(time.get() - 1000)
    }

    public fun startCounter() {
        viewModelScope.launch() {
            initTime()
            for (i in 1..60) {
                decrementCounter()
                delay(1000)
            }
            cs.value = CounterState.STOPPED
        }
    }

    enum class CounterState {
        STARTED, STOPPED
    }
}

