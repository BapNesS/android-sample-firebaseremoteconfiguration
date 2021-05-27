package com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.base

import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.R
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.base.BaseViewModel
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.result.ResultActivity
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.start

abstract class BaseActivity : AppCompatActivity() {

    abstract var viewModel : BaseViewModel

    protected fun initListeners() {
        findViewById<Button>(R.id.btn).setOnClickListener {
            viewModel.initLoading()
        }
    }

    protected  fun initObservers() {
        viewModel.data.observe(this, Observer {
            if ( it != null ) {
                findViewById<TextView>(R.id.content)?.text = it
                //goResult()
            }
        })
    }

    private fun goResult() {
        Log.d("Sample", "Open ResultActivity")
        start(ResultActivity::class.java)
    }
}