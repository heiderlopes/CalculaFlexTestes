package br.com.heiderlopes.calculaflextestes

import br.com.heiderlopes.calculaflextestes.di.networkModule
import br.com.heiderlopes.calculaflextestes.di.repositoryModule
import br.com.heiderlopes.calculaflextestes.di.viewModelModule
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest

open class BaseTest : KoinTest {

    var mockWebServer: MockWebServer = MockWebServer()

    @Before
    fun start() {
        mockWebServer.url("/")
        startKoin {
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
        mockWebServer.start(8080)
    }

    @After
    fun finish() {
        stopKoin()
        mockWebServer.shutdown()
    }

}