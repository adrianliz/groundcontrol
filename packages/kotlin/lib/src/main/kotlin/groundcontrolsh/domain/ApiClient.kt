package groundcontrolsh.domain

interface ApiClient {
    fun checkStatus(featureFlag: FeatureFlag): FeatureFlagStatus
}
