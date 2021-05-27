package com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.async

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.R
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.base.BaseActivity
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.base.BaseViewModel

class AsyncActivity : BaseActivity() {

    override lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch)

        viewModel = ViewModelProvider(this).get(AsyncViewModel::class.java)

        initListeners()
        initObservers()
    }

}