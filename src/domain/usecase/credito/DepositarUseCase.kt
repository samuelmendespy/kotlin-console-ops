package domain.usecase.credito

import data.ContaRepository

class DepositarUseCase(private val contaRepository: ContaRepository) {
    fun executar(contaId: Int, valor: Double) {
        println("Processando Depósito")
        val conta = contaRepository.findById(contaId) ?: return
        conta.saldo += valor
        println("Sucesso!")
        println("+ R$ ${valor} DEPÓSITO EM CONTA")
        println("Novo saldo R$ ${conta.saldo}")
        if (conta.valorUsadoChequeEspecial > 0) {
            val calculoTaxaChequeEspecial = conta.valorUsadoChequeEspecial * 0.2
            println("Foi encontrada uma pendência:")
            println("Cheque Especial:")
            println("  Limite usado: ${conta.valorUsadoChequeEspecial}")
            println("  Taxa de utilização: ${calculoTaxaChequeEspecial}")
            if (conta.saldo >= calculoTaxaChequeEspecial) {
                conta.saldo -= calculoTaxaChequeEspecial
                println("A sua pendência do Cheque Especial foi quitada e o limite foi liberado.")
            } else if (conta.saldo < calculoTaxaChequeEspecial) {
                println("Falha: Saldo insuficiente para quitar a pendência ")
                println("Realize um novo depósito de + R$ ${calculoTaxaChequeEspecial - conta.saldo} ")
            }
        contaRepository.save(conta)
        }
    }
}