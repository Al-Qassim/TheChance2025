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
    printInputAndInternalArrays : Boolean = false // this is only for presentation purposes
): Boolean {
    val sudokuValues        = sudokuPlainText.split(" ")

    val sudokuSideLength    = sqrt(sudokuValues.size.toFloat()).toInt()
    val subGridSideLength   = sqrt(sudokuSideLength.toFloat()).toInt()

    if (
        sudokuSideLength < 4 ||
        subGridSideLength < 2 ||
        sudokuSideLength * sudokuSideLength != sudokuValues.size ||
        subGridSideLength * subGridSideLength != sudokuSideLength
    ) return false

    val uniqueValues        = 1..sudokuSideLength

    val rows                = List(sudokuSideLength) { mutableSetOf<String>() }
    val columns             = List(sudokuSideLength) { mutableSetOf<String>() }
    val subGrids            = List(sudokuSideLength) { mutableSetOf<String>() }

    var rowIndex : Int
    var columnIndex : Int
    var subGridIndex : Int

    for ((valueIndex, cellValue) in sudokuValues.withIndex()) {
        if (cellValue == "-") continue
        if (cellValue.toIntOrNull() !in uniqueValues) return false

        rowIndex = valueIndex / sudokuSideLength
        columnIndex = valueIndex % sudokuSideLength
        subGridIndex = subGridSideLength * ( rowIndex / subGridSideLength) +  columnIndex / subGridSideLength

        if (
            !rows[rowIndex].add(cellValue) ||
            !columns[columnIndex].add(cellValue) ||
            !subGrids[subGridIndex].add(cellValue)
        ) return false
    }

    // this is only for presentation purposes
    if (printInputAndInternalArrays) {
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

    return true
}

