package com.example.utils.core

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.convertDate():String{

    val parserFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val convertFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    var date: Date? = null
    return try {
        date = parserFormat.parse(this)
        convertFormat.format(date)

    } catch (e: ParseException) {
        e.printStackTrace()
        ""
    }
}

