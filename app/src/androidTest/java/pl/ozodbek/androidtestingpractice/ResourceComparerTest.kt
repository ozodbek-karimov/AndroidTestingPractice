package pl.ozodbek.androidtestingpractice

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import pl.ozodbek.androidtestingpractice.testing_utils.ResourceComparer

class ResourceComparerTest {

    private lateinit var resourceCompare: ResourceComparer


    @Before
    fun setUp() {
        resourceCompare = ResourceComparer()
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceCompare.isEqual(context, R.string.app_name, "AndroidTestingPractice")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceCompare.isEqual(context, R.string.app_name, "Testing")
        assertThat(result).isFalse()
    }


}