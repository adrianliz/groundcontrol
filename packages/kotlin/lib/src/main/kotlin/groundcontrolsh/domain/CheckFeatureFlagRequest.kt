package groundcontrolsh.domain

data class CheckFeatureFlagRequest(val flagName: String) {
    fun featureFlag(): FeatureFlag {
        return FeatureFlag(flagName)
    }
}
