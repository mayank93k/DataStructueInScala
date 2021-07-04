package datastructures.scala.org

/**
  * About:QueueUsingLinkedList
  *
  * The major problem with the queue implemented using an array is, It will work for an only fixed number of data values.
  * That means, the array size must be specified at the beginning itself.
  * Queue using an array is not suitable when we don't know the size of data which we are going to use.
  * A queue data structure can be implemented using a linked list data structure.
  * The Queue implemented using linked list can organize as many data values as we want.
  *
  * In linked list implementation of a queue, the last inserted node is always pointed by 'rear' and the first node is always pointed by 'front'.
  */
class queueUsingLinkedList {
  var head: Node = _ // creating head of linked list and assigning its value as null

  // This class Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var next: Node = _ // creating link which points to the next address of the current node
  }

  /**
    * Push element at the end(rear) of the Queue i.e., element is always inserted at the rear of linked list
    *
    * @param new_data -> Data to be Inserted at Queue
    */
  def pushQueueRear(new_data: Int): Unit = {
    if (head == null) {
      println(new_data)
      head = new Node(new_data)
      return
    }
    var temp = head
    while (temp.next != null) {
      temp = temp.next
    }
    println(new_data)
    val new_node = new Node(new_data)
    temp.next = new_node
  }

  /**
    * Pop element at the front of the Queue i.e., element is always deleted at the front of linked list
    */
  def popQueueFront(): Unit = {
    if (head == null) {
      println("head can't be null")
    }
    val temp = head
    println(temp.data)
    head = temp.next
  }

  /**
    * This method is to print element of linked list.
    */
  def printNode(): Unit = {
    var temp = head
    while (temp != null) {
      print(temp.data + " ")
      temp = temp.next
    }
  }
}

object queueUsingLinkedList {
  def main(args: Array[String]): Unit = {
    val queueLinkedList = new queueUsingLinkedList
    println("::::::: Inserting element in queue :::::::")
    queueLinkedList.pushQueueRear(50)

    println("::::::: Inserting element in queue :::::::")
    queueLinkedList.pushQueueRear(55)

    println("::::::: Inserting element in queue :::::::")
    queueLinkedList.pushQueueRear(17)

    println("::::::: Printing element in queue :::::::")
    queueLinkedList.printNode()

    println("\n" + "::::::: Removing element in queue :::::::")
    queueLinkedList.popQueueFront()

    println("::::::: Inserting element in queue :::::::")
    queueLinkedList.pushQueueRear(77)

    println("::::::: Printing element in queue :::::::")
    queueLinkedList.printNode()
  }
}