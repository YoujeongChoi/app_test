package com.example.app_test.retrofit.model

data class DustResponse(
    val PM_10: Int,
    val PM_1_0: Int,
    val PM_2_5: Int,
    val _id: String,
    val date: String,
    val day: Int,
    val hour: Int,
    val index: Int,
    val min: Int,
    val month: Int,
    val year: Int
)