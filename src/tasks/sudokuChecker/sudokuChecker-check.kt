package tasks.sudokuChecker

import sudokuChecker

fun main(){
    check(
        message = "case 01: valid sudoku - grid 01 from https://github.com/dimitri/sudoku/blob/master/sudoku.txt - should return true",
        result = sudokuChecker(
            sudokuInput =
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
        message = "case 02: duplicate in column - should return false",
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
        message = "case 03: duplicate in row - should return false",
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
        message = "case 04: duplicate in subgrid - should return false",
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
        message = "case 05: duplicate in subgrid - should return false",
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
        message = "case 06: valid sudoku - grid 06 from https://github.com/dimitri/sudoku/blob/master/sudoku.txt - should return true",
        result = sudokuChecker(
            sudokuInput =
                "1--92----" +
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
    listOf(1, 2, 5, 3).sorted()
    check(
        message = "case 07: invalid grid because not enough rows - should return false",
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
        message = "case 08: empty input - should return false",
        result = sudokuChecker(
            sudokuInput =
                ""
        ),
        correctResult = false
    )
    check(
        message = "case 09: random input - should return false",
        result = sudokuChecker(
            sudokuInput =
                "lgxglnui75%6d'&jhcmh\njyx"
        ),
        correctResult = false
    )
    check(
        message = "case 10: invalid grid with one row having 5 cells - should return false",
        result = sudokuChecker(
            sudokuInput =
                "1--92----" +
                "524-1----" +
                "-------7-" +
                "-5---81-2" +
                "---------" +
                "4-27-" +           // invalid row with 5 cells
                "-6-------" +
                "----3-945" +
                "----71--6"
        ),
        correctResult = false
    )
    check(
        message = "case 11: completed sudoku from https://github.com/bvluong/sudoku/blob/master/puzzles/sudoku1-solved.txt - should return true",
        result = sudokuChecker(
            sudokuInput =
                "483921657" +
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
        message = "case 12: duplication - should return false",
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
        message = "case 13: a character other than '123456789-' is used - should return false",
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
        message = "case 14: a row with too few cells - should return false",
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
        message = "case 15: a row with too many cells - should return false",
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
        message = "case 16: a valid 16x16 sudoku from https://gist.github.com/vaskoz/8212615#file-sudoku_prob_16_16-txt - should return true",
        result = sudokuChecker(
            sudokuInput =
                " 0 15 0 1 0 2 10 14 12 0 0 0 0 0 0 0" +
                " 0 6 3 16 12 0 8 4 14 15 1 0 2 0 0 0" +
                " 14 0 9 7 11 3 15 0 0 0 0 0 0 0 0 0" +
                " 4 13 2 12 0 0 0 0 6 0 0 0 0 15 0 0" +
                " 0 0 0 0 14 1 11 7 3 5 10 0 0 8 0 12" +
                " 3 16 0 0 2 4 0 0 0 14 7 13 0 0 5 15" +
                " 11 0 5 0 0 0 0 0 0 9 4 0 0 6 0 0" +
                " 0 0 0 0 13 0 16 5 15 0 0 12 0 0 0 0" +
                " 0 0 0 0 9 0 1 12 0 8 3 10 11 0 15 0" +
                " 2 12 0 11 0 0 14 3 5 4 0 0 0 0 9 0" +
                " 6 3 0 4 0 0 13 0 0 11 9 1 0 12 16 2" +
                " 0 0 10 9 0 0 0 0 0 0 12 0 8 0 6 7" +
                " 12 8 0 0 16 0 0 10 0 13 0 0 0 5 0 0" +
                " 5 0 0 0 3 0 4 6 0 1 15 0 0 0 0 0" +
                " 0 9 1 6 0 14 0 11 0 0 2 0 0 0 10 8" +
                " 0 14 0 0 0 13 9 0 4 12 11 8 0 0 2 0 ",
            subGridSize = 4,
            emptyCell = '0',
            cellValues = " 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 ",
            delimiter = " "
        ),
        correctResult = true
    )
    check(
        message = "case 17: a complete 16x16 sudoku from https://gist.github.com/vaskoz/8212615#file-sudoku_prob_16_16-txt - should return true",
        result = sudokuChecker(
            sudokuInput =
                " 8 15 11 1 6 2 10 14 12 7 13 3 16 9 4 5" +
                " 10 6 3 16 12 5 8 4 14 15 1 9 2 11 7 13" +
                " 14 5 9 7 11 3 15 13 8 2 16 4 12 10 1 6" +
                " 4 13 2 12 1 9 7 16 6 10 5 11 3 15 8 14" +
                " 9 2 6 15 14 1 11 7 3 5 10 16 4 8 13 12" +
                " 3 16 12 8 2 4 6 9 11 14 7 13 10 1 5 15" +
                " 11 10 5 13 8 12 3 15 1 9 4 2 7 6 14 16" +
                " 1 4 7 14 13 10 16 5 15 6 8 12 9 2 3 11" +
                " 13 7 16 5 9 6 1 12 2 8 3 10 11 14 15 4" +
                " 2 12 8 11 7 16 14 3 5 4 6 15 1 13 9 10" +
                " 6 3 14 4 10 15 13 8 7 11 9 1 5 12 16 2" +
                " 15 1 10 9 4 11 5 2 13 16 12 14 8 3 6 7" +
                " 12 8 4 3 16 7 2 10 9 13 14 6 15 5 11 1" +
                " 5 11 13 2 3 8 4 6 10 1 15 7 14 16 12 9" +
                " 7 9 1 6 15 14 12 11 16 3 2 5 13 4 10 8" +
                " 16 14 15 10 5 13 9 1 4 12 11 8 6 7 2 3 ",
            subGridSize = 4,
            emptyCell = '0',
            cellValues = " 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 ",
            delimiter = " "
        ),
        correctResult = true
    )
    check(
        message = "case 18: duplication - 16x16 sudoku - should return false",
        result = sudokuChecker(
            sudokuInput =
                " 0 15 0 1 0 2 10 14 12 0 0 0 0 0 0 0" +
                " 0 6 3 16 12 0 8 4 14 15 1 0 2 0 0 0" +
                " 14 0 9 7 11 3 15 0 0 0 0 0 0 0 0 0" +
                " 4 13 2 12 0 0 0 0 6 0 0 0 0 15 0 0" +
                " 0 0 0 0 14 1 11 7 3 5 10 0 0 8 0 12" +
                " 3 16 0 0 2 4 0 0 0 14 7 13 0 0 5 15" +
                " 11 0 5 0 0 0 0 0 0 9 4 0 0 6 0 0" +
                " 0 0 0 0 13 0 16 5 15 0 0 12 0 0 0 0" +
                " 0 0 0 0 9 0 1 12 0 8 3 10 11 0 15 0" +
                " 2 12 0 11 0 9 14 3 5 4 0 0 0 0 9 0" + // 9 duplication in this row
                " 6 3 0 4 0 0 13 0 0 11 9 1 0 12 16 2" +
                " 0 0 10 9 0 0 0 0 0 0 12 0 8 0 6 7" +
                " 12 8 0 0 16 0 0 10 0 13 0 0 0 5 0 0" +
                " 5 0 0 0 3 0 4 6 0 1 15 0 0 0 0 0" +
                " 0 9 1 6 0 14 0 11 0 0 2 0 0 0 10 8" +
                " 0 14 0 0 0 13 9 0 4 12 11 8 0 0 2 0 ",
            subGridSize = 4,
            emptyCell = '0',
            cellValues = " 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 ",
            delimiter = " "
        ),
        correctResult = false
    )
    check(
        message = "case 19: valid sudoku from case 6, but with letters instead of numbers, and a comma delimiter - should return true",
        result = sudokuChecker(
            sudokuInput = ",a,-,-,i,b,-,-,-,-,e,b,d,-,a,-,-,-,-,-,-,-,-,-,-,-,g,-,-,e,-,-,-,h,a,-,b,-,-,-,-,-,-,-,-,-,d,-,b,g,-,-,-,i,-,-,f,-,-,-,-,-,-,-,-,-,-,-,c,-,i,d,e,-,-,-,-,g,a,-,-,f,",
            cellValues = ",a,b,c,d,e,f,g,h,i,",
            delimiter = ","
        ),
        correctResult = true
    )
    check(
        message = "case 20: improper delimiter, but with letters instead of numbers, and a comma delimiter - should return false",
        result = sudokuChecker(
            sudokuInput =
                ",a,,,-,i,b,-,-,-,-" +
                ",e,b,d,-,a,-,-,-,-" +
                ",-,-,-,-,-,-,-,g,-" +
                ",-,e,-,-,-,h,a,-,b" +
                ",-,-,-,-,-,-,-,-,-" +
                ",d,-,b,g,-,-,-,i,-" +
                ",-,f,-,-,-,-,-,-,-" +
                ",-,-,-,-,c,-,i,d,e" +
                ",-,-,-,-,g,a,-,-,f,",
            cellValues = ",a,b,c,d,e,f,g,h,i,",
            delimiter = ","
        ),
        correctResult = false
    )
    check(
        message = "case 21: not spacing delimiter - should return false",
        result = sudokuChecker(
            sudokuInput =
                ",a,-,-,i,b,-,-,-,-" +
                ",e,b,d,-,a,-,-,-,-" +
                ",-,-,-,-,-,-,-,g,-" +
                ",-,e,-,-,-,h,a,-,b" +
                ",-,-,-,-,-,-,-,-,-" +
                ",d,-,b,g,-,-,-,i,-" +
                ",-,f,-,-,-,-,-,-,-" +
                ",-,-,-,-,c,-,i,d,e" +
                ",-,-,-,-,g,a,-,-,f,",
            cellValues = ",a,b,c,d,e,f,g,h,i,",
            // delimiters = ","
        ),
        correctResult = false
    )
    check(
        message = "case 22: incorrect empty cell - should return false",
        result = sudokuChecker(
            sudokuInput =
                ",a,-,-,i,b,-,-,-,-" +
                ",e,b,d,-,a,-,-,-,-" +
                ",-,-,-,-,-,-,-,g,-" +
                ",-,e,-,-,-,h,a,-,b" +
                ",-,-,-,-,-,-,-,-,-" +
                ",d,-,b,g,-,-,-,i,-" +
                ",-,f,-,-,-,-,-,-,-" +
                ",-,-,-,-,c,-,i,d,e" +
                ",-,-,-,-,g,a,-,-,f,",
            cellValues = ",a,b,c,d,e,f,g,h,i,",
            emptyCell = '0',    // should '-'
            delimiter = ","
        ),
        correctResult = false
    )
    check(
        message = "case 23: incomplete cellValues - should return false",
        result = sudokuChecker(
            sudokuInput =
                ",a,-,-,i,b,-,-,-,-" +
                ",e,b,d,-,a,-,-,-,-" +
                ",-,-,-,-,-,-,-,g,-" +
                ",-,e,-,-,-,h,a,-,b" +
                ",-,-,-,-,-,-,-,-,-" +
                ",d,-,b,g,-,-,-,i,-" +
                ",-,f,-,-,-,-,-,-,-" +
                ",-,-,-,-,c,-,i,d,e" +
                ",-,-,-,-,g,a,-,-,f,",
            cellValues = ",a,b,c,d,e,f,g,h,", // incomplete, i is missing
            delimiter = ","
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