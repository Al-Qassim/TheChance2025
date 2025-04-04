package tasks.sudokuChecker

import kotlin.math.sqrt

fun main() {
    val c = mutableSetOf(1,2)
    println(c.add(2))
    println(c)
//    print("valid sudoku: " + sudokuChecker(
//        sudokuPlainText =
//            "1,-,-,9,2,-,-,-,-," +
//            "5,2,4,-,1,-,-,-,-," +
//            "-,-,-,-,-,-,-,7,-," +
//            "-,5,-,-,-,8,1,-,2," +
//            "-,-,-,-,-,-,-,-,-," +
//            "4,-,2,7,-,-,-,9,-," +
//            "-,6,-,-,-,-,-,-,-," +
//            "-,-,-,-,3,-,9,4,5," +
//            "-,-,-,-,7,1,-,-,6",
//        printInputAndInternalArrays = true
//    )
//    )
}

/**
 * Checks if the given string represents a valid Sudoku puzzle. the delimiter must be a comma ","
 *
 * @param sudokuPlainText A string representing a Sudoku grid.
 * @param printInputAndInternalArrays Optional. default is false
 *
 * @return `true` if the sudokuPlainText is a valid Sudoku, `false` otherwise.
 *
 *
 * ```
 * // Example 1:
 * tasks.sudokuChecker.sudokuChecker(
 *     sudokuPlainText =
 *          "-,-,3,-,2,-,6,-,-," +
 *          "9,-,-,3,-,5,-,-,1," +
 *          "-,-,1,8,-,6,4,-,-," +
 *          "-,-,8,1,-,2,9,-,-," +
 *          "7,-,-,-,-,-,-,-,8," +
 *          "-,-,6,7,-,8,2,-,-," +
 *          "-,-,2,6,-,9,5,-,-," +
 *          "8,-,-,2,-,3,-,-,9," +
 *          "-,-,5,-,1,-,3,-,-"
 * ) // true
 *
 * // Example 2:
 * tasks.sudokuChecker.sudokuChecker(
 *     sudokuPlainText =
 *          "2,-,3,-,2,-,6,-,-," + // duplicate 2
 *          "9,-,-,3,-,5,-,-,1," +
 *          "-,-,1,8,-,6,4,-,-," +
 *          "-,-,8,1,-,2,9,-,-," +
 *          "7,-,-,-,-,-,-,-,8," +
 *          "-,-,6,7,-,8,2,-,-," +
 *          "-,-,2,6,-,9,5,-,-," +
 *          "8,-,-,2,-,3,-,-,9," +
 *          "-,-,5,-,1,-,3,-,-"
 * ) // false
 *
 * // Example 3:
 * tasks.sudokuChecker.sudokuChecker(
 *      sudokuPlainText =
 *                 "0,15,0,1,0,2,10,14,12,0,0,0,0,0,0,0," +
 *                 "0,6,3,16,12,0,8,4,14,15,1,0,2,0,0,0," +
 *                 "14,0,9,7,11,3,15,0,0,0,0,0,0,0,0,0," +
 *                 "4,13,2,12,0,0,0,0,6,0,0,0,0,15,0,0," +
 *                 "0,0,0,0,14,1,11,7,3,5,10,0,0,8,0,12," +
 *                 "3,16,0,0,2,4,0,0,0,14,7,13,0,0,5,15," +
 *                 "11,0,5,0,0,0,0,0,0,9,4,0,0,6,0,0," +
 *                 "0,0,0,0,13,0,16,5,15,0,0,12,0,0,0,0," +
 *                 "0,0,0,0,9,0,1,12,0,8,3,10,11,0,15,0," +
 *                 "2,12,0,11,0,0,14,3,5,4,0,0,0,0,9,0," +
 *                 "6,3,0,4,0,0,13,0,0,11,9,1,0,12,16,2," +
 *                 "0,0,10,9,0,0,0,0,0,0,12,0,8,0,6,7," +
 *                 "12,8,0,0,16,0,0,10,0,13,0,0,0,5,0,0," +
 *                 "5,0,0,0,3,0,4,6,0,1,15,0,0,0,0,0," +
 *                 "0,9,1,6,0,14,0,11,0,0,2,0,0,0,10,8," +
 *                 "0,14,0,0,0,13,9,0,4,12,11,8,0,0,2,0",
 *             emptyCell = '0',
 *         ) // true
 */
fun sudokuChecker(
    sudokuPlainText: String,
    printInputAndInternalArrays : Boolean = false,
): Boolean {

    val analyzer = SudokuAnalyzer(sudokuPlainText)

    if (!analyzer.isDimensionsValid()) return false

    if (analyzer.isThereDuplicationOrInvalidValue()) return false

    if (printInputAndInternalArrays) analyzer.printInputAndInternalArrays()

    return true
}

class SudokuAnalyzer(sudokuPlainText: String) {

    private val sudokuValues = sudokuPlainText.split(",")

    private val sudokuSideLength = sqrt(sudokuValues.size.toFloat()).toInt()
    private val subGridSideLength = sqrt(sudokuSideLength.toFloat()).toInt()

    private val uniqueValues = 1..sudokuSideLength

    private val rows = MutableList(sudokuSideLength) { mutableSetOf<String>() }
    private val columns = MutableList(sudokuSideLength) { mutableSetOf<String>() }
    private val subGrids = MutableList(sudokuSideLength) { mutableSetOf<String>() }

    private var rowIndex : Int = 0
    private var columnIndex : Int = 0
    private var subGridIndex : Int = 0

    fun isDimensionsValid() : Boolean {
        return !(
            sudokuSideLength == 0 ||
            subGridSideLength == 0 ||
            sudokuSideLength * sudokuSideLength != sudokuValues.size ||
            subGridSideLength * subGridSideLength != sudokuSideLength
        )
    }

    private fun calculateIndices(valueIndex : Int){
        rowIndex = valueIndex / sudokuSideLength
        columnIndex = valueIndex % sudokuSideLength
        subGridIndex = subGridSideLength * ( rowIndex / subGridSideLength) +  columnIndex / subGridSideLength
    }

    private fun storeValueIfPossible(valueIndex : Int, cellValue : String) : Boolean {
        calculateIndices(valueIndex)
        return (
            rows[rowIndex].add(cellValue) &&
            columns[columnIndex].add(cellValue) &&
            subGrids[subGridIndex].add(cellValue)
        )
    }

    fun isThereDuplicationOrInvalidValue(): Boolean {
        for ((valueIndex, cellValue) in sudokuValues.withIndex()) {
            if (cellValue == "-") continue
            if (cellValue.toIntOrNull() !in uniqueValues) return true
            if (!storeValueIfPossible(valueIndex, cellValue)) return true
        }
        return false
    }

    fun printInputAndInternalArrays() {
        println("test")
        var inputString = ""
        for ((index, value) in sudokuValues.withIndex()){
            inputString += String.format("%3s", value)
            if ((index % sudokuSideLength + 1) % subGridSideLength == 0) inputString += String.format("%3s", "|")
            if ((index / sudokuSideLength + 1) % subGridSideLength == 0 && (index % sudokuSideLength + 1) == sudokuSideLength) {
                inputString += "\n"
                for (i in 1..sudokuSideLength) {
                    inputString += String.format("%3s", "---")
                    if (i % subGridSideLength == 0) inputString += String.format("%3s", "--+")
                }
            }
            if ((index + 1) % sudokuSideLength == 0) inputString += "\n"
        }
        println("input sudoku grid: \n$inputString")
        println("rows: $rows")
        println("columns: $columns")
        println("subGrids: $subGrids")
    }
}


