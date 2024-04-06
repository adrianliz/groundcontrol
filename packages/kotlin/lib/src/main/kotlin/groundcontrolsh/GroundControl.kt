package groundcontrolsh

import groundcontrolsh.domain.ApiClient
import groundcontrolsh.domain.CheckFeatureFlagRequest

class GroundControl(private val apiClient: ApiClient) {
    fun isFeatureFlagEnabled(request: CheckFeatureFlagRequest): Boolean {
        val response = apiClient.checkStatus(request.featureFlag())
        return response.enabled
    }
}
