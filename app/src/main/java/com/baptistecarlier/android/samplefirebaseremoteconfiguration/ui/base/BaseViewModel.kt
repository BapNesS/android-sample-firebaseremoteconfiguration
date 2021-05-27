package com.baptistecarlier.android.samplefirebaseremoteconfiguration.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.BuildConfig
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.model.RemoteConfigData
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.model.RemoteConfigKey
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.util.LocalConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

abstract class BaseViewModel : ViewModel() {

    private val _data = MutableLiveData<String?>(null)
    val data : LiveData<String?> = _data

    protected var sampleData = mutableListOf<String>()

    protected val firebaseRemoteConfigInstance = FirebaseRemoteConfig.getInstance().apply {
        setConfigSettingsAsync(remoteConfigSettings {
            minimumFetchIntervalInSeconds = if (BuildConfig.DEBUG) 0 else 3600
            fetchTimeoutInSeconds = 10
        })
    }

    protected fun updateDisplay() {
        sampleData.add(0, localDatas())
        _data.postValue( sampleData.joinToString(separator = "\n") )
    }

    private fun localDatas() = "${LocalConfig.sample_data_a} / ${LocalConfig.sample_data_b} / ${LocalConfig.sample_data_c}"

    protected fun loadCacheFirebaseConfig() {
        firebaseRemoteConfigInstance.apply {
            RemoteConfigKey.values().forEach { key ->
                getString(key.name)
                        .takeIf { it.isNotBlank() }
                        ?.let { newValue ->
                            val remoteConfigData = RemoteConfigData(key, newValue)
                            LocalConfig.setData(remoteConfigData)
                        }
            }
        }
    }

    abstract fun initLoading()
}