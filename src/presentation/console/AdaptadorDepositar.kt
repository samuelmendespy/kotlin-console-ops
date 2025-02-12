package presentation.console

import service.ContaService

class AdaptadorDepositar(private val contaService: ContaService) {
    fun executar(contaId: Int, valorDepositado: String) {
        val valorDepositadoDouble = valorDepositado.toDoubleOrNull()
        if (valorDepositadoDouble == null || valorDepositadoDouble <= 0) {
            println("O Valor para depósito é inválido")
            return
        }
        contaService.depositar(contaId, valorDepositadoDouble)
    }
}