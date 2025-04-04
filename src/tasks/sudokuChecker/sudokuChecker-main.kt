package tasks.sudokuChecker

import kotlin.math.sqrt

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

    fun isThereDuplicationOrInvalidValue(): Boolean {
        for ((valueIndex, cellValue) in sudokuValues.withIndex()) {
            if (cellValue == "-") continue
            if (cellValue.toIntOrNull() !in uniqueValues) return true
            if (!storeValueIfPossible(valueIndex, cellValue)) return true
        }
        return false
    }

    private fun storeValueIfPossible(valueIndex : Int, cellValue : String) : Boolean {
        calculateIndices(valueIndex)
        return (
            rows[rowIndex].add(cellValue) &&
            columns[columnIndex].add(cellValue) &&
            subGrids[subGridIndex].add(cellValue)
        )
    }

    private fun calculateIndices(valueIndex : Int){
        rowIndex = valueIndex / sudokuSideLength
        columnIndex = valueIndex % sudokuSideLength
        subGridIndex = subGridSideLength * ( rowIndex / subGridSideLength) +  columnIndex / subGridSideLength
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


