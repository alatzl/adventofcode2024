import kotlin.math.absoluteValue

fun main() {
    fun splitLists(input: List<String>): MutableList<MutableList<Int>> {
        val list1: MutableList<Int> = mutableListOf()
        val list2: MutableList<Int> = mutableListOf()

        input.forEach { line ->
            val values = line.split(" ").filter { it.isNotBlank() }.map { it.toInt() }
            list1.add(values[0])
            list2.add(values[1])
        }

        return mutableListOf(list1, list2)
    }

    fun part1(input: List<String>): Int {
        val lists = splitLists(input)

        lists[0].sort()
        lists[1].sort()

        var sum = 0
        for (i in 0 until input.size) {
            val list1val = lists[0][i]
            val list2val = lists[1][i]
            val diff = (list1val - list2val).absoluteValue
            sum += diff
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val lists = splitLists(input)

        var similarity = 0

        lists[0].map { num ->
            similarity += num * lists[1].filter { it == num }.size
        }

        return similarity
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
