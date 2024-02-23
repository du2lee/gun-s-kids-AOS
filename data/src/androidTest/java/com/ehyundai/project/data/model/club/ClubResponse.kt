package com.ehyundai.project.data.model.club

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ClubResponse (
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