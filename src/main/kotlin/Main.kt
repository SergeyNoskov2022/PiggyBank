object PiggyBank {

    private var money: ArrayList// список монеток/купюр
    private var isBroken: Boolean = false // свойство, определяющее, разбита ли копилка

    fun putMoney(money: Money) {
        if (isBroken) { // проверьте, не разбита ли копилка

        ...
        }// добавьте монетку в копилку
    }

    fun shake(): Money? {
        ... // проверьте, не разбита ли копилка

        ... // вытрясти монетку из копилки (если в копилке нет монетки, вернуть null). Помните, купюры вытрясти нельзя.
    }

    fun smash(): ArrayList<Money> {
        ... // установить флаг, что копилка разбита true, и вернуть все монетки, которые были в копилке
    }
}

class Money private constructor(
    val amount: Float,
    val isCoin: Boolean
){
    companion object {
        private val coins_10 = Money(0.1f, true)
        private val coins_50 = Money(0.5f, true)
        private val coins_100 = Money(1f, true)
        private val bill_50 = Money(50f, false)
        private val bill_100 = Money(100f, false)
        private val bill_500 = Money(500f, false)
        private val bill_1000 = Money(1000f, false)
    }

    override fun toString(): String {
        if (amount < 1) return "${(amount*100).toInt()} коп." else  return "${amount.toInt()} руб."
    }
}

// создайте класс Money, который будет отражать сущность монетки/купюры с двумя полями: amount и isCoin
// переопределите метод toString() так, чтобы он возвращал строку типа "10 коп." или "1 руб.", если это монетка, и "100 руб.", если это купюра
// вы должны ограничить создание класса таким образом, чтобы можно было создать только ограниченный набор номиналов (см. задание)