package com.riac.easygoband.api

import com.riac.easygoband.repository.DefaultMainRepository
import com.riac.easygoband.repository.MainRepository
import com.riac.easygoband.util.Constants.Companion.BASE_URL
import com.riac.easygoband.util.Constants.Companion.BASE_URL_LS
import com.riac.easygoband.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDataAPI(): DataAPI =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(DataAPI::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(api: DataAPI): MainRepository = DefaultMainRepository(api)

    @Singleton
    @Provides
    fun providesDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }
}