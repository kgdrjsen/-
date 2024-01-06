package com.android.mycalculator

fun main() {
    println("계산기")
    println("숫자를 입력하시오")
    var num1 = readLine()!!.toDouble()
    println("연산자를 입력하시오")
    var opp = readLine()!!.toString()
    println("숫자를 입력하시오")
    var num2 = readLine()!!.toDouble()

    var cacl = Calculator()
    var result = 0.0

    if (opp == "+") {
        result = cacl.add(num1, num2)
    } else if (opp == "-") {
        result = cacl.minus(num1, num2)
    } else if (opp == "*") {
        result = cacl.multiple(num1, num2)
    } else if (opp == "/") {
        result = cacl.divide(num1, num2)
    }else if (opp == "%") {
        result = cacl.remainder(num1, num2)
    }else {
        println("다시 적으시오")
    }

    println("결과는 $result 입니다")

    while (true) {


        println("여기서 더 계산 하시려면 [1]번을, 종료하시려면 다른 키를 누르시오.")

        var num3 = readLine()!!.toInt()

        var num6 = result

        if (num3 == 1) {
            println("연산자를 입력하시오")
        } else {
            println("종료합니다.")
            break
        }

        var opp2 = readLine()!!.toString()
        println("숫자를 입력하시오")
        var num4 = readLine()!!.toDouble()



        if (opp2 == "+") {
            result = cacl.add(num6, num4)
        } else if (opp2 == "-") {
            result = cacl.minus(num6, num4)
        } else if (opp2 == "*") {
            result = cacl.multiple(num6, num4)
        } else if (opp2 == "/") {
            result = cacl.divide(num6, num4)
        } else if (opp2 == "%") {
            result = cacl.remainder(num6, num4)
        } else {
            println("다시 적으시오")
        }

        println("결과는 $result 입니다")
        continue
    }



}

class Calculator {

    fun add (num1: Double,num2: Double) = num1 + num2
    fun minus (num1: Double,num2: Double) = num1 - num2
    fun multiple (num1: Double, num2: Double) = num1 * num2
    fun divide (num1: Double, num2: Double) = num1 / num2
    fun remainder (num1: Double,num2: Double) = num1 % num2
}
