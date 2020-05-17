package com.kamikaze.smkcodingproject2.util

import android.content.Context
import android.widget.Toast

fun hasilToast(context: Context, message: String) {
    Toast.makeText(context, message,Toast.LENGTH_SHORT).show()


}