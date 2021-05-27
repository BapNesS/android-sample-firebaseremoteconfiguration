package com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.result

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.R
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.model.RemoteConfigKey
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.base.BaseActivity
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.util.LocalConfig

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        displayFromLocalConfig()
    }

    private fun displayFromLocalConfig() {
        findViewById<TextView>(R.id.key_a_title)?.text = RemoteConfigKey.KEY_A.name
        findViewById<TextView>(R.id.key_b_title)?.text = RemoteConfigKey.KEY_B.name
        findViewById<TextView>(R.id.key_c_title)?.text = RemoteConfigKey.KEY_C.name
        findViewById<TextView>(R.id.key_a_content)?.text = LocalConfig.sample_data_a
        findViewById<TextView>(R.id.key_b_content)?.text = LocalConfig.sample_data_b
        findViewById<TextView>(R.id.key_c_content)?.text = LocalConfig.sample_data_c
    }

}