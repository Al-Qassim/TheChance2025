package tasks.sudokuChecker

import sudokuChecker

fun main(){

    check(
        message = "when sudoku grid is valid, then return true",
        result = sudokuChecker(
            sudokuInput =           // grid 01 from https://github.com/dimitri/sudoku/blob/master/sudoku.txt
                "--3-2-6--" +
                "9--3-5--1" +
                "--18-64--" +
                "--81-29--" +
                "7-------8" +
                "--67-82--" +
                "--26-95--" +
                "8--2-3--9" +
                "--5-1-3--"
        ),
        correctResult = true
    )
    check(
        message = "when column has a duplicate, then return false",
        result = sudokuChecker(
            sudokuInput =
                "3---8-3--" +       // 3 duplicate in first column
                "-6--7--84" +
                "-3-5--2-9" +
                "---1-54-8" +
                "---------" +
                "4-27-6---" +
                "3-1--7-4-" +       // 3 duplicate in first column
                "72--4--6-" +
                "--4-1---3"
        ),
        correctResult = false
    )
    check(
        message = "when row has a duplicate, then return false",
        result = sudokuChecker(
            sudokuInput =
                "------9-7" +
                "---42-18-" +
                "---2-5-26" +       // row with duplicated 2
                "1--9-4---" +
                "-5-----4-" +
                "---5-7--9" +
                "92-1-8---" +
                "-34-59---" +
                "5-7------"
        ),
        correctResult = false
    )
    check(
        message = "when sub-grid has a duplicate, then return false",
        result = sudokuChecker(
            sudokuInput =
                "-3--5--4-" +       // 3 duplicate in upper right subgrid
                "--3-1-5--" +
                "46-----12" +
                "-7-5-2-8-" +
                "---6-3---" +
                "-4-1-9-3-" +
                "25-----98" +
                "--1-2-6--" +
                "-8--6--2-"
        ),
        correctResult = false
    )
    check(
        message = "when sub-grid has a duplicate (v2), then return false",
        result = sudokuChecker(
            sudokuInput =
                "-2-81-74-" +
                "7----31--" +
                "-9---28-5" +
                "--934--87" +       // 3 duplication in middle subgrid
                "4--2-8--3" +
                "16--3-2--" +
                "3-27---6-" +
                "--56----8" +
                "-76-51-9-"
        ),
        correctResult = false
    )
    check(
        message = "when sudoku is valid (v2), then return true",
        result = sudokuChecker(
            sudokuInput =
                "1--92----" +       // grid 06 from https://github.com/dimitri/sudoku/blob/master/sudoku.txt
                "524-1----" +
                "-------7-" +
                "-5---81-2" +
                "---------" +
                "4-27---9-" +
                "-6-------" +
                "----3-945" +
                "----71--6"
        ),
        correctResult = true
    )
    check(
        message = "when grid has not enough rows, then return false",
        result = sudokuChecker(
            sudokuInput =
                "1--92----" +
                "524-1----" +
                "-------7-" +
                "-5---81-2" +
                "---------" +
                "4-27---9-" +
                "-6-------"         // only 7 rows
        ),
        correctResult = false
    )
    check(
        message = "when grid is empty, then return false",
        result = sudokuChecker(
            sudokuInput =
                ""
        ),
        correctResult = false
    )
    check(
        message = "when input random, then return false",
        result = sudokuChecker(
            sudokuInput =
                "lgxglnui75%6d'&jhcmh\njyx"
        ),
        correctResult = false
    )
    check(
        message = "when rows have missing cells, then return false",
        result = sudokuChecker(
            sudokuInput =
                "1--92----" +
                "524-1----" +
                "-------7-" +
                "-5---81-2" +
                "---------" +
                "4-27    -" +           // invalid row with 5 cells
                "-6-------" +
                "----3-945" +
                "----71--6"
        ),
        correctResult = false
    )
    check(
        message = "when sudoku is valid and complete, then return true",
        result = sudokuChecker(
            sudokuInput =
                "483921657" +       // sudoku from https://github.com/bvluong/sudoku/blob/master/puzzles/sudoku1-solved.txt
                "967345821" +
                "251876493" +
                "548132976" +
                "729564138" +
                "136798245" +
                "372689514" +
                "814253769" +
                "695417382"
        ),
        correctResult = true
    )
    check(
        message = "when a complete sudoku has a duplication, then return false",
        result = sudokuChecker(
            sudokuInput =
                "135984276" +
                "928716453" +
                "674532981" +
                "869347512" +
                "543261798" +
                "712659634" +       // 6 duplication in 6th row and 4th column
                "291673845" +
                "386495127" +
                "457128369"
        ),
        correctResult = false
    )
    check(
        message = "when invalid character is used, then return false",
        result = sudokuChecker(
            sudokuInput =
                "-a-81-74-" +       // letter a
                "7----31--" +
                "-9---%8-5" +       // symbol %
                "--93&--87" +       // symbol &
                "4--2-8--3" +
                "16--3-b--" +
                "S-27---6-" +       // letter S
                "--@6----8" +       // symbol @
                "-76-51-9-"
        ),
        correctResult = false
    )
    check(
        message = "when a rows have too few cells, then return false",
        result = sudokuChecker(
            sudokuInput =
                "1--92-" +          // too few cells
                "524-1----" +
                "-------7-" +
                "-5---81-2" +
                "-------" +         // too few cells
                "4-27---9-" +
                "-6-------" +
                "----3-94" +        // too few cells
                "----71--6"
        ),
        correctResult = false
    )
    check(
        message = "when a rows have too many cells, then return false",
        result = sudokuChecker(
            sudokuInput =
                "1--92----" +
                "524-1----" +
                "-------7-" +
                "-5---81-256" +     // too many cells
                "-----------9" +    // too many cells
                "4-27---9-" +
                "-6-------38" +     // too many cells
                "----3-945" +
                "----71--6"
        ),
        correctResult = false
    )
    check(
        message = "when sudoku is valid and 16x16, then return true",
        result = sudokuChecker(
            sudokuInput =       //  sudoku from https://gist.github.com/vaskoz/8212615#file-sudoku_prob_16_16-txt
                "0 15 0 1 0 2 10 14 12 0 0 0 0 0 0 0 " +
                "0 6 3 16 12 0 8 4 14 15 1 0 2 0 0 0 " +
                "14 0 9 7 11 3 15 0 0 0 0 0 0 0 0 0 " +
                "4 13 2 12 0 0 0 0 6 0 0 0 0 15 0 0 " +
                "0 0 0 0 14 1 11 7 3 5 10 0 0 8 0 12 " +
                "3 16 0 0 2 4 0 0 0 14 7 13 0 0 5 15 " +
                "11 0 5 0 0 0 0 0 0 9 4 0 0 6 0 0 " +
                "0 0 0 0 13 0 16 5 15 0 0 12 0 0 0 0 " +
                "0 0 0 0 9 0 1 12 0 8 3 10 11 0 15 0 " +
                "2 12 0 11 0 0 14 3 5 4 0 0 0 0 9 0 " +
                "6 3 0 4 0 0 13 0 0 11 9 1 0 12 16 2 " +
                "0 0 10 9 0 0 0 0 0 0 12 0 8 0 6 7 " +
                "12 8 0 0 16 0 0 10 0 13 0 0 0 5 0 0 " +
                "5 0 0 0 3 0 4 6 0 1 15 0 0 0 0 0 " +
                "0 9 1 6 0 14 0 11 0 0 2 0 0 0 10 8 " +
                "0 14 0 0 0 13 9 0 4 12 11 8 0 0 2 0",
            emptyCell = '0',
            delimiter = " "
        ),
        correctResult = true
    )
    check(
        message = "when a 16x16 sudoku is complete, then return true",
        result = sudokuChecker(
            sudokuInput =       // from https://gist.github.com/vaskoz/8212615#file-sudoku_prob_16_16-txt
                "8 15 11 1 6 2 10 14 12 7 13 3 16 9 4 5 " +
                "10 6 3 16 12 5 8 4 14 15 1 9 2 11 7 13 " +
                "14 5 9 7 11 3 15 13 8 2 16 4 12 10 1 6 " +
                "4 13 2 12 1 9 7 16 6 10 5 11 3 15 8 14 " +
                "9 2 6 15 14 1 11 7 3 5 10 16 4 8 13 12 " +
                "3 16 12 8 2 4 6 9 11 14 7 13 10 1 5 15 " +
                "11 10 5 13 8 12 3 15 1 9 4 2 7 6 14 16 " +
                "1 4 7 14 13 10 16 5 15 6 8 12 9 2 3 11 " +
                "13 7 16 5 9 6 1 12 2 8 3 10 11 14 15 4 " +
                "2 12 8 11 7 16 14 3 5 4 6 15 1 13 9 10 " +
                "6 3 14 4 10 15 13 8 7 11 9 1 5 12 16 2 " +
                "15 1 10 9 4 11 5 2 13 16 12 14 8 3 6 7 " +
                "12 8 4 3 16 7 2 10 9 13 14 6 15 5 11 1 " +
                "5 11 13 2 3 8 4 6 10 1 15 7 14 16 12 9 " +
                "7 9 1 6 15 14 12 11 16 3 2 5 13 4 10 8 " +
                "16 14 15 10 5 13 9 1 4 12 11 8 6 7 2 3",
            emptyCell = '0',
            delimiter = " "
        ),
        correctResult = true
    )
    check(
        message = "when a 16x16 sudoku has a duplication, then return false",
        result = sudokuChecker(
            sudokuInput =
                "0 15 0 1 0 2 10 14 12 0 0 0 0 0 0 0 " +
                "0 6 3 16 12 0 8 4 14 15 1 0 2 0 0 0 " +
                "14 0 9 7 11 3 15 0 0 0 0 0 0 0 0 0 " +
                "4 13 2 12 0 0 0 0 6 0 0 0 0 15 0 0 " +
                "0 0 0 0 14 1 11 7 3 5 10 0 0 8 0 12 " +
                "3 16 0 0 2 4 0 0 0 14 7 13 0 0 5 15 " +
                "11 0 5 0 0 0 0 0 0 9 4 0 0 6 0 0 " +
                "0 0 0 0 13 0 16 5 15 0 0 12 0 0 0 0 " +
                "0 0 0 0 9 0 1 12 0 8 3 10 11 0 15 0 " +
                "2 12 0 11 0 9 14 3 5 4 0 0 0 0 9 0 " + // 9 duplication in this row
                "6 3 0 4 0 0 13 0 0 11 9 1 0 12 16 2 " +
                "0 0 10 9 0 0 0 0 0 0 12 0 8 0 6 7 " +
                "12 8 0 0 16 0 0 10 0 13 0 0 0 5 0 0 " +
                "5 0 0 0 3 0 4 6 0 1 15 0 0 0 0 0 " +
                "0 9 1 6 0 14 0 11 0 0 2 0 0 0 10 8 " +
                "0 14 0 0 0 13 9 0 4 12 11 8 0 0 2 0",
            emptyCell = '0',
            delimiter = " "
        ),
        correctResult = false
    )
    check(
        message = "when improper delimiter is used in the sudoku, then return false",
        result = sudokuChecker(
            sudokuInput =
                "1,,,-,9,2,-,-,-,-," +    // improper use here
                "5,2,4,-,1,-,-,-,-," +
                "-,-,-,-,-,-,-,7,-," +
                "-,5,-,-,-,8,1,-,2," +
                "-,-,-,-,-,-,-,-,-," +
                "4,-,2,7,-,-,-,9,-," +
                "-,6,-,-,-,-,-,-,-," +
                "-,-,-,-,3,-,9,4,5," +
                "-,-,-,-,7,1,-,-,6",
            delimiter = ","
        ),
        correctResult = false
    )
    check(
        message = "when not using the default delimiter in the sudoku with out passing it to the delimiter parameter, then return false",
        result = sudokuChecker(
            sudokuInput =
                "1,-,-,9,2,-,-,-,-," +
                "5,2,4,-,1,-,-,-,-," +
                "-,-,-,-,-,-,-,7,-," +
                "-,5,-,-,-,8,1,-,2," +
                "-,-,-,-,-,-,-,-,-," +
                "4,-,2,7,-,-,-,9,-," +
                "-,6,-,-,-,-,-,-,-," +
                "-,-,-,-,3,-,9,4,5," +
                "-,-,-,-,7,1,-,-,6",
            // delimiters = ","                  // not specified
        ),
        correctResult = false
    )
    check(
        message = "when passing an incorrect value for the empty cell, then return false",
        result = sudokuChecker(
            sudokuInput =
                "1,-,-,9,2,-,-,-,-," +
                "5,2,4,-,1,-,-,-,-," +
                "-,-,-,-,-,-,-,7,-," +
                "-,5,-,-,-,8,1,-,2," +
                "-,-,-,-,-,-,-,-,-," +
                "4,-,2,7,-,-,-,9,-," +
                "-,6,-,-,-,-,-,-,-," +
                "-,-,-,-,3,-,9,4,5," +
                "-,-,-,-,7,1,-,-,6",
            emptyCell = '0',            // should '-'
            delimiter = ","
        ),
        correctResult = false
    )
    check(
        message = "when sudoku is a valid 3x3 grid, then return true",
        result = sudokuChecker(
            sudokuInput =
                "1--" +
                "32-" +
                "-3-"
        ),
        correctResult = true
    )
    check(
        message = "when sudoku doesn't have a valid dimensions, then return false",
        result = sudokuChecker(
            sudokuInput =            // 7x7 is not valid
                "1--32--" +
                "524-1--" +
                "-------" +
                "-5---71" +
                "-------" +
                "4-27---" +
                "-6-----"
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