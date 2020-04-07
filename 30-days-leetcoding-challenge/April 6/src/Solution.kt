class Solution {
    fun groupAnagrams(words: Array<String>): List<List<String>> {
        if (words.isEmpty()) return ArrayList()

        val group: HashMap<String, MutableList<String>> = hashMapOf()

        for (word in words) {
            val tmp = word.toCharArray().sorted().toString()
            group.putIfAbsent(tmp, mutableListOf())
            val list = group[tmp]
            list?.add(word)
        }

        return group.values.toList()
    }
}

class AnotherSolution {
    fun groupAnagrams(words: Array<String>): List<List<String>> {
        return words.groupBy { it.toCharArray().sorted() }.values.toList()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))

    val anotherSolution = AnotherSolution()
    anotherSolution.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
}