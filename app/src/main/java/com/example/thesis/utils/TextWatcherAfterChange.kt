package com.example.thesis.utils

import android.text.Editable
import android.widget.EditText

interface TextWatcherAfterChange {
    fun onAfterTextChanged(editText: EditText?, editable: Editable?)

}
