package domain.model

class ContaBanco(
    val id: Int,
    val nome: String,
    var saldo: Double = 0.0,
    val limiteChequeEspecial: Double = if (saldo <= 500) 50.0 else saldo / 2,
    var valorUsadoChequeEspecial : Double = 0.0,
    val historico: MutableList<String> = mutableListOf()
) {
    fun isChequeEspecialUsado(): Boolean {
        return valorUsadoChequeEspecial > 0
    }
}