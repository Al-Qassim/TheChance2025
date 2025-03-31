fun main() {
    println(sudokuChecker9x9(
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
    ))
}

/**
 * Checks if the given string represents a valid 9x9 Sudoku puzzle.
 *
 * @param sudokuInput A string representing a 9x9 Sudoku grid. Digits 1-9 indicate filled cells, and '-' indicate empty cells.
 * @return `true` if the input is a valid Sudoku, `false` otherwise.
 *
 * Example:
 * ```
 * sudokuChecker9x9(
 *     sudokuInput = "1--92----" +
 *                   "524-1----" +
 *                   "-------7-" +
 *                   "-5---81-2" +
 *                   "---------" +
 *                   "4-27---9-" +
 *                   "-6-------" +
 *                   "----3-945" +
 *                   "----71--6"
 * )
 * // true
 *
 * sudokuChecker9x9(
 *     sudokuInput = "2--92----" + // duplicate 2
 *                   "524-1----" +
 *                   "-------7-" +
 *                   "-5---81-2" +
 *                   "---------" +
 *                   "4-27---9-" +
 *                   "-6-------" +
 *                   "----3-945" +
 *                   "----71--6"
 * )
 * // false
 * ```
 */
fun sudokuChecker9x9(sudokuInput: String): Boolean {
    // tasks
        // check there are 81 cells, witch indicate 9x9 grid
        // check all cells contains one of "123456789-"
        // check non-duplicates in each row
        // check non-duplicates in each column
        // check non-duplicate in each 3x3 sub-grid

    // algorithm
        // check first that the list length is equal to 81, if not, return false.
        //      this check indicate 9x9 grid
        // loop through all indexed characters in sudokuInput
        //      if character is in "123456789-", check for duplication (excluding '-') by checking
        //           if the character already exist in rows, columns, and subgrid3X3 arrays
        //      if no duplication, record the character in rows, columns, and subgrid3X3 arrays
        // if all checks passed, return true

    val rows : MutableList<String> = MutableList(9) { "" }
    val columns : MutableList<String> = MutableList(9) { "" }
    val subgrid3X3 : MutableList<String> = MutableList(9) { "" }

    if (sudokuInput.length != 81) return false  // in the long run, this will guarantee the correct number of rows
                                                // since we will tasks.SudokuChecker.check later that each row has 10 characters, so there are 9 rows

    sudokuInput.toCharArray().forEachIndexed{ index, c ->
        if (c in "123456789-") {
            // region checks for duplication in each row, column, and subgrid3X3
            if (c != '-' &&
                    (
                        // rowIndex = index / 9, this will be in 0..8 since index is in 0..80
                        c in rows[index / 9] ||
                        // columnIndex = index % 9, this will be in 0..8 since index % 9 != 9
                        c in columns[index % 9] ||
                        // subgrid3X3Index = 3 * (rowIndex / 3) + columnIndex / 3 , this will be in 0..8
                        c in subgrid3X3[3 * ((index / 9) / 3) + (index % 9) / 3]
                    )
            ) {
                return false
            }
            // endregion
            // region record non-duplicated values
            rows[index / 9] = rows[index / 9] + c
            columns[index % 9] = columns[index % 9] + c
            subgrid3X3[3 * ((index / 9) / 3) + (index % 9) / 3] = subgrid3X3[3 * ((index / 9) / 3) + (index % 9) / 3] + c
            // endregion
        }
        else return false
    }
    return true
}


/**
 * Checks if the given string represents a valid Sudoku puzzle.
 *
 * @param sudokuInput A string representing a Sudoku grid. make sure to start and end with delimiter
 * @param subGridSize integer that determines the sudoku size. default is 3 witch gives the usual 9x9 sudoku.
 * @param emptyCell A char that indicate empty cells, default is '-'.
 * @param cellValues A string representing the valid cell values, it's length must be subGridSize * subGridSize, with no duplicates. default "123456789". make sure to start and end with delimiter
 * @param delimiter A string representing the separation between cells. default is empty string "".
 *
 * @return `true` if the sudokuInput is a valid Sudoku, `false` otherwise.
 *
 *
 * ```
 * // Example 1:
 * sudokuChecker(
 *     sudokuInput =
 *          "1--92----" +
 *          "524-1----" +
 *          "-------7-" +
 *          "-5---81-2" +
 *          "---------" +
 *          "4-27---9-" +
 *          "-6-------" +
 *          "----3-945" +
 *          "----71--6"
 * ) // true
 *
 * // Example 2:
 * sudokuChecker(
 *     sudokuInput =
 *          "2--92----" + // duplicate 2
 *          "524-1----" +
 *          "-------7-" +
 *          "-5---81-2" +
 *          "---------" +
 *          "4-27---9-" +
 *          "-6-------" +
 *          "----3-945" +
 *          "----71--6"
 * ) // false
 *
 * // Example 3:
 * sudokuChecker(
 *      sudokuInput =
 *          " 0 15 0 1 0 2 10 14 12 0 0 0 0 0 0 0" +
 *          " 0 6 3 16 12 0 8 4 14 15 1 0 2 0 0 0" +
 *          " 14 0 9 7 11 3 15 0 0 0 0 0 0 0 0 0" +
 *          " 4 13 2 12 0 0 0 0 6 0 0 0 0 15 0 0" +
 *          " 0 0 0 0 14 1 11 7 3 5 10 0 0 8 0 12" +
 *          " 3 16 0 0 2 4 0 0 0 14 7 13 0 0 5 15" +
 *          " 11 0 5 0 0 0 0 0 0 9 4 0 0 6 0 0" +
 *          " 0 0 0 0 13 0 16 5 15 0 0 12 0 0 0 0" +
 *          " 0 0 0 0 9 0 1 12 0 8 3 10 11 0 15 0" +
 *          " 2 12 0 11 0 0 14 3 5 4 0 0 0 0 9 0" +
 *          " 6 3 0 4 0 0 13 0 0 11 9 1 0 12 16 2" +
 *          " 0 0 10 9 0 0 0 0 0 0 12 0 8 0 6 7" +
 *          " 12 8 0 0 16 0 0 10 0 13 0 0 0 5 0 0" +
 *          " 5 0 0 0 3 0 4 6 0 1 15 0 0 0 0 0" +
 *          " 0 9 1 6 0 14 0 11 0 0 2 0 0 0 10 8" +
 *          " 0 14 0 0 0 13 9 0 4 12 11 8 0 0 2 0 ",
 *      subGridSize = 4,
 *      emptyCell = '0',
 *      cellValues = " 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 ",
 *      delimiter = " "
 * )  // true
 *
 * // Example 4:
 * sudokuChecker(
 *      sudokuInput = ",a,-,-,i,b,-,-,-,-,e,b,d,-,a,-,-,-,-,-,-,-,-,-,-,-,g,-,-,e,-,-,-,h,a,-,b,-,-,-,-,-,-,-,-,-,d,-,b,g,-,-,-,i,-,-,f,-,-,-,-,-,-,-,-,-,-,-,c,-,i,d,e,-,-,-,-,g,a,-,-,f,",
 *      cellValues = ",a,b,c,d,e,f,g,h,i,",
 *      delimiter = ","
 * ) // true
 * ```
 */
fun sudokuChecker(
    sudokuInput: String,
    subGridSize: Int = 3,
    emptyCell: Char = '-',
    cellValues: String = "123456789",
    delimiter: String = ""
): Boolean {
    // requirements:
    //      valid inputs
    //      cells values included in cellValues + emptyCell
    //      non-duplicates in each row
    //      non-duplicates in each column
    //      non-duplicate in each sub-grid

    // algorithm:
    //      check for valid inputs
    //          check positive number for subGridSize
    //          check for correct length of cellValues
    //          check non duplication in cellValues
    //          check first that the list length is equal to subGridSize * subGridSize * subGridSize * subGridSize, if not, return false.
    //      loop through all indexed characters in sudokuInput
    //          if character is in cellValues + emptyCell, check for duplication (excluding emptyCell) by
    //              checking if the character already exist in rows, columns, and subGrids arrays
    //          if no duplication, record the character in rows, columns, and subGrids arrays
    //      if all checks passed, return true

    // Note:
    //      "hello".split("") returns ["", "h", "e", "l", "l", "o", ""],
    //      so it's necessary to exclude the first and last elements with slice(1..length),
    //      and this is why it's necessary to subtract 2 if we want to count the number of characters after splitting be delimiter
    //      also, this is why it's necessary to put delimiter in the start and end of sudokuInput

    val dim = subGridSize * subGridSize

    // check inputs
        // subGridSize should be positive
    if (subGridSize <= 0) return false
        // cellValues should contain #dim values
    if (cellValues.split(delimiter).size - 2 != dim) return false
        // check for no duplication in cellValues
    for ((index, c) in cellValues.split(delimiter).slice(1..dim).withIndex()){
        if (c in cellValues.split(delimiter).slice(1..index)) return false
    }
        // sudokuInput should contain #(dim * dim) values
    if (sudokuInput.split(delimiter).size - 2 != dim * dim) return false

    // initialize the main arrays to check for duplication
    val rows : MutableList<MutableList<String>> = MutableList(dim){ mutableListOf() }
    val columns : MutableList<MutableList<String>> = MutableList(dim){ mutableListOf() }
    val subGrids : MutableList<MutableList<String>> = MutableList(dim){ mutableListOf() }

    // loop through all chars in sudokuInput
    sudokuInput.split(delimiter).slice(1..dim * dim).forEachIndexed{ index, c ->
        if (c in cellValues + emptyCell) {
            // checks for duplication in each row, column, and subGrids
            if (c != emptyCell.toString() &&
                    (
                        // rowIndex = index / dim
                        c in rows[index / dim] ||
                        // columnIndex = index % dim
                        c in columns[index % dim] ||
                        // subGridsIndex = subGridSize * (rowIndex / subGridSize) + columnIndex / subGridSize, this will be in 0 until dim
                        c in subGrids[subGridSize * ((index / dim) / subGridSize) + (index % dim) / subGridSize]
                    )
            ) {
                return false
            }
            // record non-duplicated values
            rows[index / dim].add(c)
            columns[index % dim].add(c)
            subGrids[subGridSize * ((index / dim) / subGridSize) + (index % dim) / subGridSize].add(c)
        }
        else {
            // if we fine an invalid character, return false
            return false
        }

    }
    return true
}
