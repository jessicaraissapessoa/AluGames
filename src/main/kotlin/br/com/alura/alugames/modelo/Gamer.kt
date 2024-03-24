package br.com.alura.alugames.modelo

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


    //Construtor secundário:
    constructor(nome: String, email: String, dataNascimento : String, usuario : String) : this (nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

}