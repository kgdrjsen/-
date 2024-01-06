package com.android.basic1

//21번 문제
//[21][최성진] 1~입력수 (특정 범위)의 숫자 안에서 짝수일때는 더하고 홀수일때 뺀 값을 출력(입력 : 1~20, 출력 : 10)  -1, +2, -3, +4, -5…..
//fun main(){
//    val num = readLine()!!.toInt()
//    var answer = 0
//
//    for (i in 1..num){
//        if (i%2 == 0){
//            answer += i
//        } else {
//            answer -= i
//        }
//    }
//    println("$answer")
//}


//22번 문제
//[22][유영국] 1부터 100까지의 수 중 2의 배수이지만 3의 배수는 아닌 수 출력하기 (입력: 없음 / 출력 : 2, 4, 8, 10, 14 .. 94, 98, 100)
//fun main() {
//    for (i in 1..100) {
//        if (i % 2 == 0 && i % 3 != 0) {
//            println(i)
//        }
//    }
//}


//23번 문제
//[23][유영국] 정수 num1과 num2를 입력받아 두 수 사이의 합 출력하기(입력: 3, 5 / 출력: 12), 두 수를 포함.
//일단 패스


//24번 문제
//[24][유영국] 정수들이 담긴 배열 arr[5개] 에서 자연수 n(입력받음)보다 큰 수의 개수 출력하기 (arr: [23, 52, 13, 26, 10], n:20 / 출력: 3)
//fun main(){
//    val arr = arrayOf(23,52,13,26,10)
//    println("숫자를 입력하시오")
//    var num = readLine()!!.toInt()
//
//    var count = 0
//    for (i in arr) {
//        if (i > num) {
//            count++
//        }
//    }
//    println("${count}")
//}


//25번 문제
//[25][추정호] 구구단을 2단부터 9단까지 출력하시오(입력 X / 출력: 2 * 1 = 2 ~ 9 * 9 = 81)
//fun main() {
//    for (i in 2..9) {
//        println("$i 단")
//        for (j in 1..9) {
//            println("$i x $j = ${i * j}")
//        }
//    }
//}


//26번 문제
//[26][추정호] 사용자로부터 1~12 월을 입력 받아 해당 숫자에 맞는 계절을 출력하시오(입력 : 10 / 출력 : 가을) (12~2:겨울, 3~5:봄, 6~8:여름,9~11:가을)
//fun main() {
//    println("1~12만 입력하시오")
//    var num = readLine()!!.toIntOrNull()
//    when(num) {
//        12,1,2 -> {
//            println("겨울")
//        }
//        3,4,5 -> {
//            println("봄")
//        }
//        6,7,8 -> {
//            println("여름")
//        }
//        9,10,11 -> {
//            println("가을")
//        }
//        else -> {
//            println("1~12의 숫자가 아닙니다.")
//        }
//    }
//}


//27번 문제
//[27][추정호] 시작 수와 끝 수를 입력 받아 그 사이에 있는 5의 배수를 출력하시오 (입력 : 3, 38 / 출력 : 5, 10, 15, 20, 25, 30, 35)
//fun main() {
//    val num1 = readLine()!!.toInt()
//    val num2 = readLine()!!.toInt()
//
//    if (num1 < num2) {
//        for (i in num1..num2) {
//            if (i % 5 == 0) {
//                println(i)
//            }
//        }
//    } else {
//        for (i in num2..num1) {
//            if (i % 5 == 0) {
//                println(i)
//            }
//        }
//    }
//}


//28번 문제
//정수 1에서 100까지 숫자들 중 소수만을 더한 값 출력(입력 : 없음 / 출력 : ?)
//패스 원래 낸 문제가 아님


//29번 문제
//[29][김건두] 3과목의 점수를 입력 받아 평균을 구하고 90점에서 100점까지는 A, 80점에서 89점까지는 B, 70점에서 79점까지는 C, 그 이하는 D를 출력 (입력 : 80 / 출력 : B)
//fun main() {
//    var num1 = readLine()!!.toInt()
//    var num2 = readLine()!!.toInt()
//    var num3 = readLine()!!.toInt()
//
//    var avg = (num1+num2+num3)/3
//
//    when(avg) {
//        in 90..100 -> println("A")
//        in 80..89 ->println("B")
//        in 70..79 -> println("C")
//        in 0..69 -> println("D")
//        else -> println("잘못 입력하였습니다.")
//    }
//}


//30번 문제
//[30][김건두] 정수 3개를 입력하고 가장 큰 수를 출력 (입력 : 20, 1000, 400 / 출력 : 1000)
//fun main() {
//    var num1 = readLine()!!.toInt()
//    var num2 = readLine()!!.toInt()
//    var num3 = readLine()!!.toInt()
//
//    if (num1>num2 && num1>num3) {
//        return  println("${num1}")
//    }else if (num2>num1 && num2>num3) {
//        return  println("${num2}")
//    }else {
//        return  println("${num3}")
//    }
//}