data class InfoJogo(val info: InfoApiShark) { //recebe as infos
    override fun toString(): String {
        return info.toString()
    }
}