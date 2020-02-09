package ir.ah.app.bestmovies.service.http

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceContainer {

    fun apiService():ApiService{

        val  retrofit = Retrofit.Builder()
            .baseUrl("http://moviesapi.ir/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)



    }


}