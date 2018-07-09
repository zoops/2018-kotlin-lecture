package com.moberan.zoops.rndhub.api

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.moberan.zoops.rndhub.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object ApiUtil {
    private val TIME_OUT = 30
    val BASE_URL = BuildConfig.API_SERVER_ADDR
    val TREND_URL = "app/issue/"
    var mTendService: TrendService? = null
        get() {
            if (field == null) {
                field  = getRetrofit(BASE_URL + TREND_URL).create(TrendService::class.java)
            }
            return field
        }

    private fun getRetrofit(baseUrl: String): Retrofit {
        val gson = GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(Date::class.java,
                        JsonDeserializer<Date> { json, typeOfT, context ->
                            if(json.asJsonPrimitive.isNumber) {
                                Date(json.asJsonPrimitive.asLong * 1000)
                            } else {
                                null
                            }
                        }).create()

        val client = OkHttpClient.Builder()
                .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .build()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}