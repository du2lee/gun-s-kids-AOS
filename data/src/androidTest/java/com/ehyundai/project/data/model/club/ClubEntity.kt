package com.ehyundai.project.data.model.club

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "club")
data class ClubEntity (
    @SerializedName("clubNo")
    val clubNo : String,
    @SerializedName("companyNm")
    val companyNm : String,
    @SerializedName("clubNm")
    val clubNm : String,
    @SerializedName("clubImg")
    val clubImg : String,
    @SerializedName("memberCount")
    val memberCount : String,
    @SerializedName("createdDate")
    val createdDate : String,
)