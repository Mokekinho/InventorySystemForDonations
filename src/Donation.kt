class Donation(val donor: Donor?, val date: String, val itemId: Int, val qtd: Int) {

    fun incrementItem(items : List<Item>){
        for(item in items){
            if(item.id == itemId){
                item.plusQtd(qtd)
            }
        }
    }

    override fun toString(): String {
        val name : String
        if(donor == null) name = ""
        else name = donor.name

        return """
            Donor: $name
            Date: $date
            Item Id: $itemId
            Quantity: $qtd
        """.trimIndent()
    }

}