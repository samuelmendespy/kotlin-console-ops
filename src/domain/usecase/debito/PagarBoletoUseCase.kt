package domain.usecase.debito

import domain.model.BoletoBancario
import data.ContaRepository
import domain.model.ContaBanco

class PagarBoletoUseCase (private val contaRepository: ContaRepository) {
    fun executar(contaId: Int, boleto: BoletoBancario) {
        val conta = contaRepository.findById(contaId) ?: return

        val valorDisponivelTotal = conta.saldo + conta.limiteChequeEspecial - conta.valorUsadoChequeEspecial

        if (boleto.valor > valorDisponivelTotal) {
            println("Saldo insuficiente para pagar o boleto.")
        }

        if ( conta.saldo < boleto.valor ) {
            conta.valorUsadoChequeEspecial += boleto.valor
        }

        conta.saldo -= boleto.valor
        boleto.status = BoletoBancario.Status.PAGO
        contaRepository.save(conta)
    }
}