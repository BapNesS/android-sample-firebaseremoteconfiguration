package com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.sync

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class SyncViewModel : BaseViewModel() {

    override fun initLoading() {
        loadCacheFirebaseConfig()
        viewModelScope.launch {
            fetchFirebaseConfig()
            updateDisplay()
        }
    }

    private suspend fun fetchFirebaseConfig() : Boolean = suspendCoroutine { continuation ->
        firebaseRemoteConfigInstance.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("Sample", "Finishing remote configuration")
                loadCacheFirebaseConfig()
            }
            continuation.resume(true)
        }
    }

}

