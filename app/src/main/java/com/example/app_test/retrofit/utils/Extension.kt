package com.example.app_test.retrofit.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

// 문자열이 제이슨 형태인지, 제이슨 배열 형태인지
fun String?.isJsonObject(): Boolean {
    if(this?.startsWith("{") == true && this.endsWith("}")) {
        return true
    } else {
        return false
    }
//    return this?.startsWith("{") == true && this.endsWith(("}"))
}

// 문자열이 제이슨 배열인지
fun String?.isJsonArray() : Boolean {
    if (this?.startsWith("[")  == true && this.endsWith("]")) {
        return true
    } else {
        return false
    }
}

// 에딧 텍스트에 대한 익스텐션
fun EditText.onlyTextChanged(completion: (Editable?) -> Unit) {
    this.addTextChangedListener(object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged(editable: Editable?) {
            TODO("Not yet implemented")
            completion(editable)
        }

    })
}