
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient() //Quem vai receber/ter acesso às informações

    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()

    try {
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java) //(de onde vem (o response.body), para onde vai)

        val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
        println(meuJogo)
    } catch (ex: Throwable) {
        println("Jogo inexistente. Tente outro id.")
    }

}