import kotlin.math.sqrt

fun main() {

    print("valid sudoku: " + sudokuChecker(
        sudokuInput =
            "1--92----" +
            "524-1----" +
            "-------7-" +
            "-5---81-2" +
            "---------" +
            "4-27---9-" +
            "-6-------" +
            "----3-945" +
            "----71--6",
        printInputAndInternalArrays = true
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
 * @param sudokuInput A string representing a Sudoku grid.
 * @param emptyCell A char that indicate empty cells, default is '-'
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
 *          "0 15 0 1 0 2 10 14 12 0 0 0 0 0 0 0 " +
 *          "0 6 3 16 12 0 8 4 14 15 1 0 2 0 0 0 " +
 *          "14 0 9 7 11 3 15 0 0 0 0 0 0 0 0 0 " +
 *          "4 13 2 12 0 0 0 0 6 0 0 0 0 15 0 0 " +
 *          "0 0 0 0 14 1 11 7 3 5 10 0 0 8 0 12 " +
 *          "3 16 0 0 2 4 0 0 0 14 7 13 0 0 5 15 " +
 *          "11 0 5 0 0 0 0 0 0 9 4 0 0 6 0 0 " +
 *          "0 0 0 0 13 0 16 5 15 0 0 12 0 0 0 0 " +
 *          "0 0 0 0 9 0 1 12 0 8 3 10 11 0 15 0 " +
 *          "2 12 0 11 0 0 14 3 5 4 0 0 0 0 9 0 " +
 *          "6 3 0 4 0 0 13 0 0 11 9 1 0 12 16 2 " +
 *          "0 0 10 9 0 0 0 0 0 0 12 0 8 0 6 7 " +
 *          "12 8 0 0 16 0 0 10 0 13 0 0 0 5 0 0 " +
 *          "5 0 0 0 3 0 4 6 0 1 15 0 0 0 0 0 " +
 *          "0 9 1 6 0 14 0 11 0 0 2 0 0 0 10 8 " +
 *          "0 14 0 0 0 13 9 0 4 12 11 8 0 0 2 0",
 *      emptyCell = '0',
 *      delimiter = " "
 * )  // true
 *
 * // Example 4:
 * sudokuChecker(
 *      sudokuInput = "a,-,-,i,b,-,-,-,-,e,b,d,-,a,-,-,-,-,-,-,-,-,-,-,-,g,-,-,e,-,-,-,h,a,-,b,-,-,-,-,-,-,-,-,-,d,-,b,g,-,-,-,i,-,-,f,-,-,-,-,-,-,-,-,-,-,-,c,-,i,d,e,-,-,-,-,g,a,-,-,f",
 *      delimiter = ","
 * ) // true
 * ```
 */
fun sudokuChecker(
    sudokuInput: String,
    emptyCell: Char = '-',
    delimiter: String = "",
    printInputAndInternalArrays : Boolean = false,
): Boolean {
    // requirements:
    //      check if input can be shaped as a sudoku
    //      non-duplicates in each row
    //      non-duplicates in each column
    //      non-duplicate in each sub-grid

    // algorithm:
    //      calculate sudoku dimensions
    //      check for valid inputs
    //          check positive number for dim
    //          check for correct length of unique values
    //          check if the number of values in sudokuInput is equal to subGridSize ^ 4
    //      loop through all indexed values in the sudoku
    //          detect duplication by checking if the value already exist in rows, columns, and subGrids arrays
    //          if no duplication, record the value in the arrays
    //      if all checks passed, return true


    var sudokuValues = sudokuInput.split(delimiter)

    // Note: "hello".split("") returns ["", "h", "e", "l", "l", "o", ""],
    //        so it's necessary to exclude the first and last elements if the delimiter is empty string ("")
    if (delimiter == ""){
        sudokuValues = sudokuValues.slice(1 ..< sudokuValues.lastIndex)
    }

    val uniqueValues = sudokuValues.distinct().filter { cellValue -> cellValue != emptyCell.toString() }
    // in usual case, uniqueValues = ["1", "2", ..., "9"]

    // calculate sudoku dimensions
    val dim = sqrt(sudokuValues.size.toFloat()).toInt()
    if (dim <= 0) return false
    val subGridSize = sqrt(dim.toFloat()).toInt()
    if (subGridSize <= 0) return false

    // check inputs
    // number of values should be equal to dim ^ 2 and dim should be equal to subGridSize
    if (dim * dim != sudokuValues.size && subGridSize * subGridSize != dim) return false
        // uniqueValues should contain #(dim + 1) values
    if (uniqueValues.size != dim) return false


    // initialize the main arrays to check for duplication
    val rows : MutableList<MutableList<String>> = MutableList(dim){ mutableListOf() }
    val columns : MutableList<MutableList<String>> = MutableList(dim){ mutableListOf() }
    val subGrids : MutableList<MutableList<String>> = MutableList(dim){ mutableListOf() }
    var rowIndex : Int
    var columnIndex : Int
    var subGridIndex : Int

    // loop through all values in sudokuValues
    for ((valueIndex, cellValue) in sudokuValues.withIndex()) {
        if (cellValue == emptyCell.toString()) {
            continue
        } else if (cellValue in uniqueValues) {

            // checks for duplication in each row, column, and subGrids
            rowIndex = valueIndex / dim
            columnIndex = valueIndex % dim
            subGridIndex = subGridSize * (rowIndex / subGridSize) + columnIndex / subGridSize

            if (
                cellValue in rows[rowIndex] ||
                cellValue in columns[columnIndex] ||
                cellValue in subGrids[subGridIndex]
                ) return false

            // record non-duplicated values
            rows[rowIndex].add(cellValue)
            columns[columnIndex].add(cellValue)
            subGrids[subGridIndex].add(cellValue)
        }
        else {
            // if we find an invalid character, return false
            return false
        }

    }

    // this is for presentation
    if (printInputAndInternalArrays) {
        var inputString = ""
        for ((index, value) in sudokuValues.withIndex()){
            inputString += String.format("%3s", value)
            if ((index % dim + 1) % subGridSize == 0) inputString += String.format("%3s", "|")
            if ((index / dim + 1) % subGridSize == 0 && (index % dim + 1) == dim) {
                inputString += "\n"
                for (i in 1..dim) {
                    inputString += String.format("%3s", "---")
                    if (i % subGridSize == 0) inputString += String.format("%3s", "--+")
                }
            }
            if ((index + 1) % dim == 0) inputString += "\n"
        }
        println("input sudoku grid: \n$inputString")
        println("rows: $rows")
        println("columns: $columns")
        println("subGrids: $subGrids")
    }

    return true
}
