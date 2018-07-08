package com.moberan.zoops.rndhub.api

import com.moberan.zoops.rndhub.model.Response.RnDInfoRes
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IssueService {
    @GET("issue-list.json")
    fun getRnDIssueList2(): Call<RnDInfoRes>
}