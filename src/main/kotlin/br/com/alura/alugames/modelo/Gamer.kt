package br.com.alura.alugames.modelo

import java.util.*
import kotlin.random.Random

data class Gamer(var nome : String, var email : String) {
    var dataNascimento : String? = null
    var usuario : String? = null
        set(value) { //Se setar usuário, ele chama criarIdInterno, preenchendo idInterno
            field = value //field -> corpo / o que está escrito no campo
            if (idInterno.isNullOrBlank()) { //null ou em branco
                criarIdInterno()
            }
        }
    var idInterno : String? = null
        private  set //privando o set -> podemos pegar (get) externamente, mas não setar (set)

    val jogosBuscados = mutableListOf<Jogo?>()

    //Construtor secundário:
    constructor(nome: String, email: String, dataNascimento : String, usuario : String) : this (nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

    init {
        if (nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome está em branco")
        }
        this.email = validarEmail() //Antes de executar criação do objeto, vai executar esse init com validação do email
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail() : String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    // Código suprimido

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
                return Gamer(nome, email)
            }
        }

    }

}
