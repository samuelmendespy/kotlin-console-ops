package service

import domain.model.BoletoBancario
import domain.model.ChequeEspecial
import domain.usecase.consulta.ConsultarChequeEspecialUseCase
import domain.usecase.consulta.ConsultarSaldoUseCase
import domain.usecase.credito.DepositarUseCase
import domain.usecase.debito.PagarBoletoUseCase
import domain.usecase.debito.QuitarJurosChequeEspecialUseCase
import domain.usecase.debito.SacarUseCase

class ContaService(
    private val consultarSaldoUseCase: ConsultarSaldoUseCase,
    private val depositarUseCase: DepositarUseCase,
    private val sacarUseCase: SacarUseCase,
    private val pagarBoletoUseCase: PagarBoletoUseCase,
    private val consultarChequeEspecialUseCase: ConsultarChequeEspecialUseCase,
    private val quitarJurosChequeEspecialUseCase: QuitarJurosChequeEspecialUseCase
) {
    fun consultarSaldo(contaId: Int): Double? {
        return consultarSaldoUseCase.executar(contaId)
    }

    fun depositar(contaId: Int, valor: Double) {
        depositarUseCase.executar(contaId, valor)
    }

    fun sacar(contaId: Int, valor: Double) {
        sacarUseCase.executar(contaId, valor)
    }

    fun pagarBoleto(contaId: Int, boleto: BoletoBancario) {
        pagarBoletoUseCase.executar(contaId, boleto)
    }

    fun consultarChequeEspecial(contaId: Int) {
        consultarChequeEspecialUseCase.executar(contaId)
    }

    fun quitarJurosChequeEspecial(contaId: Int) {
        consultarChequeEspecialUseCase.executar(contaId)
    }
}