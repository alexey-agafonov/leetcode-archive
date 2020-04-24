class LRUCache(private val capacity: Int) {

    class LinkedNode {
        var key: Int? = null
        var value: Int? = null
        var next: LinkedNode? = null
        var prev: LinkedNode? = null
    }

    private fun addNode(node: LinkedNode) {
        node.next = head.next
        head.next = node
        node.next?.prev = node
        node.prev = head
    }

    private fun removeNode(node: LinkedNode) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun moveToHead(node: LinkedNode) {
        removeNode(node)
        addNode(node)
    }

    private fun popTail(): LinkedNode? {
        val popped = tail.prev ?: return null
        removeNode(popped)
        return popped
    }

    private var size = 0
    private val cache = mutableMapOf<Int, LinkedNode>()
    private val head = LinkedNode()
    private val tail = LinkedNode()
    init {
        head.next = tail
        tail.prev = head
    }

    operator fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        moveToHead(node)
        return node.value!!
    }

    fun put(key: Int, value: Int) {
        val node = cache[key]
        if (node == null) {
            val newNode = LinkedNode()
            newNode.key = key
            newNode.value = value
            addNode(newNode)
            cache[key] = newNode
            size++
            if (size > capacity) {
                popTail()?.let {
                    cache.remove(it.key)
                    size--
                }
            }
        } else {
            node.value = value
            moveToHead(node)
        }
    }
}

fun main() {
    var cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache[1])        // returns 1
    cache.put(3, 3)          // evicts key 2
    println(cache[2])        // returns -1 (not found)
    cache.put(4, 4)          // evicts key 1
    println(cache[1])        // returns -1 (not found)
    println(cache[3])        // returns 3
    println(cache[4])        // returns 4
}