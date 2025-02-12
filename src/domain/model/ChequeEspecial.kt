package domain.model

class ChequeEspecial (
    val idContaBanco: Int,
    val limite: Double,
    val valorUsado: Double = 0.00,
    var jurosChequeEspecialAtual: Double = valorUsado * 0.2 )