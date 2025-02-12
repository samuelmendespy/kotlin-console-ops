package presentation.console

import domain.model.BoletoBancario
import service.ContaService
import java.time.LocalDate

class AdaptadorPagarBoleto(private val contaService: ContaService) {
    fun executar(contaId: Int, codigo:String, valor: String) {
        val codigoInt = codigo.toInt()
        val valorDouble = valor.toDoubleOrNull() ?: return
        contaService.pagarBoleto(contaId, BoletoBancario(codigoInt, valorDouble, LocalDate.now()))
        val saldo = contaService.consultarSaldo(contaId)
        println("+ R$ ${valorDouble} DEPÓSITO NO SALDO DA CONTA")
        println("Novo saldo: R$ ${saldo}")
    }
}