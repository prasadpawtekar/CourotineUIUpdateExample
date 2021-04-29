package com.apolis.courotineuiupdateexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.apolis.courotineuiupdateexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding.data = viewModel

        setObservers()
        btnStartTimer.setOnClickListener {
            viewModel.startCounter()
        }
        btnGlobalActivity.setOnClickListener {
            startActivity(Intent(baseContext, GlobalScopeTestActivity::class.java))
        }
    }

    fun setObservers() {
        viewModel.cs.observe(this) {
            when(it) {
                MainActivityViewModel.CounterState.STARTED -> {
                    btnStartTimer.visibility = View.GONE
                }

                MainActivityViewModel.CounterState.STOPPED -> {
                    btnStartTimer.visibility = View.VISIBLE
                }
            }
        }

    }
}