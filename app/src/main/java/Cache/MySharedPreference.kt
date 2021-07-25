package Cache

import android.content.Context
import android.content.SharedPreferences

object MySharedPreference {
    private const val NAME = "KeshXotiraga"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }
    private inline fun SharedPreferences.edit(operations:(SharedPreferences.Editor)-> Unit){
        val editor = edit()
        operations(editor)
        editor.apply()
    }

    var lotinKrill: String?
        get() = preferences.getString("latin","latin")
        set(value) {
            preferences.edit{
                it.putString("latin",value)
            }
        }

    var matn1: String?
        get() = preferences.getString("matn1","")
        set(value) {
            preferences.edit{
                it.putString("matn1",value)
            }
        }

    var matn2: String?
        get() = preferences.getString("matn2","")
        set(value) {
            preferences.edit{
                it.putString("matn2",value)
            }
        }
}