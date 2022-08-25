package com.hassan.codewars

import com.google.gson.Gson
import com.hassan.codewars.data.retrofit.client.RetrofitRestClient
import com.hassan.codewars.data.retrofit.endpoints.ListOfCompletedChallengesAPI
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceTest {
    lateinit var mockWebServer: MockWebServer
    lateinit var apiService: ListOfCompletedChallengesAPI
    lateinit var gson: Gson

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        gson = Gson()
        mockWebServer = MockWebServer()
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(ListOfCompletedChallengesAPI::class.java)
    }

    @Test
    fun get_all_challenges_api_test() {
        runBlocking {
            val mockResponse = MockResponse()
            mockWebServer.enqueue(mockResponse.setBody("{}"))
            val response = apiService.getListOfCompletedChallengesAPI(0)
            val request = mockWebServer.takeRequest()
            assertEquals("users/Voile/code-challenges/completed",request.path)
            assertEquals(true, response.execute().body()?.data?.isEmpty() == true)
        }
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

}