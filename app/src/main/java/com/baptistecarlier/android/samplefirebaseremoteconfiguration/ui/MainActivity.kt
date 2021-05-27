package com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.R
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.async.AsyncActivity
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.nextlaunch.NextLaunchActivity
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.result.ResultActivity
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.sync.SyncActivity
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.util.LocalConfig
import com.google.android.material.button.MaterialButton
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        // Screen
        findViewById<Button>(R.id.screen_a).setOnClickListener {
            start(AsyncActivity::class.java)
        }
        findViewById<Button>(R.id.screen_b).setOnClickListener {
            start(NextLaunchActivity::class.java)
        }
        findViewById<Button>(R.id.screen_c).setOnClickListener {
            start(SyncActivity::class.java)
        }
        findViewById<Button>(R.id.screen_result).setOnClickListener {
            start(ResultActivity::class.java)
        }
        // Tools
        findViewById<MaterialButton>(R.id.reset_local).setOnClickListener {
            LocalConfig.reset()
            Toast.makeText(this, R.string.reset_local, Toast.LENGTH_SHORT).show()
        }
        findViewById<MaterialButton>(R.id.reset_frc).setOnClickListener {
            FirebaseRemoteConfig.getInstance().reset()
            Toast.makeText(this, R.string.reset_frc, Toast.LENGTH_SHORT).show()
        }
    }
}

fun <T : AppCompatActivity> AppCompatActivity.start(type: Class<T>) {
    startActivity(Intent(this, type))
}