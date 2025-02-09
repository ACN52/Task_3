package ru.netology

import java.util.*

// Задача №3. Меломан

/*
Условия акции
от 0 до 1 000 рублей — скидка не предоставляется
от 1 001 до 10 000 рублей — скидка составит 100 рублей (как в лекции)
от 10 001 рубля и выше — скидка составит 5% от суммы.

постоянные покупатели - дополнительная скидка— ещё 1% сверху
 */
fun main() {

    // Инициализируем переменные
    // -------------------------
    val constUsers: Boolean = true   // Постоянный покупатель
    val discount = 5.0/100  // скидка 5%
    val discount100 = 100   // скидка 100 руб
    val dopDiscount = 1.0/100 // дополнительная скидка— ещё 1% сверху
    var summaBuy = 0.0
    var itogSumma = 0.0

    var input = ""
    // -------------------------

    // Основной блок программы
    // -------------------------
    print("Введите сумму покупки: ")
    input = readln()

    if (input.isNotEmpty()) {
        summaBuy = input.toDouble()
        if (summaBuy <= 1000.0) {
            itogSumma = summaBuy
        } else if (summaBuy in 1001.0..10000.0) {
            itogSumma = summaBuy - discount100  // для обычных покупателей
            if (constUsers == true) itogSumma = itogSumma - (itogSumma * dopDiscount)  // для постоянных покупателей
        } else if (summaBuy >= 10001.0) {
            itogSumma = summaBuy - (summaBuy * discount)  // для обычных покупателей
            if (constUsers == true) itogSumma = itogSumma - (itogSumma * dopDiscount)  // для постоянных покупателей
        }

        val roundItogSumma = "%.2f".format(itogSumma) // Округляем результат до двух знаков после запятой
        print("Итоговая стоимость покупки: $roundItogSumma руб.")

    } else {
         print("Проверьте ввод данных !")
    }
    // -------------------------

}