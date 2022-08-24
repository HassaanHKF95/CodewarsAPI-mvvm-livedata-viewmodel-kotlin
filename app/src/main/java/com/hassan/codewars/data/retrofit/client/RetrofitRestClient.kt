package com.hassan.codewars.data.retrofit.client

import android.content.Context
import com.hassan.codewars.data.retrofit.Constants.ApiConstant
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRestClient {
    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit {

        if (retrofit == null) {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            retrofit = Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

        return retrofit!!
    }


}
