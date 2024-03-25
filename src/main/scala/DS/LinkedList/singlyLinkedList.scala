package DataStructures
package DS.LinkedList

/**
  * About: Singly Linked List
  *
  * Linked List is a linear data structure. A linked list is represented by a pointer to the first node of the linked list.
  * The first node is called the head. If the linked list is empty, then the value of the head is NULL.
  * Each node in a list consists of at least two parts:
  * 1) data
  * 2) Pointer (Or Reference) to the next node
  */
class singlyLinkedList {
  var head: Node = _ // creating head of linked list and assigning its value as null

  /**
    * Insert the data at front of the linked list
    *
    * @param new_data -> Data to be Inserted
    */
  def pushFront(new_data: Int): Node = {
    if (head == null) {
      println(new_data)
      head = new Node(new_data)
    }
    println(new_data)
    val new_Node = new Node(new_data)
    new_Node.Next = head
    head = new_Node
    head
  }

  /**
    * Insert the data in between the nodes
    *
    * @param prev_node -> previous Node
    * @param new_data  -> Data to be inserted
    */
  def pushAfter(prev_node: Node, new_data: Int): Unit = {
    if (head == null) {
      println(new_data)
      head = new Node(new_data)
      return
    }
    if (prev_node == null) {
      println("The given previous node cannot be null")
    }
    println(new_data)
    val new_Node = new Node(new_data)
    new_Node.Next = prev_node.Next
    prev_node.Next = new_Node
  }

  /**
    * Insert the data at the end of the linked list
    *
    * @param new_data -> Data to be Inserted
    */
  def pushLast(new_data: Int): Unit = {
    if (head == null) {
      println(new_data)
      head = new Node(new_data)
      return
    }
    println(new_data)
    val new_Node = new Node(new_data)
    var last = head
    while (last.Next != null) {
      last = last.Next
    }
    last.Next = new_Node
    new_Node.Next = null
  }

  /**
    * Print the element of the linked list
    */
  def printList(): Unit = {
    var temp = head
    while (temp != null) {
      print(temp.data + " ")
      temp = temp.Next
    }
  }

  /**
    * Delete the entire linked list
    * This method will drop the entire entry of linked list
    */
  def deleteLinkedList(): Unit = {
    head = null
  }

  /**
    * Delete node at the front of the linked list, i.e., First node of the linked list
    */
  def deleteFront(): Unit = {
    if (head == null) {
      println("Head can't be null")
    }
    val temp = head
    println(temp.data)
    head = temp.Next
  }

  /**
    * Delete node at the End of the linked list, i.e., Last node of the linked list
    */
  def deleteLast(): Unit = {
    if (head == null) {
      println("head can't be null")
    }
    if (head.Next == null) {
      println(head.data)
      head = null
    }
    var temp = head
    while (temp.Next.Next != null) {
      temp = temp.Next
    }
    println(temp.Next.data)
    temp.Next = null
  }

  /**
    * Delete the given element of the linked list, i.e., key node of the linked list
    *
    * @param key -> Element to be deleted
    */
  def deleteNode(key: Int): Unit = {
    var temp = head
    var prev: Node = null
    if (temp != null && temp.data == key) {
      head = temp.Next
    }
    while (temp != null && temp.data != key) {
      prev = temp
      temp = temp.Next
    }
    println(temp.data)
    prev.Next = temp.Next
  }

  /**
    * Delete node at the given key position of the linked list.
    *
    * @param position -> Element at this position to be deleted
    */
  def keyPosition(position: Int): Unit = {
    var temp = head
    if (head == null) {
      println("head can't be null")
      return
    }
    if (position == 0) {
      head = temp.Next
    }
    if (temp == null && temp.Next == null) {
      return
    }
    var i = 0
    while (temp != null && i < position - 1) {
      temp = temp.Next
      i += 1
    }
    println(temp.Next.data)
    temp.Next = temp.Next.Next
  }

  /**
    * Find Length/(count no of node) of a Linked List.
    */
  def countNode(): Unit = {
    var count = 0
    var temp = head
    while (temp != null) {
      count = count + 1
      temp = temp.Next
    }
    println(count)
  }

  /**
    * This method search an element in a Linked List
    *
    * @param key -> data element
    */
  def searchElem(key: Int): Unit = {
    var temp = head
    while (temp != null) {
      if (temp.data == key) {
        println("\nThe given key element " + key + " is present in the list")
      }
      temp = temp.Next
    }
  }

  /**
    * Program for n’th node from the end of a Linked List
    *
    * @param key -> position of node from end of linked list(Hint: pos=no of nodes-(key+1))
    */
  def searchElemRev(key: Int): Unit = {
    var count1 = 0
    var temp1 = head
    while (temp1 != null) {
      count1 += 1
      temp1 = temp1.Next
    }
    var temp = head
    var count = 0
    val pos = count1 - (key + 1)
    while (temp != null) {
      if (count == pos) {
        println("The element " + temp.data + " present at given key position " + key)
      }
      count += 1
      temp = temp.Next
    }
  }

  /**
    * This method to get the Nth node in a Linked List
    *
    * @param index -> position of node from start
    */
  def indexNode(index: Int): Unit = {
    var temp = head
    var count = 0
    while (temp != null) {
      if (count == index) {
        println("The data at index " + index + " is " + temp.data)
      }
      count += 1
      temp = temp.Next
    }
  }

  /**
    * Reverse a linked list
    */
  def reverseNode(): Unit = {
    var currNode = head
    var prevNode: Node = null
    var nextNode: Node = null
    while (currNode != null) {
      nextNode = currNode.Next
      currNode.Next = prevNode
      prevNode = currNode
      currNode = nextNode
    }
    head = prevNode
  }

  /**
    * Find the middle element of a given linked list
    */
  def midNode(): Unit = {
    var count1 = 0
    var temp1 = head
    while (temp1 != null) {
      count1 += 1
      temp1 = temp1.Next
    }
    var temp = head
    var count = 0
    val mid = count1 / 2
    while (temp != null) {
      if (count == mid) {
        println("The Mid of the element is " + temp.data)
      }
      count += 1
      temp = temp.Next
    }
  }

  /**
    * Write a function that counts the number of times a given int occurs in a Linked List
    *
    * @param key -> Data which needs to checked for no of times repetition
    */
  def countDuplicateNode(key: Int): Unit = {
    var temp = head
    var count = 0
    while (temp != null) {
      if (temp.data == key) {
        count += 1
      }
      temp = temp.Next
    }
    println("The key element " + key + " which is repeated " + count + " times")
  }

  // This class Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var Next: Node = _ // creating link which points to the next address of the current node
  }
}

object singlyLinkedList {
  def main(args: Array[String]): Unit = {
    val singlyLinkedList = new singlyLinkedList
    println("::::::: Pushing element at front in the linked list :::::::")
    singlyLinkedList.pushFront(5)
    println("\n")

    println("::::::: Pushing element at front in the linked list :::::::")
    singlyLinkedList.pushFront(11)
    println("\n")

    println("::::::: Pushing element at front in the linked list :::::::")
    singlyLinkedList.pushFront(19)
    println("\n")

    println("::::::: Pushing element at front in the linked list :::::::")
    singlyLinkedList.pushFront(21)
    println("\n")

    println("::::::: Pushing element at front in the linked list :::::::")
    singlyLinkedList.pushFront(51)
    println("\n")

    println("::::::: Pushing element After given node in the linked list :::::::")
    singlyLinkedList.pushAfter(singlyLinkedList.head.Next, 15)
    println("\n")

    println("::::::: Pushing element After given node in the linked list :::::::")
    singlyLinkedList.pushAfter(singlyLinkedList.head.Next, 29)
    println("\n")

    println("::::::: Pushing element at front in the linked list :::::::")
    singlyLinkedList.pushFront(77)
    println("\n")

    println("::::::: Pushing element at last in the linked list :::::::")
    singlyLinkedList.pushLast(26)
    println("\n")

    println("::::::: Deleting element at front in the linked list :::::::")
    singlyLinkedList.deleteFront()
    println("\n")

    println("::::::: Deleting Entire linked list :::::::")
    // singlyLinkedList.deleteLinkedList()
    println("\n")

    println("::::::: Pushing element at front in the linked list :::::::")
    singlyLinkedList.pushFront(21)
    println("\n")

    println("::::::: Deleting element at last in the linked list :::::::")
    singlyLinkedList.deleteLast()
    println("\n")

    println("::::::: Deleting element Specified Node in the linked list :::::::")
    singlyLinkedList.deleteNode(15)
    println("\n")

    println("::::::: Deleting element at given key position in the linked list :::::::")
    singlyLinkedList.keyPosition(1)
    println("\n")

    println("::::::: Printing elements in the linked list :::::::")
    singlyLinkedList.printList()
    println("\n")

    println("::::::: Count the number of nodes in the linked list :::::::")
    singlyLinkedList.countNode()
    println("\n")

    println("::::::: Search given element  :::::::")
    singlyLinkedList.searchElem(15)
    println("\n")

    println("::::::: Search given element from last :::::::")
    singlyLinkedList.searchElemRev(4)
    println("\n")

    println("::::::: Element present at the given Index :::::::")
    singlyLinkedList.indexNode(3)
    println("\n")

    println("::::::: Mid element in the linked list :::::::")
    singlyLinkedList.midNode()
    println("\n")

    println("::::::: Count duplicate element in the linked list :::::::")
    singlyLinkedList.countDuplicateNode(21)
    println("\n")

    println("::::::: The reverse linked list is: :::::::")
    singlyLinkedList.reverseNode()
    singlyLinkedList.printList()
    println("\n")
  }
}