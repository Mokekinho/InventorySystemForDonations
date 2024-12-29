fun menu(): String{
    return """
        0 - Exit
        1 - Create a donor
        2 - Show donors
        3 - Create a Item
        4 - Show Items
        5 - Create Donation
        6 - Show Donations
          
    """.trimIndent()
}

fun FoodOrNot(): String{
    return """
        Y -  It's food
        N - It's not food
    """.trimIndent()
}


fun main() {
    val donors : MutableList<Donor> = mutableListOf() //pelo o que eu entendi mutableList<Donor> é opcional
    val items : MutableList<Item> = mutableListOf()
    val donations : MutableList<Donation> = mutableListOf()


    do {
        println(menu())
        var x = readLine() //readln não aceita valor nulos
        when (x) {
            "0" -> println("Saindo...")
            "1" -> {
                println("Type your name:")
                val name = readLine() ?: ""
                println("Type your age")
                val age = readLine()?.toIntOrNull() ?: 0

                val donor = Donor(name, age)
                donors.add(donor)
                println("Sign Up with success")
            }

            "2" -> {

                for (i in donors){

                    println(i)

                }
            }
            "3" -> {
                println("Type the Item name:")
                val name = readLine() ?: ""
                println("Type the Item price")
                val price = readLine()?.toDoubleOrNull() ?: 0.0
                println("Type the Item description")
                val description = readLine() ?: ""

                println(FoodOrNot())

                do{
                    var y =  readLine()
                    y = y?.uppercase()
                    var stop = true

                    when(y){
                        "Y" -> {
                            println("Type the validity")
                            val validity = readLine() ?: ""
                            val  food = Food(name, price, description, validity)
                            items.add(food)
                            stop = false
                        }
                        "N" -> {
                            println()
                            val item = Item(name, price, description)
                            items.add(item)
                            stop = false
                        }
                        else -> println("Wrong Input, type again")
                    }
                } while (stop)


            }
            "4" ->{
                for(item in items){
                    println(item)
                }
            }

            "5" -> {
                println("Type Donor id")
                val id = readLine()?.toIntOrNull() ?: 0
                var donor : Donor? = null
                var hasDonor = false
                for(i in donors){
                    if(id == i.id){
                        donor = i
                        hasDonor = true
                        break
                    }
                }

                println("Type the date")
                val date = readLine() ?: ""
                println("Type the Item Id of the donation")
                val intId = readLine()?.toIntOrNull() ?: 0
                println("Type the quantity of Items")
                val qtd = readLine()?.toIntOrNull() ?: 0

                val donation = Donation(donor, date, intId, qtd)
                donor?.donated(qtd)
                donation.incrementItem(items)
                donations.add(donation)

            }
            "6" -> {
                for(donation in donations){
                    println(donation)
                }
            }
            else -> println("Digite um número valido")
        }
    }
    while(x != "0")

}