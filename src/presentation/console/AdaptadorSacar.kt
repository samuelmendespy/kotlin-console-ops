package presentation.console

import service.ContaService

class AdaptadorSacar (private val contaService: ContaService) {
    fun executar(contaId: Int, valor: String) {
        val valorDouble = valor.toDoubleOrNull() ?: return
        contaService.sacar(contaId, valorDouble)
    }
}