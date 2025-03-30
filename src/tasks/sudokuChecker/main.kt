fun main() {
    print(
        sudokuChecker9x9(
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
        )
    )
}

/**
 * Checks if the given string represents a valid 9x9 Sudoku puzzle.
 *
 * @param sudokuInput A string representing a 9x9 Sudoku grid, where each line is separated by '\n'.
 *                    Digits 1-9 indicate filled cells, and '-' indicate empty cells.
 * @return `true` if the input is a valid Sudoku, `false` otherwise.
 *
 * Example:
 * ```
 * sudokuChecker9x9(
 *     sudokuInput = "1--92----\n" +
 *                   "524-1----\n" +
 *                   "-------7-\n" +
 *                   "-5---81-2\n" +
 *                   "---------\n" +
 *                   "4-27---9-\n" +
 *                   "-6-------\n" +
 *                   "----3-945\n" +
 *                   "----71--6\n"
 * )
 * ```
 */
fun sudokuChecker9x9(sudokuInput: String): Boolean {
    // tasks
        // tasks.SudokuChecker.check there are 9 rows, each contain 9 cells, each cell is included in "123456789-", and end with '\n'
        // tasks.SudokuChecker.check non-duplicates in each row
        // tasks.SudokuChecker.check non-duplicates in each column
        // tasks.SudokuChecker.check non-duplicate in each 3x3 sub-grid

    // algorithm
        // tasks.SudokuChecker.check first that the list length is equal to 90, if not, return false.
        //      this tasks.SudokuChecker.check, together with the tasks.SudokuChecker.check that every row contains 9 characters,
        //      will guarantee that there are indeed 9 columns
        // loop through all indexed characters in sudokuInput
        //      if character is in "123456789-" and index % 10 != 9, tasks.SudokuChecker.check for duplication (excluding '-') by checking
        //           if the character already exist in rows, columns, and subgrid3X3 arrays
        //      if no duplication, record the character in rows, columns, and subgrid3X3 arrays
        //      if character == '\n', then it must be that index % 10 == 9, otherwise return false
        //          this guarantees that each row has 9 characters
        //      if all checks passed, return true

    val rows : MutableList<String> = MutableList(9) { "" }
    val columns : MutableList<String> = MutableList(9) { "" }
    val subgrid3X3 : MutableList<String> = MutableList(9) { "" }

    if (sudokuInput.length != 90) return false  // in the long run, this will guarantee the correct number of rows
                                                // since we will tasks.SudokuChecker.check later that each row has 10 characters, so there are 9 rows

    sudokuInput.toCharArray().forEachIndexed{ index, c ->
        if (c in "123456789-" && index % 10 != 9) {
            // checks for duplication in each row, column, and subgrid3X3
            if (c != '-' &&
                    (
                        // rowIndex = index / 10, this will be in 0..8 since index is in 0..89
                        c in rows[index / 10] ||
                        // columnIndex = index % 10, this will be in 0..8 since index % 10 != 9
                        c in columns[index % 10] ||
                        // subgrid3X3Index = 3 * ((index / 10) / 3) + (index % 10) / 3 , this will be in 0..8
                        c in subgrid3X3[3 * ((index / 10) / 3) + (index % 10) / 3]
                    )
            ) {
                return false
            }
            // record non-duplicated values
            rows[index / 10] = rows[index / 10] + c
            columns[index % 10] = columns[index % 10] + c
            subgrid3X3[3 * ((index / 10) / 3) + (index % 10) / 3] = subgrid3X3[3 * ((index / 10) / 3) + (index % 10) / 3] + c
        }
        else if (c == '\n'){
            if (index % 10 != 9) return false // this ensures each row has 9 characters
        }
        else return false
    }

//    println(sudokuInput)
//    println(rows)
//    println(columns)
//    println(subgrid3X3)
    return true
}