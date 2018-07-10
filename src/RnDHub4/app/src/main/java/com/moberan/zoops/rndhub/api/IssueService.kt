package com.moberan.zoops.rndhub.api

import com.moberan.zoops.rndhub.data.RnDInfoRes
import retrofit2.Call
import retrofit2.http.POST

interface IssueService {
    @POST("getRnDInfos")
    fun getRnDIssueList(): Call<RnDInfoRes>
}