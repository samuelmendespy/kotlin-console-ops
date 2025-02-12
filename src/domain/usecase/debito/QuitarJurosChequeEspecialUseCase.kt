package domain.usecase.debito

import data.ContaRepository

class QuitarJurosChequeEspecialUseCase (private val contaRepository: ContaRepository) {
    fun executar(contaId: Int) {
        val conta = contaRepository.findById(contaId) ?: return
        val jurosDevidoChequeEspecial = conta.valorUsadoChequeEspecial * 0.2

        if (conta.saldo > jurosDevidoChequeEspecial) {
            println("Saldo insuficiente para pagar o boleto.")
            return
        }

        conta.saldo -= jurosDevidoChequeEspecial
        conta.valorUsadoChequeEspecial = 0.0
        contaRepository.save(conta)
        }
}