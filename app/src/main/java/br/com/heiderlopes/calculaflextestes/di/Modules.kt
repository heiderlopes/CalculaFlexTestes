package br.com.heiderlopes.calculaflextestes.di

import br.com.heiderlopes.calculaflextestes.repository.GasStationRepository
import br.com.heiderlopes.calculaflextestes.repository.GasStationRepositoryImpl
import br.com.heiderlopes.calculaflextestes.service.GasStationService
import br.com.heiderlopes.calculaflextestes.ui.form.FormViewModel
import br.com.heiderlopes.calculaflextestes.ui.gasstations.GasStationsViewModel
import br.com.heiderlopes.calculaflextestes.ui.result.ResultViewModel
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    single { createNetworkClient(get()).create(GasStationService::class.java) }
    single { createOkHttpClientAuth() }
}

val repositoryModule = module {
    single<GasStationRepository> { GasStationRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { GasStationsViewModel(get()) }
    viewModel { ResultViewModel() }
    viewModel { FormViewModel() }
}


private fun createNetworkClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("http://www.mocky.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun createOkHttpClientAuth(): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
    return builder.build()
}