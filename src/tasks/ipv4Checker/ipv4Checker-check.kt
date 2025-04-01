package tasks.ipv4Checker

import ipv4Checker

fun main(){
    check(
        message = "case 1: valid input - should be true",
        result = ipv4Checker("192.168.0.1"),
        correctResult = true
    )
    check(
        message = "case 2: empty string input - should be false",
        result = ipv4Checker(""),
        correctResult = false
    )
    check(
        message = "case 3: random input - should be false",
        result = ipv4Checker("ojhi6rxxyzlkjh.,mvxyx5u@$#"),
        correctResult = false
    )
    check(
        message = "case 4: incomplete input - should be false",
        result = ipv4Checker("192.168.0"),
        correctResult = false
    )
    check(
        message = "case 5: missing numerical segment - should be false",
        result = ipv4Checker("192.168..1"),
        correctResult = false
    )
    check(
        message = "case 6: numerical segment out of range - should be false",
        result = ipv4Checker("192.836.6.1"),
        correctResult = false
    )
    check(
        message = "case 7: numerical segment out of range - should be false",
        result = ipv4Checker("9192.436.6.1"),
        correctResult = false
    )
    check(
        message = "case 8: invalid char in numerical segment - should be false",
        result = ipv4Checker("1&2.3a.6.1"),
        correctResult = false
    )
    check(
        message = "case 9: non zero numerical segment with leading zero - should be false",
        result = ipv4Checker("192.3.06.1"),
        correctResult = false
    )
    check(
        message = "case 9: numerical segment != '0' with leading zero - should be false",
        result = ipv4Checker("000.3.6.1"),
        correctResult = false
    )
    check(
        message = "case 10: negative numerical segment - should be false",
        result = ipv4Checker("-192.3.255.1"),
        correctResult = false
    )
    check(
        message = "case 11: too many numerical segments - should be false",
        result = ipv4Checker("192.3.255.1.87"),
        correctResult = false
    )
    check(
        message = "case 12: valid numerical segments - should be true",
        result = ipv4Checker("255.255.255.0"),
        correctResult = true
    )
    check(
        message = "case 13: put a minus zero - should be false",
        result = ipv4Checker("255.255.255.-0"),
        correctResult = false
    )
}

fun check(message: String, result: Boolean, correctResult: Boolean){
    if (result == correctResult) {
        println("Success - $message")
    } else {
        println("Failure - $message")
    }
}