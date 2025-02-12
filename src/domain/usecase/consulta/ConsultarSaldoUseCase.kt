package domain.usecase.consulta

import data.ContaRepository
import java.util.*

class ConsultarSaldoUseCase(private val contaRepository: ContaRepository) {
    fun executar(contaId: Int) : Double? {
        val conta = contaRepository.findById(contaId)

        if (conta == null) {
            return null
        }
        println("\n SALDO EM CONTA")
        println("CORRENTISTA: ${conta.nome.uppercase(Locale.getDefault())}")

        return conta.saldo
    }
}