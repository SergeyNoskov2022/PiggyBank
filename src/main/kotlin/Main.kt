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

    fun shake(): Money?  {
        // проверьте, не разбита ли копилка
        if (isBroken){
            println("Вы разбили копилку, больше оттуда ничего не вытрясти")
            return null
        }
        val iterator = moneys.iterator()
        while(iterator.hasNext()) {
            var coin = iterator.next()
            if (coin.isCoin){
                moneys.remove(coin)//удалаем монетку из копилки
                return coin
            }
        }
        return null//если в копилке нет монеток возвращаем null
    }



    fun smash(): ArrayList<Money> {
        isBroken = true
        println("Копилка разбита, вы достали оттуда: $moneys")
        return moneys      // установить флаг, что копилка разбита true, и вернуть все монетки, которые были в копилке
    }

}

// создайте класс Money, который будет отражать сущность монетки/купюры с двумя полями: amount и isCoin

class Money  private constructor (
    var amount:Float,
    var isCoin: Boolean
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

    // переопределите метод toString() так, чтобы он возвращал строку типа "10 коп.", если это монетка, и "100 руб.", если это купюра
    override fun toString(): String {
        if (amount < 1) return "${(amount*100).toInt()} коп." else return "${amount.toInt()} руб."
    }

}