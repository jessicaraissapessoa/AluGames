import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

fun main() {

    val client: HttpClient = HttpClient.newHttpClient() //Quem vai receber/ter acesso às informações

    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()
    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java) //(de onde vem, para onde vai)

    val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    println(meuJogo)
}