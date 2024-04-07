package groundcontrolsh.domain

data class FeatureFlag(val name: String, val actors: List<Actor> = emptyList())
