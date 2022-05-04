package com.smol.citt

import android.content.Context
import android.util.Log

class PrefWriter(val context: Context) {

    //pref access:


    private val APP_PREF_KEY = "flashCardQuestions_prefs"

    private val prefs by lazy { context.getSharedPreferences(APP_PREF_KEY, Context.MODE_PRIVATE) }


    //prefs as properties:

    //questions
    private val PREF_QUESTIONSET_JSON = "PREF_QUESTIONSET_JSON"
    private val PREF_FIRST_RUN = "PREF_FIRST_RUN_APPBOOLEAN"

    var questionSetJson : String?
        get () {
            val p = prefs.getString(PREF_QUESTIONSET_JSON, "{\"questions\":"+HardCode.defaultCitQuestionsJson+"}")
            Log.d("PREF", "pref readr- QUESTIONSET_JSON: $p")
            return p
        }
        set (value) {
            prefs.edit().putString(PREF_QUESTIONSET_JSON, value).apply()
            Log.d("PREF", "pref write- QUESTIONSET_JSON: ${value}  (check: ${questionSetJson})")
        }



    /*var firstRun : Boolean?

        get () {
            val p = prefs.getBoolean(PREF_FIRST_RUN, true)
            if(p) {
                Log.d("PREF", "First run detected - setting defaults.")
                firstRun = false
                setDefaults()
                return true
            }else
                return false


        }
        set (value) {
            prefs.edit().putBoolean(PREF_FIRST_RUN, value!!).apply()
            Log.d("PREF", "pref write- QUESTIONSET_JSON: ${value}  (check: ${questionSetJson})")
        }
*/

        fun setDefaults() {
            questionSetJson = HardCode.defaultCitQuestionsJson
        }



    //app settings
}