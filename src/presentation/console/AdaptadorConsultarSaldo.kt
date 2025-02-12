package presentation.console

import service.ContaService

class AdaptadorConsultarSaldo(private val contaService: ContaService) {
    fun executar(contaId: Int) {
        val saldo = contaService.consultarSaldo(contaId) ?: return
        println("Saldo da conta: R$ $saldo")
    }
}