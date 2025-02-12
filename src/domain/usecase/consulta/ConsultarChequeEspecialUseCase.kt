package domain.usecase.consulta

import data.ContaRepository
import domain.model.ChequeEspecial

class ConsultarChequeEspecialUseCase(private val contaRepository: ContaRepository) {
    fun executar(contaId: Int) : ChequeEspecial? {
        val conta = contaRepository.findById(contaId)
        if (conta != null) {
            val cheque = ChequeEspecial(
                    idContaBanco = contaId,
                    valorUsado = conta.valorUsadoChequeEspecial,
                    limite = conta.limiteChequeEspecial
                )

            println("CHEQUE ESPECIAL")
            println("  Limite utilizado: R$ ${cheque.valorUsado}")
            println("  Limite Disponível: R${cheque.limite}")
        }
        return null
    }
}