import kotlin.math.sqrt

fun main(){
    sudokuChecker(
        sudokuPlainText =           // grid 01 from https://github.com/dimitri/sudoku/blob/master/sudoku.txt
            "- - 3 - 2 - 6 - - " +
            "9 - - 3 - 5 - - 1 " +
            "- - 1 8 - 6 4 - - " +
            "- - 8 1 - 2 9 - - " +
            "7 - - - - - - - 8 " +
            "- - 6 7 - 8 2 - - " +
            "- - 2 6 - 9 5 - - " +
            "8 - - 2 - 3 - - 9 " +
            "- - 5 - 1 - 3 - -", // "- - 3 - 2 - 6 - - 9 - - 3 - 5 - - 1 - - 1 8 - 6 4 - - - - 8 1 - 2 9 - - 7 - - - - - - - 8 - - 6 7 - 8 2 - - - - 2 6 - 9 5 - - 8 - - 2 - 3 - - 9 - - 5 - 1 - 3 - -",
        printInputAndInternalArrays = true
    )
}

fun sudokuChecker(
    sudokuPlainText: String,
    printInputAndInternalArrays : Boolean = false,
): Boolean {
    val sudokuValues        = sudokuPlainText.split(" ") // ["-", "-", "3", "-", "2", "-", "6", "-", "-", "9", "-", "-", "3", "-", "5", "-", "-", "1", "-", "-", "1", "8", "-", "6", "4", "-", "-", "-", "-", "8", "1", "-", "2", "9", "-", "-", "7", "-", "-", "-", "-", "-", "-", "-", "8", "-", "-", "6", "7", "-", "8", "2", "-", "-", "-", "-", "2", "6", "-", "9", "5", "-", "-", "8", "-", "-", "2", "-", "3", "-", "-", "9", "-", "-", "5", "-", "1", "-", "3", "-", "-"]

    val sudokuSideLength    = sqrt(sudokuValues.size.toFloat()).toInt()
    val subGridSideLength   = sqrt(sudokuSideLength.toFloat()).toInt()

    val uniqueValues        = 1..sudokuSideLength

    val rows                = List(sudokuSideLength) { mutableSetOf<String>() }
    val columns             = List(sudokuSideLength) { mutableSetOf<String>() }
    val subGrids            = List(sudokuSideLength) { mutableSetOf<String>() }

    var rowIndex            = 0
    var columnIndex         = 0
    var subGridIndex        = 0

    fun isDimensionsValid() : Boolean {
        return (
            sudokuSideLength > 0 &&
            subGridSideLength > 0 &&
            sudokuSideLength * sudokuSideLength == sudokuValues.size &&
            subGridSideLength * subGridSideLength == sudokuSideLength
        )
    }

    fun calculateIndices(valueIndex : Int) {
        rowIndex = valueIndex / sudokuSideLength
        columnIndex = valueIndex % sudokuSideLength
        subGridIndex = subGridSideLength * ( rowIndex / subGridSideLength) +  columnIndex / subGridSideLength
    }

    fun storeValueIfPossible(valueIndex : Int, cellValue : String) : Boolean {
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

    if (!isDimensionsValid()) return false

    if (isThereDuplicationOrInvalidValue()) return false

    if (printInputAndInternalArrays) printInputAndInternalArrays()

    return true
}

