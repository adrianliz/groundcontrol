package groundcontrolsh

import groundcontrolsh.domain.ApiClient
import groundcontrolsh.domain.FeatureFlag
import groundcontrolsh.domain.FeatureFlagStatus
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class GroundControlShould {
    @Test
    fun `return enabled when feature flag is enabled`() {
        val apiClient = mockk<ApiClient> {
            every { checkStatus(FeatureFlag("csv-export")) } returns FeatureFlagStatus(true)
        }
        val groundControl = GroundControl(apiClient)

        val isFeatureFlagEnabled = groundControl.isFeatureFlagEnabled("csv-export")

        Assertions.assertTrue(isFeatureFlagEnabled)
    }
}
