class Donor(val name: String, var age: Int) {
    private var qtdDonation : Int = 0

    fun donated(qtdDonation: Int): Unit{
        this.qtdDonation += qtdDonation
    }
    fun aniversary(){
        age++
    }

    override fun toString(): String{
        return """
            Nome: $name
            Idade: $age
            Quantidade de Doações: $qtdDonation
        """.trimIndent()// se nao colocar essa chamada a Sting vai preservar os espaçoes em branco a direita
    }


}