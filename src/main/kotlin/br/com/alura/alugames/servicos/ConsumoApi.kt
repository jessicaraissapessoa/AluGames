package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun buscaJogo(id : String): InfoJogo? {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient() //Quem vai receber/ter acesso às informações

        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        //println(json) Retorno da API

        val gson = Gson()

        val meuInfoJogo = runCatching {
            gson.fromJson(json, InfoJogo::class.java) //(de onde vem (o response.body), para onde vai)
        }.getOrNull()

        return meuInfoJogo
    }

}