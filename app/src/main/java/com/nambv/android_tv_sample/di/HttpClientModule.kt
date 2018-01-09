package com.nambv.android_tv_sample.di

import android.app.Application

import com.nambv.android_tv_sample.data.TheMovieDbAPI

import java.io.File
import java.util.concurrent.TimeUnit

import javax.inject.Named

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by [Marcus Gabilheri](mailto:marcus@gabilheri.com)
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 9/4/16.
 */
@Module
class HttpClientModule {

    @Provides
    @AppScope
    fun provideOkHttpClient(app: Application): OkHttpClient {
        val cacheDir = File(app.cacheDir, "http")
        return OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .cache(okhttp3.Cache(cacheDir, DISK_CACHE_SIZE))
                .build()
    }

    @Provides
    @Named("movieDB") // Name is used in case a second Retrofit api is provided.
    @AppScope
    fun provideFithubRestAdapter(gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit {
        var okHttpClient = okHttpClient
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient = okHttpClient.newBuilder()
                .addInterceptor(interceptor)
                .build()

        return Retrofit.Builder()
                .baseUrl(API_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
    }

    @Provides
    fun provideFithubApi(@Named("movieDB") restAdapter: Retrofit): TheMovieDbAPI {
        return restAdapter.create(TheMovieDbAPI::class.java)
    }

    @Provides
    @AppScope
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    companion object {

        private val DISK_CACHE_SIZE = (50 * 1024 * 1024).toLong() // 50MB

        const val BACKDROP_URL = "http://image.tmdb.org/t/p/w1280/"
        const val POSTER_URL = "http://image.tmdb.org/t/p/w600/"
        const val API_URL = "https://api.themoviedb.org/3/"
        const val NOW_PLAYING = "movie/now_playing"
        const val LATEST = "movie/latest"
        const val POPULAR = "movie/popular"
        const val TOP_RATED = "movie/top_rated"
        const val UPCOMING = "movie/upcoming"
        const val MOVIE = "movie/"
        const val PERSON = "person/"
        const val DISCOVER = "discover/movie/"
        const val SEARCH_MOVIE = "search/movie/"
        const val TV = "tv/"
    }
}