package com.baptistecarlier.android.samplefirebaseremoteconfiguration.util

import com.baptistecarlier.android.samplefirebaseremoteconfiguration.model.RemoteConfigData
import com.baptistecarlier.android.samplefirebaseremoteconfiguration.model.RemoteConfigKey

object LocalConfig {
    var sample_data_a = "empty_value_a"
    var sample_data_b = "empty_value_b"
    var sample_data_c = "empty_value_c"

    fun setData(remoteConfigData: RemoteConfigData) {
        when (remoteConfigData.key) {
             RemoteConfigKey.KEY_A -> { sample_data_a = remoteConfigData.value }
             RemoteConfigKey.KEY_B -> { sample_data_b = remoteConfigData.value }
             RemoteConfigKey.KEY_C -> { sample_data_c = remoteConfigData.value }
        }
    }

    fun reset() {
        sample_data_a = "default_value_a"
        sample_data_b = "default_value_b"
        sample_data_c = "default_value_c"
    }
}