package com.example.humblrvsv.data.api

import com.example.humblrvsv.data.api.dto.postdto.SinglePostListingDto
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiSinglePost{

    @GET("/{from}/{url}/")
    suspend fun getSinglePost(
        @Path("from") from: String,
        @Path("url") url: String,
//        @Query("after") page: String,
//        @Query("type") type: String = "links"
    ): List<SinglePostListingDto>
}
