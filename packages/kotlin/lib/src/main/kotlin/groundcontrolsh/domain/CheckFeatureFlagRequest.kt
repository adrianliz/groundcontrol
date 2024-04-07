package groundcontrolsh.domain

data class CheckFeatureFlagRequest(val flagName: String, val actors: List<Actor> = emptyList()) {
    fun featureFlag(): FeatureFlag {
        return FeatureFlag(flagName, actors)
    }
}
