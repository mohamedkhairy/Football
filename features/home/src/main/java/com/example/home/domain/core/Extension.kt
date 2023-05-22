package com.example.home.domain.core

import com.example.home.domain.entity.Match
import java.text.SimpleDateFormat
import java.util.Locale


fun List<Match>.sortByDate(): MutableList<Match>? {
    val parserFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

    return this.sortedBy {
        parserFormat.parse(it.date)
    }.toMutableList()
}
