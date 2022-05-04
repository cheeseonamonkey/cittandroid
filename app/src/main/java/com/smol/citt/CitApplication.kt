package com.smol.citt



import android.app.Application
import android.content.Context
import com.google.gson.Gson




class CitApplication  : Application() {




    init {
        instance = this
    }




companion object {
    private var instance: CitApplication? = null

    fun applicationContext() : Context {
        return instance!!.applicationContext
    }




    val prefWriter: PrefWriter by lazy { PrefWriter(applicationContext()) }


    //question set
    var questionSet: QuestionSet
        get() {

            val prefs =  prefWriter.questionSetJson
            val p = Gson().fromJson<QuestionSet>(prefs, com.smol.citt.QuestionSet::class.java)

            return p
        }
        set(value) {
            prefWriter.questionSetJson = Gson().toJson(value)
        }

}




    override fun onCreate() {
        super.onCreate()



    }

}