package com.elitebreeds.pigeonsdate.model

//hello 1.5M

data class Pigeon(
    val name: String?,
    val type: String?,
    val image: String?,
    val birth: String?,
    val ringID: String?,
    val ringColor: String?,
//    val status: Status?,
//    val gender: Gender?,
//    val parents: Parents?
)

data class Parents(
    val motherName: String?,
    val motherRingID: String?,
    val fatherName: String?,
    val fatherRingID: String?
)

enum class Status { ALIVE, FOR_SALE, SOLD, DEAD}

enum class Gender { MALE, FEMALE }

