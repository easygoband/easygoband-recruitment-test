package com.example.android.data.di

import com.example.android.data.di.providers.*
import org.koin.dsl.module

val dataModule = module {
    single { provideGson() }
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), get()) }
    single { provideEventsApi(get()) }
    single { provideEventDatabase(get()) }
    single { provideEventsRepository(get(), get()) }
}