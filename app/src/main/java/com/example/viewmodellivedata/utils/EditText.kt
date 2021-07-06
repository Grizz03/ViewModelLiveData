package com.example.viewmodellivedata.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.returnChangedText(): String {
    var textInput = ""

    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // no-op
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // no-op
        }

        override fun afterTextChanged(s: Editable?) {
            textInput = s.toString()
        }
    })

    return textInput
}