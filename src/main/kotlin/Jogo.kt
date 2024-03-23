data class Jogo (val titulo : String, val capa : String) { //formata as infos
    var descricao : String? = null
    override fun toString(): String {
        return "Meu jogo:\n" +
                "Título: $titulo\n" +
                "Capa: $capa\n" +
                "Descrição: $descricao"
    }

}