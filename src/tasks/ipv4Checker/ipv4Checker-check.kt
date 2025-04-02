package tasks.ipv4Checker

import ipv4Checker

fun main(){
    check(
        message = "when input is valid, then return true",
        result = ipv4Checker("192.168.0.1"),
        correctResult = true
    )
    check(
        message = "when input has too few numerical segments, then return false",
        result = ipv4Checker("192.168.0"),
        correctResult = false
    )
    check(
        message = "when input has too many numerical segments, then return false",
        result = ipv4Checker("192.3.255.1.87"),
        correctResult = false
    )
    check(
        message = "when input is empty, then return false",
        result = ipv4Checker(""),
        correctResult = false
    )
    check(
        message = "when input is random, then return false",
        result = ipv4Checker("ojhi6rxxyzlkjh.,mvxyx5u@$#"),
        correctResult = false
    )
    check(
        message = "when input has a missing numerical segment, then return false",
        result = ipv4Checker("192.168..1"),
        correctResult = false
    )
    check(
        message = "when input has a numerical segment above the limit of 255, then return false",
        result = ipv4Checker("192.836.6.1"),
        correctResult = false
    )
    check(
        message = "when input has an invalid character, then return false",
        result = ipv4Checker("1&2.3a.6.1"),
        correctResult = false
    )
    check(
        message = "when input has a non zero numerical segment with leading zero, then return false",
        result = ipv4Checker("192.3.06.1"),
        correctResult = false
    )
    check(
        message = "when input has a numerical segment consist of multiple zeros, then return false",
        result = ipv4Checker("000.3.6.1"),
        correctResult = false
    )
    check(
        message = "when input has a negative numerical segment, then return false",
        result = ipv4Checker("-192.3.255.1"),
        correctResult = false
    )
    check(
        message = "when input has a minus zero, then return false",
        result = ipv4Checker("255.255.255.-0"),
        correctResult = false
    )
    check(
        message = "when input has a space, then return false",
        result = ipv4Checker("255. 255.255.0"),
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