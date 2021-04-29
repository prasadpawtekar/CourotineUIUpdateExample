package com.apolis.courotineuiupdateexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class GlobalScopeTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TextView(baseContext))
        startTimer()
    }


    public fun startTimer() {
         GlobalScope.launch(Dispatchers.Default) {
             for(i in 1..120) {
                 Log.d("GlobalTimer", "Global timer value: $i")
                 delay(1000)
             }
         }
    }
}