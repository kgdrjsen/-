package com.android.basic1

// 1번 문제
//[1][이가현] 1~100까지 정수 중 홀수의 합을 출력해 주세요. [입력: X, 출력: 2500]
//fun main() {
//    var retrun = 0
//
//    for(i in 1..100) {
//        if (i % 2 != 0) {
//            retrun += i
//        }
//    }
//    println("1~100까지 정수 중 홀수 합은 $retrun 입니다.")
//}


//2번문제
//[2][이가현] 입력받은 문자열을 뒤집어서 출력해 주세요. [입력: abcde, 출력: edcba] 띄어쓰기 없고, 영문 소문자만
//fun main() {
//    while (true) {
//        var str = readLine()!!.toString()
//        var strM = str.toMutableList()
//
//        for (i in strM.indices) {
//            if (!strM[i].isUpperCase() && !str.bl.isEmpty()) {
//                println("${str.reversed()}")
//                break
//            } else {
//                println("다시 입력하시오")
//                break
//
//            }
//        }
//
//    }
//}


//3번문제
//[3][이가현] 입력 받은 정수의 홀짝을 구분하는 코드를 작성해 주세요.(0은 제외) [입력: 0, 출력: 다시 입력해 주세요.], [입력: 5, 출력: 홀수]
//fun main() {
//    while (true) {
//        var num1 = readLine()!!.toInt()
//        when {
//            num1 == 0 -> {
//                println("다시 입력하시오")
//            }
//
//            num1 % 2 == 0 -> {
//                println("짝수")
//                break
//            }
//
//            else -> {
//                println("홀수")
//                break
//            }
//        }
//    }
//}


//4번문제
//[4][박정현] 1~1000까지 정수중에, 3의 배수 "또는"   8의 배수에 속하는 값을 추출하고, 총합을 구하시오.  (3+6+8,9,12,,,,, 24는 아니고, 의 총합)
//fun main() {
//    var answer: Int = 0
//    for (i in 1..1000) {
//        if (i % 3 == 0 || i % 8 == 0) {
//            if ((i % 24 != 0)) {
//                println("$i")
//                answer += i
//            }
//        }
//    }
//    println("$answer")
//}


//5번 문제
//[5][박정현] 성적에 따라 반을 결정 하고자 한다. 0~24점은 E반, 25~49점은 D반, 50~74점은 C반, 75~99점은 B반, 100점은 A반이 출력되게 하시오. (입력: 87, 출력: B반)
//fun main() {
//    var grade = readLine()!!.toInt()
//
//    when (grade) {
//        100 -> {
//            println("A반")
//        }
//
//        in 75..99 -> {
//            println("B반")
//        }
//
//        in 50..74 -> {
//            println("C반")
//        }
//
//        in 25..49 -> {
//            println("D반")
//        }
//
//        in 0..24 -> {
//            println("E반")
//        }
//
//        else -> {
//            println("올바른 성적이 아닙니다.")
//        }
//    }
//}


//6번 문제
//[6][박정현] 사용자가 입력한 문자열에 '크리스마스'가 포함이면 '메리크리스마스,  '새해'가 포함이면 '새해 복 많이 받으세요', 이외의 단어면 '모두 행복하세요'가 출력되도록 코딩하시오
//fun main() {
//    var str = readLine()!!.toString()
//    if (str.contains("크리스마스")) {
//        println("메리크리스마스")
//    } else if (str.contains("새해")) {
//        println("새해 복 많이 받으세요")
//    } else {
//        println("모두 행복하세요")
//    }
//}


//7번 문제
//[7][문혜린] 입력받은 숫자만큼 증가하는 코드를 작성해주세요.(1~100까지) (입력 ex 3 / 출력 : 1 4 7 10 13 .. 94 97 100)
//fun main() {
//    var num = readLine()!!.toInt()
//    for (i in 1..100 step num) {
//        println(i)
//    }
//}


//8번 문제
//[8][문혜린] 3과목 점수를 입력받아 평균 점수를 출력하고, 평균 점수가 70점 이상이면 합격입니다를, 아니면 불합격입니다를 출력해주세요.
//fun main() {
//    println("3과목 점수를 입력하시오")
//    var score1 = readLine()!!.toInt()
//    var score2 = readLine()!!.toInt()
//    var score3 = readLine()!!.toInt()
//
//    var average = (score1 + score2 + score3) / 3
//    println("평균은 $average")
//
//    if (average >= 70) {
//        println("합격")
//    }else {
//        println("불합격")
//    }
//}


//9번 문제
//[9][문혜린] 숫자를 입력받아  입력 받은 숫자 높이 만큼의 별(*)을 피라미드 모양으로 출력해주세요.
//일단 패스


//10번 문제
//[10][정현우] 알파벳'a'의 개수 세기(입력:"apple", 출력:1), 대소문자 구분함.
//fun main() {
//    var str = readLine()!!.toString()
//    var answer = 0
//
//    for (i in str) {
//        if (i == 'a') {
//            answer++
//        }
//    }
//    println("$answer")
//}