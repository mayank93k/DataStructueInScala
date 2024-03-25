package DataStructures
package DS.LinkedList

/**
  * About: Doubly Linked List
  *
  * A Doubly Linked List (DLL) contains an extra pointer, typically called previous pointer, together with next pointer and
  * data which are there in singly linked list. A DLL can be traversed in both forward and backward direction.
  */
class doublyLinkedList {
  var head: Node = _ // creating head of linked list and assigning its value as null

  /**
    * This method inserts the element at the front of linked list
    *
    * @param newData -> Data to be Inserted
    */
  def insertFront(newData: Int): Node = {
    if (head == null) {
      println(newData)
      head = new Node(newData)
    }
    println(newData)
    val newNode = new Node(newData)
    newNode.next = head
    head.prev = newNode
    newNode.prev = null
    head = newNode
    head
  }

  /**
    * This method inserts the element at last of linked list
    *
    * @param newData -> Data to be Inserted
    */
  def insertLast(newData: Int): Unit = {
    if (head == null) {
      println(newData)
      head = new Node(newData)
    }
    var temp: Node = head
    while (temp.next != null) {
      temp = temp.next
    }
    println(newData)
    val newNode = new Node(newData)
    newNode.next = null
    newNode.prev = temp
    temp.next = newNode
  }

  /**
    * This method insert element after a given Node
    *
    * @param prevNode -> Previous node Data
    * @param newData  -> Data to be Inserted
    */
  def insertAfterGivenNode(prevNode: Node, newData: Int): Unit = {
    if (prevNode == null) {
      println("The given previous node cannot be null")
    }
    println(newData)
    val newNode = new Node(newData)
    newNode.next = prevNode.next
    prevNode.next = newNode
    newNode.prev = prevNode
    if (newNode.next != null)
      newNode.next.prev = newNode
  }

  /**
    * This method reverse the doubly linked list
    */
  def reverseDoublyLinkedList(): Unit = {
    var temp: Node = null
    var curr = head
    while (curr != null) {
      temp = curr.prev
      curr.prev = curr.next
      curr.next = temp
      curr = curr.prev
    }
    if (temp != null) {
      head = temp.prev
    }
  }

  /**
    * This method deletes the front element of the linked list
    */
  def deleteFront(): Unit = {
    if (head == null) {
      println("Can't delete, Already empty")
    }
    print(head.data)
    head = head.next
    head.prev = null
  }

  /**
    * This method deletes the last element of the linked list
    */
  def deleteLast(): Unit = {
    if (head == null) {
      println("Head is empty, Can't proceed to delete")
    }
    var temp = head
    while (temp.next.next != null) {
      temp = temp.next
    }
    print(temp.data)
    temp.next = null
  }

  /**
    * This method deletes the element after the key element
    *
    * @param key -> Key Element
    */
  def deleteAfter(key: Int): Unit = {
    if (head == null) {
      println("Head is empty, Can't proceed to delete")
    }
    var pre: Node = null
    var temp = head
    while (temp != null && temp.data != key) {
      temp = temp.next
      pre = temp
    }
    print(temp.data)
    temp = temp.next
    pre.next = temp.next
    temp.next.prev = pre
  }

  /**
    * This method search for key element in the linked list
    *
    * @param key -> Key element to be searched.
    */
  def search(key: Int): Unit = {
    if (head == null) {
      println("Head can't be null")
    }
    var temp = head
    while (temp != null) {
      if (temp.data == key) {
        println("The key element " + key + " is present")
      }
      temp = temp.next
    }
  }

  /**
    * This method print the doubly linked list in reverse order
    */
  def printDoublyLinkedListInReverse(): Unit = {
    var tail: Node = head
    while (tail.next != null) {
      tail = tail.next
    }
    while (tail != head) {
      print(tail.data + " ")
      tail = tail.prev
    }
    print(tail.data + " ")
  }

  /**
    * This method print the doubly linked list
    */
  def printDoublyLinkedList(): Unit = {
    var temp: Node = head

    while (temp != null) {
      print(temp.data + " ")
      temp = temp.next
    }
  }

  // This class Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var next: Node = _ // creating link which points to the next address of the current node
    var prev: Node = _ // creating link which points to the prev address of the current node
  }
}

object doublyLinkedList {
  def main(args: Array[String]): Unit = {
    val doublyLinkedList = new doublyLinkedList
    println("::::::: Pushing element at front in the linked list :::::::")
    doublyLinkedList.insertFront(5)
    println("::::::: Pushing element at front in the linked list :::::::")
    doublyLinkedList.insertFront(15)
    println("::::::: Pushing element at front in the linked list :::::::")
    doublyLinkedList.insertFront(25)
    println("::::::: Pushing element at front in the linked list :::::::")
    doublyLinkedList.insertFront(10)
    println("::::::: Pushing element at front in the linked list :::::::")
    doublyLinkedList.insertFront(7)
    println("::::::: Pushing element at front in the linked list :::::::")
    doublyLinkedList.insertFront(21)
    println("::::::: Pushing element at front in the linked list :::::::")
    doublyLinkedList.insertLast(77)
    println("::::::: Pushing element at front in the linked list :::::::")
    doublyLinkedList.insertFront(1)
    println("::::::: Pushing element at front in the linked list :::::::")
    doublyLinkedList.insertFront(11)
    println("::::::: Pushing element at After a given node in the linked list :::::::")
    doublyLinkedList.insertAfterGivenNode(doublyLinkedList.head.next, 100)
    println("::::::: Printing element linked list :::::::")
    doublyLinkedList.printDoublyLinkedList()
    println("\n")
    println("::::::: Delete element from front of linked list :::::::")
    doublyLinkedList.deleteFront()
    println("\n")
    println("::::::: Printing element linked list :::::::")
    doublyLinkedList.printDoublyLinkedList()
    println("\n")
    println("::::::: Deleting last element of linked list :::::::")
    doublyLinkedList.deleteLast()
    println("\n")
    println("::::::: Printing element linked list :::::::")
    doublyLinkedList.printDoublyLinkedList()
    println("\n")
    println("::::::: Deleting element after the key in linked list :::::::")
    doublyLinkedList.deleteAfter(7)
    println("\n")
    println("::::::: Printing element linked list :::::::")
    doublyLinkedList.printDoublyLinkedList()
    println("\n")
    println("::::::: Reversing linked list :::::::")
    doublyLinkedList.reverseDoublyLinkedList()
    doublyLinkedList.printDoublyLinkedList()
    println("\n")
    println("::::::: Printing an element linked list in reverse order :::::::")
    doublyLinkedList.printDoublyLinkedListInReverse()
    println("\n")
    println("::::::: Searching an element linked list :::::::")
    doublyLinkedList.search(25)
  }
}
