class Food(name: String, price: Double, description: String, val validity: String) : Item(name, price, description){ //nao precisa de var ou val para atributos herdados pois eles ja foram declarados

    override fun toString(): String {
        return super.toString() + """
            Validity: $validity
        """.trimIndent()
    }
}

