package com.elitebreeds.pigeonsdate.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elitebreeds.pigeonsdate.model.Pigeon

//hello 1.5M

@Entity
data class DatabasePigeon constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val type: String?,
    val image: String?,
    val birth: String?,
    val ringID: String?,
    val ringColor: String?,
//        val status: Status?,
//        val gender: Gender?,
//        val parents: Parents?
)

fun List<DatabasePigeon>.asModel(): List<Pigeon> {
    return map {
        Pigeon(
            name = it.name,
            type = it.type,
            image = it.image,
            birth = it.birth,
            ringID = it.ringID,
            ringColor = it.ringColor,
//                status = it.status,
//                gender = it.gender,
//                parents = it.parents

        )
    }
}
