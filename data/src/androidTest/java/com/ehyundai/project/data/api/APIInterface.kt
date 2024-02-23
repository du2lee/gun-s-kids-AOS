package com.ehyundai.project.data.api

import com.ehyundai.project.data.model.club.ClubResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("club/list/all")
    fun getSearchClubAll(): Single<ClubResponse>
}