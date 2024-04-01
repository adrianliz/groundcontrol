package groundcontrolsh

import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class GroundControlShould {
    @Test
    fun `return enabled when feature flag is enabled`() {
        val groundControl = GroundControl()
        val isFeatureFlagEnabled = groundControl.isFeatureFlagEnabled("csv-export")
        Assertions.assertTrue(isFeatureFlagEnabled)
    }
}
