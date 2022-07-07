package com.smol.citt

import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.DialogInterface
import android.graphics.Paint
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StyleRes
import androidx.core.text.set
import androidx.preference.EditTextPreferenceDialogFragmentCompat
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


fun app_(context: Context?) = (context?.applicationContext as CitApplication)



class MainFragment : PreferenceFragmentCompat(), DialogInterface.OnClickListener {

    private fun updateDyanamicPrefs() {

    }

    fun EditText.xSetStuff(s :String) {
        this.text.clear(); this.text.append(s)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

        setPreferencesFromResource(R.xml.prefs, rootKey)

        updateDyanamicPrefs()

        findPreference<Preference>("")

        findPreference<Preference>("questionSet")?.setOnPreferenceClickListener {

        MaterialAlertDialogBuilder(requireContext())
            .setMessage(   CitApplication.questionSet.toString()   )

            .setPositiveButton("ok") {
                dialog, i ->
                dialog.dismiss() }
            .setNegativeButton("copy") {
                dialog, i ->
                (context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).setPrimaryClip(
                    ClipData.newPlainText(
                        "", CitApplication.questionSet.toString()))
                Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            .setNeutralButton("edit (not implemented)") {
                dialog, i ->

                MaterialAlertDialogBuilder(requireContext())
                    .setView(EditText(context)
                        .apply {
                            setLines(10)
                            xSetStuff(CitApplication.questionSet.toString())
                            })
                    .show()

            }
*/
            .show()


            true
        }



    }

    //dialog button click
    override fun onClick(p0: DialogInterface?, p1: Int) {

    }


}