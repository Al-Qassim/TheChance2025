fun main() {

}



/**
 * Checks if the given string represents a valid IPv4 address.
 *
 * Criteria:
 * * input must have four numerical segments separated by dots
 * * each numerical segment shouldn't have a leading zero, unless it's 0
 * * each numerical segment should be in range 0..255
 *
 * @param ipv4Input A string to be checked.
 * @return `true` if the input is a valid IPv4 address, `false` otherwise.
 *
 * Example:
 * ```
 * ipv4Checker("192.168.0.1")
 * // true
 * ipv4Checker("192.-2.0.1")
 * // false
 * ```
 */

fun ipv4Checker(ipv4Input : String) : Boolean {
    // requirements:
    //      input must have four numerical segments separated by dots
    //      each numerical segment shouldn't have a leading zero, unless it's 0
    //      each numerical segment should be in range 0..255

    // ensure input consist of four numerical segments separated by dots
    val numericalSegments = ipv4Input.split(".")
    if (numericalSegments.size != 4) return false

    numericalSegments.forEach{numericalSegment ->
        // ensure numerical segment is a UByte, i.e. an integer in range 0..255
        try {
            numericalSegment.toUByte()
        } catch (_: Exception) {
            return false
        }
        // ensure numerical segment don't have leading zero while not equaling "0"
        if (numericalSegment[0] == '0' && numericalSegment != "0") return false
    }
    return true
}



