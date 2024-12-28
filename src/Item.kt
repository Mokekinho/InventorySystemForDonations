open class Item(val name: String, val price : Double, val description: String) { // por padrões classes não podem ser herdadas a menos que possuam open

    val id: Int = generateId()// ID gerado automaticamente
    private var qtd = 0

    companion object { //como se criasse uma variavel estatica, ainda nao entendi muito bem como funciona
        private var currentId = 0
        fun generateId(): Int {
            currentId++
            return currentId
        }
    }
    override fun toString(): String {
        return  """
            Id : $id
            Name: $name
            Price: R\$ ${String.format("%.2f", price)}
            Description: $description
            Quantity: $qtd
        """.trimIndent()
    }

    fun plusQtd(qtd : Int){
        this.qtd += qtd
    }

}
