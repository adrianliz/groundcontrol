package groundcontrolsh

import groundcontrolsh.domain.Actor
import groundcontrolsh.domain.ApiClient
import groundcontrolsh.domain.CheckFeatureFlagRequest
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
        val request = CheckFeatureFlagRequest("csv-export")

        val isFeatureFlagEnabled = groundControl.isFeatureFlagEnabled(request)

        Assertions.assertTrue(isFeatureFlagEnabled)
    }

    @Test
    fun `return not enabled when feature flag is not enabled`() {
        val apiClient = mockk<ApiClient>(relaxed = true)
        val groundControl = GroundControl(apiClient)
        val request = CheckFeatureFlagRequest("csv-export")

        val isFeatureFlagEnabled = groundControl.isFeatureFlagEnabled(request)

        Assertions.assertFalse(isFeatureFlagEnabled)
    }

    @Test
    fun `return enabled when feature flag is enabled for an actor`() {
        val apiClient = mockk<ApiClient>(relaxed = true) {
            every { checkStatus(FeatureFlag("csv-export", listOf(Actor("test")))) } returns FeatureFlagStatus(true)
        }
        val groundControl = GroundControl(apiClient)
        val request = CheckFeatureFlagRequest("csv-export", listOf(Actor("test")))

        val isFeatureFlagEnabled = groundControl.isFeatureFlagEnabled(request)

        Assertions.assertTrue(isFeatureFlagEnabled)
    }

    @Test
    fun `return not enabled when feature flag is enabled only for an actor`() {
        val apiClient = mockk<ApiClient>(relaxed = true) {
            every { checkStatus(FeatureFlag("csv-export", listOf(Actor("test")))) } returns FeatureFlagStatus(true)
        }
        val groundControl = GroundControl(apiClient)
        val request = CheckFeatureFlagRequest("csv-export")

        val isFeatureFlagEnabled = groundControl.isFeatureFlagEnabled(request)

        Assertions.assertFalse(isFeatureFlagEnabled)
    }
}
