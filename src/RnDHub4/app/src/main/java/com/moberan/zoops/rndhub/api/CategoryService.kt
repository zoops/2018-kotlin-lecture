package com.moberan.zoops.rndhub.api

import com.moberan.zoops.rndhub.data.RnDInfoRes
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CategoryService {
    @POST("getRnDInfos")
    fun getRnDCategoryList(@Body body: RequestBody): Call<RnDInfoRes>
}