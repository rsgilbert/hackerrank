package hackerrank.datastructures.stack

import java.util.*

data class Node(val deque: ArrayDeque<Int>) {
    var prev: Node? = null
    var next: Node? = null
}

class DequeList {
    var head: Node? = null
    var tail: Node? = null

    fun add(deque: ArrayDeque<Int>) {
        val node = Node(deque)
        if (head == null) {
            head = node
        } else {
            tail?.next = node
            node.prev = tail
        }
        tail = node
    }

    fun isEmpty() = head == null || tail == null

    override fun toString(): String {
        return "Head: ${head?.deque} Tail: ${tail?.deque}"
    }
}

fun createDequeList(array: Array<Int>): DequeList {
    val list = DequeList()
    array.forEach { item: Int ->
        if (list.isEmpty()) {
            val deque = ArrayDeque<Int>()
            deque.add(item)
            list.add(deque)
        } else {
            list.tail?.let {
                val deque = it.deque
                if (deque.peekLast() >= item) {
                    deque.addLast(item)
                } else {
                    val newDeque = ArrayDeque<Int>()
                    newDeque.addLast(item)
                    list.add(newDeque)
                }
            }
        }
    }
    return list
}

fun poisonousPlants(poisonousArray: Array<Int>): Int {
    var days = 0
    val list = createDequeList(poisonousArray)
    val head: Node = list.head ?: return 0
    while (head.next != null) {
        var node = head.next
        while (node != null) {
            val prevNode = node.prev
            val nextNode = node.next
            val prevDeq = prevNode!!.deque
            val deq = node.deque
            if(deq.isNotEmpty()) {
                deq.removeFirst()
            }

            if (deq.isEmpty() || deq.peekFirst() <= prevDeq.peekLast()) {
                prevDeq.addAll(deq)
                prevNode.next = nextNode
                nextNode?.prev = prevNode
            }
            node = nextNode
        }
        days++
    }
    return days
}


fun main() {
    val poisonousArray = arrayOf(6, 5, 8,  4, 7, 10, 9)
    println(poisonousPlants(poisonousArray))
    println(poisonousPlants(arrayOf(4, 5, 3, 2, 1, 6)))
    println(poisonousPlants(arrayOf(2, 3, 2, 2)))
}