package com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.nextlaunch

import android.util.Log
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.base.BaseViewModel

class NextLaunchViewModel : BaseViewModel() {

    override fun initLoading() {
        loadCacheFirebaseConfig()
        updateDisplay()
        fetchFirebaseConfig()
    }

    private fun fetchFirebaseConfig() {
        firebaseRemoteConfigInstance.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("Sample", "Finishing remote configuration")
            }
        }
    }

}
