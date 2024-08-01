package com.example.cdg_android_project

import org.koin.dsl.module

val appModule = module {
    single<IWebApi> { WebApi() }
//    factory { Match(get()) }
}
