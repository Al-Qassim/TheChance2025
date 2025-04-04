package tasks.sudokuChecker

fun main(){

    check(
        message = "when sudoku grid is valid, then return true",
        result = sudokuChecker(
            sudokuPlainText =           // grid 01 from https://github.com/dimitri/sudoku/blob/master/sudoku.txt
                "-,-,3,-,2,-,6,-,-," +
                "9,-,-,3,-,5,-,-,1," +
                "-,-,1,8,-,6,4,-,-," +
                "-,-,8,1,-,2,9,-,-," +
                "7,-,-,-,-,-,-,-,8," +
                "-,-,6,7,-,8,2,-,-," +
                "-,-,2,6,-,9,5,-,-," +
                "8,-,-,2,-,3,-,-,9," +
                "-,-,5,-,1,-,3,-,-"
        ),
        correctResult = true
    )
    check(
        message = "when column has a duplicate, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "3,-,-,-,8,-,1,-,-," +       // 3 duplicate in first column
                "-,6,-,-,7,-,-,8,4," +
                "-,3,-,5,-,-,2,-,9," +
                "-,-,-,1,-,5,4,-,8," +
                "-,-,-,-,-,-,-,-,-," +
                "4,-,2,7,-,6,-,-,-," +
                "3,-,1,-,-,7,-,4,-," +       // 3 duplicate in first column
                "7,2,-,-,4,-,-,6,-," +
                "-,-,4,-,1,-,-,-,3"
        ),
        correctResult = false
    )
    check(
        message = "when row has a duplicate, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "-,-,-,-,-,-,9,-,7," +
                "-,-,-,4,2,-,1,8,-," +
                "-,-,-,2,-,5,-,2,6," +       // row with duplicated 2
                "1,-,-,9,-,4,-,-,-," +
                "-,5,-,-,-,-,-,4,-," +
                "-,-,-,5,-,7,-,-,9," +
                "9,2,-,1,-,8,-,-,-," +
                "-,3,4,-,5,9,-,-,-," +
                "5,-,7,-,-,-,-,-,-"
        ),
        correctResult = false
    )
    check(
        message = "when sub-grid has a duplicate, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "-,3,-,-,5,-,-,4,-," +       // 3 duplicate in upper right subgrid
                "-,-,3,-,1,-,5,-,-," +
                "4,6,-,-,-,-,-,1,2," +
                "-,7,-,5,-,2,-,8,-," +
                "-,-,-,6,-,3,-,-,-," +
                "-,4,-,1,-,9,-,3,-," +
                "2,5,-,-,-,-,-,9,8," +
                "-,-,1,-,2,-,6,-,-," +
                "-,8,-,-,6,-,-,2,-"
        ),
        correctResult = false
    )
    check(
        message = "when sub-grid has a duplicate (v2), then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "-,2,-,8,1,-,7,4,-," +
                "7,-,-,-,-,3,1,-,-," +
                "-,9,-,-,-,2,8,-,5," +
                "-,-,9,3,4,-,-,8,7," +       // 3 duplication in middle subgrid
                "4,-,-,2,-,8,-,-,3," +
                "1,6,-,-,3,-,2,-,-," +
                "3,-,2,7,-,-,-,6,-," +
                "-,-,5,6,-,-,-,-,8," +
                "-,7,6,-,5,1,-,9,-"
        ),
        correctResult = false
    )
    check(
        message = "when sudoku is valid (v2), then return true",
        result = sudokuChecker(
            sudokuPlainText =
                "1,-,-,9,2,-,-,-,-," +       // grid 06 from https://github.com/dimitri/sudoku/blob/master/sudoku.txt
                "5,2,4,-,1,-,-,-,-," +
                "-,-,-,-,-,-,-,7,-," +
                "-,5,-,-,-,8,1,-,2," +
                "-,-,-,-,-,-,-,-,-," +
                "4,-,2,7,-,-,-,9,-," +
                "-,6,-,-,-,-,-,-,-," +
                "-,-,-,-,3,-,9,4,5," +
                "-,-,-,-,7,1,-,-,6"
        ),
        correctResult = true
    )
    check(
        message = "when grid has not enough rows, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "1,-,-,9,2,-,-,-,-," +
                "5,2,4,-,1,-,-,-,-," +
                "-,-,-,-,-,-,-,7,-," +
                "-,5,-,-,-,8,1,-,2," +
                "-,-,-,-,-,-,-,-,-," +
                "4,-,2,7,-,-,-,9,-," +
                "-,6,-,-,-,-,-,-,-"         // only 7 rows
        ),
        correctResult = false
    )
    check(
        message = "when grid is empty, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                ""
        ),
        correctResult = false
    )
    check(
        message = "when input random, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "lgxglnui75%6d'&jhcmh\njyx"
        ),
        correctResult = false
    )
    check(
        message = "when rows have missing cells, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "1,-,-,9,2,-,-,-,-," +
                "5,2,4,-,1,-,-,-,-," +
                "-,-,-,-,-,-,-,7,-," +
                "-,5,-,-,-,8,1,-,2," +
                "-,-,-,-,-,-,-,-,-," +
                "4,-,2,7, , , , ,-," +           // invalid row with 5 cells
                "-,6,-,-,-,-,-,-,-," +
                "-,-,-,-,3,-,9,4,5," +
                "-,-,-,-,7,1,-,-,6"
        ),
        correctResult = false
    )
    check(
        message = "when sudoku is valid and complete, then return true",
        result = sudokuChecker(
            sudokuPlainText =
                "4,8,3,9,2,1,6,5,7," +       // sudoku from https://github.com/bvluong/sudoku/blob/master/puzzles/sudoku1-solved.txt
                "9,6,7,3,4,5,8,2,1," +
                "2,5,1,8,7,6,4,9,3," +
                "5,4,8,1,3,2,9,7,6," +
                "7,2,9,5,6,4,1,3,8," +
                "1,3,6,7,9,8,2,4,5," +
                "3,7,2,6,8,9,5,1,4," +
                "8,1,4,2,5,3,7,6,9," +
                "6,9,5,4,1,7,3,8,2"
        ),
        correctResult = true
    )
    check(
        message = "when a complete sudoku has a duplication, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "1,3,5,9,8,4,2,7,6," +
                "9,2,8,7,1,6,4,5,3," +
                "6,7,4,5,3,2,9,8,1," +
                "8,6,9,3,4,7,5,1,2," +
                "5,4,3,2,6,1,7,9,8," +
                "7,1,2,6,5,9,6,3,4," +       // 6 duplication in 6th row and 4th column
                "2,9,1,6,7,3,8,4,5," +
                "3,8,6,4,9,5,1,2,7," +
                "4,5,7,1,2,8,3,6,9"
        ),
        correctResult = false
    )
    check(
        message = "when invalid character is used, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "-,a,-,8,1,-,7,4,-," +       // letter a
                "7,-,-,-,-,3,1,-,-," +
                "-,9,-,-,-,%,8,-,5," +       // symbol %
                "-,-,9,3,&,-,-,8,7," +       // symbol &
                "4,-,-,2,-,8,-,-,3," +
                "1,6,-,-,3,-,b,-,-," +
                "S,-,2,7,-,-,-,6,-," +       // letter S
                "-,-,@,6,-,-,-,-,8," +       // symbol @
                "-,7,6,-,5,1,-,9,-"
        ),
        correctResult = false
    )
    check(
        message = "when a rows have too few cells, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "1,-,-,9,2,-," +          // too few cells
                "5,2,4,-,1,-,-,-,-," +
                "-,-,-,-,-,-,-,7,-," +
                "-,5,-,-,-,8,1,-,2," +
                "-,-,-,-,-,-,-," +         // too few cells
                "4,-,2,7,-,-,-,9,-," +
                "-,6,-,-,-,-,-,-,-," +
                "-,-,-,-,3,-,9,4," +        // too few cells
                "-,-,-,-,7,1,-,-,6"
        ),
        correctResult = false
    )
    check(
        message = "when a rows have too many cells, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "1,-,-,9,2,-,-,-,-," +
                "5,2,4,-,1,-,-,-,-," +
                "-,-,-,-,-,-,-,7,-," +
                "-,5,-,-,-,8,1,-,2,5,6," +     // too many cells
                "-,-,-,-,-,-,-,-,-,-,-,9," +    // too many cells
                "4,-,2,7,-,-,-,9,-," +
                "-,6,-,-,-,-,-,-,-,3,8," +     // too many cells
                "-,-,-,-,3,-,9,4,5," +
                "-,-,-,-,7,1,-,-,6"
        ),
        correctResult = false
    )
    check(
        message = "when sudoku is valid and 16x16, then return true",
        result = sudokuChecker(
            sudokuPlainText =       //  sudoku from https://gist.github.com/vaskoz/8212615#file-sudoku_prob_16_16-txt
                "-,15,-,1,-,2,10,14,12,-,-,-,-,-,-,-," +
                "-,6,3,16,12,-,8,4,14,15,1,-,2,-,-,-," +
                "14,-,9,7,11,3,15,-,-,-,-,-,-,-,-,-," +
                "4,13,2,12,-,-,-,-,6,-,-,-,-,15,-,-," +
                "-,-,-,-,14,1,11,7,3,5,10,-,-,8,-,12," +
                "3,16,-,-,2,4,-,-,-,14,7,13,-,-,5,15," +
                "11,-,5,-,-,-,-,-,-,9,4,-,-,6,-,-," +
                "-,-,-,-,13,-,16,5,15,-,-,12,-,-,-,-," +
                "-,-,-,-,9,-,1,12,-,8,3,10,11,-,15,-," +
                "2,12,-,11,-,-,14,3,5,4,-,-,-,-,9,-," +
                "6,3,-,4,-,-,13,-,-,11,9,1,-,12,16,2," +
                "-,-,10,9,-,-,-,-,-,-,12,-,8,-,6,7," +
                "12,8,-,-,16,-,-,10,-,13,-,-,-,5,-,-," +
                "5,-,-,-,3,-,4,6,-,1,15,-,-,-,-,-," +
                "-,9,1,6,-,14,-,11,-,-,2,-,-,-,10,8," +
                "-,14,-,-,-,13,9,-,4,12,11,8,-,-,2,-",
        ),
        correctResult = true
    )
    check(
        message = "when a 16x16 sudoku is complete, then return true",
        result = sudokuChecker(
            sudokuPlainText =       // from https://gist.github.com/vaskoz/8212615#file-sudoku_prob_16_16-txt
                "8,15,11,1,6,2,10,14,12,7,13,3,16,9,4,5," +
                "10,6,3,16,12,5,8,4,14,15,1,9,2,11,7,13," +
                "14,5,9,7,11,3,15,13,8,2,16,4,12,10,1,6," +
                "4,13,2,12,1,9,7,16,6,10,5,11,3,15,8,14," +
                "9,2,6,15,14,1,11,7,3,5,10,16,4,8,13,12," +
                "3,16,12,8,2,4,6,9,11,14,7,13,10,1,5,15," +
                "11,10,5,13,8,12,3,15,1,9,4,2,7,6,14,16," +
                "1,4,7,14,13,10,16,5,15,6,8,12,9,2,3,11," +
                "13,7,16,5,9,6,1,12,2,8,3,10,11,14,15,4," +
                "2,12,8,11,7,16,14,3,5,4,6,15,1,13,9,10," +
                "6,3,14,4,10,15,13,8,7,11,9,1,5,12,16,2," +
                "15,1,10,9,4,11,5,2,13,16,12,14,8,3,6,7," +
                "12,8,4,3,16,7,2,10,9,13,14,6,15,5,11,1," +
                "5,11,13,2,3,8,4,6,10,1,15,7,14,16,12,9," +
                "7,9,1,6,15,14,12,11,16,3,2,5,13,4,10,8," +
                "16,14,15,10,5,13,9,1,4,12,11,8,6,7,2,3",
        ),
        correctResult = true
    )
    check(
        message = "when a 16x16 sudoku has a duplication, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "-,15,-,1,-,2,10,14,12,-,-,-,-,-,-,-," +
                "-,6,3,16,12,-,8,4,14,15,1,-,2,-,-,-," +
                "14,-,9,7,11,3,15,-,-,-,-,-,-,-,-,-," +
                "4,13,2,12,-,-,-,-,6,-,-,-,-,15,-,-," +
                "-,-,-,-,14,1,11,7,3,5,10,-,-,8,-,12," +
                "3,16,-,-,2,4,-,-,-,14,7,13,-,-,5,15," +
                "11,-,5,-,-,-,-,-,-,9,4,-,-,6,-,-," +
                "-,-,-,-,13,-,16,5,15,-,-,12,-,-,-,-," +
                "-,-,-,-,9,-,1,12,-,8,3,10,11,-,15,-," +
                "2,12,-,11,-,9,14,3,5,4,-,-,-,-,9,-," +// 9 duplication in this row
                "6,3,-,4,-,-,13,-,-,11,9,1,-,12,16,2," +
                "-,-,10,9,-,-,-,-,-,-,12,-,8,-,6,7," +
                "12,8,-,-,16,-,-,10,-,13,-,-,-,5,-,-," +
                "5,-,-,-,3,-,4,6,-,1,15,-,-,-,-,-," +
                "-,9,1,6,-,14,-,11,-,-,2,-,-,-,10,8," +
                "-,14,-,-,-,13,9,-,4,12,11,8,-,-,2,-",
        ),
        correctResult = false
    )
    check(
        message = "when improper delimiter is used in the sudoku, then return false",
        result = sudokuChecker(
            sudokuPlainText =
                "1,,,-,9,2,-,-,-,-," +    // improper use here
                "5,2,4,-,1,-,-,-,-," +
                "-,-,-,-,-,-,-,7,-," +
                "-,5,-,-,-,8,1,-,2," +
                "-,-,-,-,-,-,-,-,-," +
                "4,-,2,7,-,-,-,9,-," +
                "-,6,-,-,-,-,-,-,-," +
                "-,-,-,-,3,-,9,4,5," +
                "-,-,-,-,7,1,-,-,6",
        ),
        correctResult = false
    )
    check(
        message = "when sudoku is a valid 4x4 grid, then return true",
        result = sudokuChecker(
            sudokuPlainText =
                "1,-,-,4," +
                "3,2,-,1," +
                "-,3,-,2," +
                "-,1,-,3"
        ),
        correctResult = true
    )
    check(
        message = "when sudoku doesn't have a valid dimensions, then return false",
        result = sudokuChecker(
            sudokuPlainText =            // 7x7 is not valid
                "1,-,-,3,2,-,-," +
                "5,2,4,-,1,-,-," +
                "-,-,-,-,-,-,-," +
                "-,5,-,-,-,7,1," +
                "-,-,-,-,-,-,-," +
                "4,-,2,7,-,-,-," +
                "-,6,-,-,-,-,-"
        ),
        correctResult = false
    )
    check(
        message = "when passing a valid sudoku that doesn't contain one of the numbers completely , then return true",
        result = sudokuChecker(
            sudokuPlainText =
                "-,-,-,9,2,-,-,-,-," +
                "5,2,4,-,1,-,-,-,-," +
                "-,-,-,-,-,-,-,7,-," +
                "-,5,-,-,-,8,-,-,2," +
                "-,-,-,-,-,-,-,-,-," +
                "4,-,2,7,-,-,-,9,-," +
                "-,6,-,-,-,-,-,-,-," +
                "-,-,-,-,3,-,9,4,5," +
                "-,-,-,-,7,-,-,-,6",
        ),
        correctResult = true
    )
}

fun check(message: String, result: Boolean, correctResult: Boolean){
    if (result == correctResult) {
        println("Success - $message")
    } else {
        println("Failure - $message")
    }
}