package tasks.sudokuChecker

import sudokuChecker9x9

fun main(){
    check(
        message = "case 01: valid sudoku - grid 01 from https://github.com/dimitri/sudoku/blob/master/sudoku.txt - should return true",
        result = sudokuChecker9x9(
            sudokuInput =
                "--3-2-6--\n" +
                "9--3-5--1\n" +
                "--18-64--\n" +
                "--81-29--\n" +
                "7-------8\n" +
                "--67-82--\n" +
                "--26-95--\n" +
                "8--2-3--9\n" +
                "--5-1-3--\n"
        ),
        correctResult = true
    )
    check(
        message = "case 02: duplicate in first column - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "3---8-3--\n" +
                "-6--7--84\n" +
                "-3-5--2-9\n" +
                "---1-54-8\n" +
                "---------\n" +
                "4-27-6---\n" +
                "3-1--7-4-\n" +
                "72--4--6-\n" +
                "--4-1---3\n"
        ),
        correctResult = false
    )
    check(
        message = "case 03: duplicate in third row - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "------9-7\n" +
                "---42-18-\n" +
                "---2-5-26\n" +
                "1--9-4---\n" +
                "-5-----4-\n" +
                "---5-7--9\n" +
                "92-1-8---\n" +
                "-34-59---\n" +
                "5-7------\n"
        ),
        correctResult = false
    )
    check(
        message = "case 04: duplicate in first 3x3 subgrid - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "-3--5--4-\n" +
                "--3-1-5--\n" +
                "46-----12\n" +
                "-7-5-2-8-\n" +
                "---6-3---\n" +
                "-4-1-9-3-\n" +
                "25-----98\n" +
                "--1-2-6--\n" +
                "-8--6--2-\n"
        ),
        correctResult = false
    )
    check(
        message = "case 05: duplicate in middle 3x3 subgrid - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "-2-81-74-\n" +
                "7----31--\n" +
                "-9---28-5\n" +
                "--934--87\n" +
                "4--2-8--3\n" +
                "16--3-2--\n" +
                "3-27---6-\n" +
                "--56----8\n" +
                "-76-51-9-\n"
        ),
        correctResult = false
    )
    check(
        message = "case 06: valid sudoku - grid 06 from https://github.com/dimitri/sudoku/blob/master/sudoku.txt - should return true",
        result = sudokuChecker9x9(
            sudokuInput =
                "1--92----\n" +
                "524-1----\n" +
                "-------7-\n" +
                "-5---81-2\n" +
                "---------\n" +
                "4-27---9-\n" +
                "-6-------\n" +
                "----3-945\n" +
                "----71--6\n"
        ),
        correctResult = true
    )
    listOf(1, 2, 5, 3).sorted()
    check(
        message = "case 07: invalid grid with 7 rows and 9 columns - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "1--92----\n" +
                "524-1----\n" +
                "-------7-\n" +
                "-5---81-2\n" +
                "---------\n" +
                "4-27---9-\n" +
                "-6-------\n"
        ),
        correctResult = false
    )
    check(
        message = "case 08: empty input - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                ""
        ),
        correctResult = false
    )
    check(
        message = "case 09: random input - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "lgxglnui75%6d'&jhcmh\njyx"
        ),
        correctResult = false
    )
    check(
        message = "case 10: invalid grid with one row having 5 cells - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "1--92----\n" +
                "524-1----\n" +
                "-------7-\n" +
                "-5---81-2\n" +
                "---------\n" +
                "4-27-\n" +
                "-6-------\n" +
                "----3-945\n" +
                "----71--6\n"
        ),
        correctResult = false
    )
    check(
        message = "case 11: completed sudoku from https://github.com/bvluong/sudoku/blob/master/puzzles/sudoku1-solved.txt - should return true",
        result = sudokuChecker9x9(
            sudokuInput =
                "483921657\n" +
                "967345821\n" +
                "251876493\n" +
                "548132976\n" +
                "729564138\n" +
                "136798245\n" +
                "372689514\n" +
                "814253769\n" +
                "695417382\n"
        ),
        correctResult = true
    )
    check(
        message = "case 12: duplication in 6th row and 4th column - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "135984276\n" +
                "928716453\n" +
                "674532981\n" +
                "869347512\n" +
                "543261798\n" +
                "712659634\n" +
                "291673845\n" +
                "386495127\n" +
                "457128369\n"
        ),
        correctResult = false
    )
    check(
        message = "case 13: a character other than '123456789-\\n' is used - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "-a-81-74-\n" +
                "7----31--\n" +
                "-9---%8-5\n" +
                "--93&--87\n" +
                "4--2-8--3\n" +
                "16--3-b--\n" +
                "S-27---6-\n" +
                "--@6----8\n" +
                "-76-51-9-\n"
        ),
        correctResult = false
    )
    check(
        message = "case 14: not a proper end to a row - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "1--92----\n" +
                "524-1----\n" +
                "-------7-\n" +
                "-5---81-2\n" +
                "---------5" +
                "4-27---9-\n" +
                "-6-------\n" +
                "----3-945\n" +
                "----71--6\n"
        ),
        correctResult = false
    )
    check(
        message = "case 15: a row with too many cells - should return false",
        result = sudokuChecker9x9(
            sudokuInput =
                "1--92----\n" +
                "524-1----\n" +
                "-------7-\n" +
                "-5---81-2\n56" +
                "---------\n--9" +
                "4-27---9-\n" +
                "-6-------38\n" +
                "----3-945\n" +
                "----71--6\n"
        ),
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