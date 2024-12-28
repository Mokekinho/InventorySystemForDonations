fun menu(): String{
    return """
        1 - Create a donor
        2 - Mostrar doadores
        3 - Sair
    """.trimIndent()
}


fun main() {
    val donors : MutableList<Donor> = mutableListOf() //pelo o que eu entendi mutableList<Donor> é opcional
    do {
        println(menu())
        var x = readLine() //readln não aceita valor nulos
        when (x) {
            "1" -> {
                println("Digite o nome do doador:")
                val name = readLine() ?: ""
                println("Digite a idade do doador:")
                val age = readLine()?.toIntOrNull() ?: 0

                val donor = Donor(name, age)
                donors.add(donor)
                println("Usuario Cadastrado com sucesso")
            }

            "2" -> {

                for (i in donors.indices){
                    println("Doador: $i")
                    println(donors[i])

                }
            }

            "3" -> println("Saindo...")

            else -> println("Digite um número valido")
        }
    }
    while(x != "3")

}