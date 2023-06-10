package com.example.pagging3.di

import com.example.pagging3.repository.PassengerRepository
import com.example.pagging3.retrofit.RetrofitAPI
import com.example.pagging3.utils.Constants.BASE_URL
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(5, TimeUnit.MINUTES);
        builder.readTimeout(5, TimeUnit.MINUTES);
        builder.writeTimeout(5, TimeUnit.MINUTES);

        builder.addInterceptor( OkHttpProfilerInterceptor() )
        val client = builder.build()

        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getQuoteAPI(retrofit: Retrofit): RetrofitAPI {
        return retrofit.create(RetrofitAPI::class.java)
    }


    @Singleton
    @Provides
    fun provideDefaultLoginRepository(
        bracUpgApiService: RetrofitAPI
    ) =  PassengerRepository(bracUpgApiService)
}