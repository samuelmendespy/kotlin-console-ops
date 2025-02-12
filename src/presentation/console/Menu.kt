package presentation.console

class Menu (
    private val adaptadorConsultarSaldo: AdaptadorConsultarSaldo,
    private val adaptarDepositar: AdaptadorDepositar,
    private val adaptadorSacar: AdaptadorSacar,
    private val adaptadorPagarBoleto: AdaptadorPagarBoleto,
    private val adaptadorConsultarChequeEspecial: AdaptadorConsultarChequeEspecial,
    ) {
    fun exibirOpcoes(idConta: Int) {
        while (true) {
            println("\nMenu Principal")
            println("1. Consultar Saldo")
            println("2. Depositar dinheiro")
            println("3. Sacar dinheiro")
            println("4. Consultar Cheque Especial")
            println("5. Pagar Boleto")
            println("0. Sair")

            when (readLine()?.toIntOrNull()) {
                1 -> {
                    println("Consultar Saldo")
                    adaptadorConsultarSaldo.executar(idConta)
                }
                2 -> {
                    println("Depositar Dinheiro")
                    println("Digite o valor a depositar: ")
                    val valor = readLine().toString()
                    adaptarDepositar.executar(idConta, valor)
                }
                3 -> {
                    println("Sacar Dinheiro")
                    println("Digite o valor a sacar: ")
                    val valor = readLine().toString()
                    adaptadorSacar.executar(idConta, valor)
                }
                4 -> {
                    println("Consultar Cheque Especial")
                    adaptadorConsultarChequeEspecial.executar(idConta)
                }
                5 -> {
                    println("Pagar Boleto")
                    println("Digite o CODIGO do Boleto: ")
                    val codigo = readLine().toString()
                    println("Digite o valor do Boleto: ")
                    val valor = readLine().toString()
                    adaptadorPagarBoleto.executar(idConta, codigo, valor)
                }
                0 -> break
                else -> println("Opção inválida")
            }
        }
    }
}