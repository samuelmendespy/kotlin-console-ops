package presentation.console

import service.ContaService

class AdaptadorConsultarChequeEspecial (private val contaService : ContaService) {
    fun executar(contaId: Int) {
        contaService.consultarChequeEspecial(contaId) ?: return
    }
}