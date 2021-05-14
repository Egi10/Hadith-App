package id.buaja.data.source.local.preference

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class LoadDataPreference @Inject constructor(@ApplicationContext val context: Context) {
    private val preference: SharedPreferences =
        context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE)

    fun saveActive(active: Boolean) {
        val editor = preference.edit()
        editor.putBoolean(ACTIVE, active)
        editor.apply()
    }

    fun getActive(): Boolean {
        return preference.getBoolean(ACTIVE, false)
    }

    companion object {
        private const val STORE_NAME = "check_data"
        private const val ACTIVE = "active"
    }
}