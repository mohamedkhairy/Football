package com.example.home.domain.core

import com.example.home.domain.entity.Match
import org.junit.Assert
import org.junit.Test


class ExtensionTest {

    val dateList = mutableListOf<Match>(
        Match(1, "t1" ,"1" ,"2023-04-03T19:00:00Z", "01", false, "t1"),
        Match(1, "t2" ,"2" ,"2024-05-13T11:30:00Z", "02", false, "t1"),
        Match(1, "t3" ,"3" ,"2022-08-06T14:00:00Z", "03", false, "t1"),
        Match(1, "t4" ,"4" ,"2022-10-02T13:00:00Z", "04", false, "t1"),
        Match(1, "t5" ,"5" ,"2023-01-04T19:30:00Z", "05", false, "t1"),
        Match(1, "t6" ,"6" ,"2022-09-03T14:00:00Z", "06", false, "t1"),
        )


    val correctSortedList = mutableListOf<Match>(
        Match(1, "t3" ,"3" ,"2022-08-06T14:00:00Z", "03", false, "t1"),
        Match(1, "t6" ,"6" ,"2022-09-03T14:00:00Z", "06", false, "t1"),
        Match(1, "t4" ,"4" ,"2022-10-02T13:00:00Z", "04", false, "t1"),
        Match(1, "t5" ,"5" ,"2023-01-04T19:30:00Z", "05", false, "t1"),
        Match(1, "t1" ,"1" ,"2023-04-03T19:00:00Z", "01", false, "t1"),
        Match(1, "t2" ,"2" ,"2024-05-13T11:30:00Z", "02", false, "t1"),
    )


    @Test
    fun `test_sort_by_date_return_correct_result`(){
        val result = dateList.sortByDate()
        Assert.assertArrayEquals(correctSortedList.toTypedArray() , result?.toTypedArray())
    }

    @Test
    fun `test_sort_by_date_return_null_result`(){
        val result = arrayListOf<Match>().sortByDate()
        Assert.assertNotNull(result)
    }
}