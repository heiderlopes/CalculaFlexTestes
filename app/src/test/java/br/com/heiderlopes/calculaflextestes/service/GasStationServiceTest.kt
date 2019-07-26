package br.com.heiderlopes.calculaflextestes.service

import br.com.heiderlopes.calculaflextestes.BaseTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Test
import org.koin.test.inject
import java.io.File
import java.net.HttpURLConnection

class GasStationServiceTest : BaseTest(){

    val gasStationService: GasStationService by inject()

    @Test
    fun `do something`() {
        mockHttpResponse(mockWebServer, "gas_station.json", HttpURLConnection.HTTP_OK)
        val response = gasStationService.getGasStations().execute()
        Assert.assertEquals(response.body()?.size, 7)
    }

    fun mockHttpResponse(mockServer: MockWebServer, fileName: String, responseCode: Int) = mockServer.enqueue(
        MockResponse()
            .setResponseCode(responseCode)
            .setBody(getJson(fileName))
    )

    private fun getJson(path: String): String =
        String(File(this.javaClass.classLoader.getResource(path).path).readBytes())
}