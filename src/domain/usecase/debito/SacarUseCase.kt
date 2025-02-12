package domain.usecase.debito

import data.ContaRepository

class SacarUseCase(private val contaRepository: ContaRepository) {
    fun executar(contaId: Int, valor: Double) {

        if (valor <= 0) {
            println("O valor a depositar deve ser maior que zero.")
            return
        }

        val conta = contaRepository.findById(contaId)
        if (conta == null ){
            println("Conta não encontrada")
            return
        }

        val valorDisponivelTotal = conta.saldo + conta.limiteChequeEspecial - conta.valorUsadoChequeEspecial
        if (valor > valorDisponivelTotal) {
            println("Saldo Insuficiente para realizar o saque.")
            return
        }

        if (conta.saldo < valor) {
            var diferenca = Math.abs(conta.saldo - valor)
            conta.valorUsadoChequeEspecial += diferenca
            conta.saldo = 0.00
            println("- R$ ${conta.valorUsadoChequeEspecial} DEBITADO DO CHEQUE ESPECIAL")


        } else {
            conta.saldo -= valor
        }
        contaRepository.save(conta)

        println("- R$ $valor SAQUE DO SALDO EM CONTA")
        println("Novo saldo: R$ ${conta.saldo}")
    }
}