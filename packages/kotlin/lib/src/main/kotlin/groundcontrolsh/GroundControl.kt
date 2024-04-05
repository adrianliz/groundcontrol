package groundcontrolsh

import groundcontrolsh.domain.ApiClient
import groundcontrolsh.domain.FeatureFlag

class GroundControl(private val apiClient: ApiClient) {
    fun isFeatureFlagEnabled(flagName: String): Boolean {
        val response = apiClient.checkStatus(FeatureFlag(flagName))
        return response.enabled
    }
}
