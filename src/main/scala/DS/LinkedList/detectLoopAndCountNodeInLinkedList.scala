package DataStructures
package DS.LinkedList

import scala.collection.mutable.HashSet

/**
  * About: Detect loop and Count Node
  *
  * We have to detect the loop in the given linked list. If the loop exists then count the number of Nodes in the loop.
  */
class detectLoopAndCountNodeInLinkedList {
  var head: Node = _ // creating head of linked list and assigning its value as null

  // This class Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var Next: Node = _ // creating link which points to the next address of the current node
  }

  /**
    * This method checks if the linked list has loop or not
    *
    * @param head -> Head node
    * @return -> Returns true if loop exists else false
    */
  def checkLoop(head: Node): Boolean = {
    val s1: HashSet[Node] = new HashSet[Node]
    var temp = head
    while (temp != null) {
      if (s1.contains(temp)) {
        return true
      }
      s1.add(temp)
      temp = temp.Next
    }
    return false
  }

  /**
    * This method checks if loop is present then returns count of nodes in loop
    *
    * @param head -> Head node
    * @return -> This method returns the count of  Nodes if loop exists
    */
  def countLoop(head: Node): Any = {
    var slow = head
    var fast = head
    while (slow != null && fast != null && fast.Next != null) {
      slow = slow.Next
      fast = fast.Next.Next
      if (slow == fast) {
        return countNode(slow)
      }
    }
  }

  /**
    * This method count of nodes in loop
    *
    * @param n -> Head node
    * @return -> This method returns the count of  Nodes
    */
  def countNode(n: Node): Unit = {
    var count = 1
    var temp = n
    while (temp.Next != n) {
      count += 1
      temp = temp.Next
    }
    println("The length of loop in linked list is:" + count)
  }

  /**
    * This method is used to print the list
    *
    * @param head -> Head node
    */
  def printList(head: Node): Unit = {
    var temp = head
    while (temp != null) {
      print(temp.data + " ")
      temp = temp.Next
    }
  }

  /**
    * This method is used to create New Nodes
    *
    * @param key -> Element to be inserted in node
    * @return -> Return Node
    */
  def newNode(key: Int): detectLoopAndCountNodeInLinkedList.this.Node = {
    val temp = new Node(key)
    temp
  }
}

object detectLoopAndCountNodeInLinkedList {
  def main(args: Array[String]): Unit = {
    val detectLoop = new detectLoopAndCountNodeInLinkedList
    val head = detectLoop.newNode(1)
    head.Next = detectLoop.newNode(2)
    head.Next.Next = detectLoop.newNode(3)
    head.Next.Next.Next = detectLoop.newNode(4)
    head.Next.Next.Next.Next = detectLoop.newNode(5)
    head.Next.Next.Next.Next.Next = head.Next

    println("::::::: Check weather linked list contains loop or not: :::::::")
    if (detectLoop.checkLoop(head))
      System.out.println("Loop found")
    else
      System.out.println("No Loop")

    println("::::::: The count of Node in a linked list which contains loop is: :::::::")
    detectLoop.countLoop(head)
  }
}
