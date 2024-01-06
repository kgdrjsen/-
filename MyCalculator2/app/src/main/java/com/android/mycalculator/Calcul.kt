package com.android.mycalculator

fun main() {
    println("계산기")
    println("숫자를 입력하시오")
    var num1 = readLine()!!.toDouble()
    println("숫자를 입력하시오")
    var num2 = readLine()!!.toDouble()
    println("1.더하기, 2.빼기, 3.곱하기, 4.나누기 중에서 고르시오.")
    var oper = readLine()!!.toInt()

    var cacl = Calcul()
    val result = cacl.calcul(num1,num2,oper)

    println("결과는 $result 입니다")

    println("추가로 계산을 원한다면 [1]번을, 종료를 원한다면 다른 키를 선택하시오")
    var num3 = readln()!!.toDouble()
    var num4 = readln()!!.toDouble()

    if (num3 == 1.0) {
        println("숫자를 입력하시오")
    }else {
        println("종료합니다")
    }

}

class Calcul {
    fun calcul (num1: Double, num2: Double, oper : Int) : Double {
        var answer : Double = 0.0
        if(oper == 1) {
            return num1 + num2
            // 덧셈일 때
        } else if(oper == 2) {
            return num1 - num2
            // 뺄셈일 때
        } else if(oper == 3) {
            return num1 * num2
            // 곱셈일 때
        } else if(oper == 4) {
            return num1 / num2
            // 나눗셈일 때
        } else {
            println("다시 눌러주세요")
            // 잘못된 연산자 일 때
        }
        return answer
    }
}