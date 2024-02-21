import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

data class api_info(val apst: String)
class PrefDataStore(context: Context){

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore("ApiData")
    val pref = context.dataStore

    companion object {
        var apiString = stringPreferencesKey("API_DATA")
    }

    suspend fun setInfo(info: String){
        pref.edit{
            it[apiString] = info
        }
    }

    fun getInfo() = pref.data.map{
        api_info(apst = it[apiString]?: "мама")
    }
}