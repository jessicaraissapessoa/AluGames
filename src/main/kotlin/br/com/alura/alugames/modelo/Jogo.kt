package br.com.alura.alugames.modelo

data class Jogo (val titulo : String, val capa : String) { //formata as infos
    var descricao : String? = null
    override fun toString(): String {
        return "Jogo:\n" +
                "Título: $titulo\n" +
                "Capa: $capa\n" +
                "Descrição: $descricao\n"
    }

}