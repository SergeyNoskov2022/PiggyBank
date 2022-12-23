object PiggyBank {

    private var moneys = ArrayList<Money>() // список монеток/купюр
    private var isBroken: Boolean = false // свойство, определяющее, разбита ли копилка

    fun putMoney(money: Money) {
        if (isBroken) println("Вы разбили копилку, вы больше ничего положить туда не можете") // проверьте, не разбита ли копилка
        else {
            println("Добавлено в копилку $money")
            moneys.add(money)
        }  // добавьте монетку в копилку
    }

    fun shake(): Money? {
        if (isBroken) {
            val iterator = moneys.iterator()
            while (iterator.hasNext()) {
                val coin = iterator.next()
                if (coin.isCoin) {
                    moneys.remove(coin)
                    return coin
                }
            }
            return null // вытрясти монетку из копилки (если в копилке нет монетки, вернуть null). Помните, купюры вытрясти нельзя.
        } else {
            return null
            println("Вы разбили копилку, больше оттуда ничего не вытрясти")
        }
    }

    fun smash(): ArrayList<Money> {
        isBroken = true
        println("Копилка разбита, вы достали оттуда: $moneys")
        return moneys      // установить флаг, что копилка разбита true, и вернуть все монетки, которые были в копилке
    }
}

class Money private constructor(
    val amount: Float,
    val isCoin: Boolean
){
    companion object {
        val coins_10 = Money(0.1f, true)
        val coins_50 = Money(0.5f, true)
        val coins_100 = Money(1.0f, true)
        val bill_50 = Money(50f, false)
        val bill_100 = Money(100f, false)
        val bill_500 = Money(500f, false)
        val bill_1000 = Money(1000f, false)
    }

    override fun toString(): String {
        if (amount < 1) return "${(amount*100).toInt()} коп." else return "${amount.toInt()} руб."
    }
}

// создайте класс Money, который будет отражать сущность монетки/купюры с двумя полями: amount и isCoin
// переопределите метод toString() так, чтобы он возвращал строку типа "10 коп." или "1 руб.", если это монетка, и "100 руб.", если это купюра
// вы должны ограничить создание класса таким образом, чтобы можно было создать только ограниченный набор номиналов (см. задание)