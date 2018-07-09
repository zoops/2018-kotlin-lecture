package com.moberan.zoops.rndhub.api

import com.moberan.zoops.rndhub.data.RnDInfoRes
import retrofit2.Call
import retrofit2.http.GET

interface TrendService {
    @GET("issue-list.json")
    fun getRnDTrendList(): Call<RnDInfoRes>

}