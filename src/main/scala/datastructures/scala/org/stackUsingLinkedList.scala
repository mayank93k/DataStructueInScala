package datastructures.scala.org

/**
  * About: StackUsingLinkedList
  *
  * A stack can be easily implemented through the linked list.
  * In stack Implementation, a stack contains a top pointer. which is “head” of the stack where pushing and popping items
  * happens at the head of the list. first node have null in link field and second node link have first node address in link field
  * and so on.
  *
  * The main advantage of using linked list over an arrays is that it is possible to implements a stack that
  * can shrink or grow as much as needed. In using array will put a restriction to the maximum capacity of the
  * array which can lead to stack overflow. Here each new node will be dynamically allocate. so overflow is not possible.
  */
class stackUsingLinkedList {
  var head: Node = _ // creating head of linked list and assigning its value as null

  // This class Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var next: Node = _ // creating link which points to the next address of the current node
  }

  /**
    * Push element in stack using linked list i.e., element is always inserted from front of the linked list
    *
    * @param new_data -> Data to be inserted
    */
  def pushLinked(new_data: Int): Unit = {
    println(new_data)
    val new_node = new Node(new_data)
    new_node.next = head
    head = new_node
  }

  /**
    * Pop element in stack using linked list i.e., element is always deleted from top so, delete from front of linked list.
    */
  def popLinked(): Unit = {
    if (head == null) {
      println("head can't be empty")
    }
    val temp = head
    println(temp.data)
    head = temp.next
  }

  /**
    * This method is to print element of linked list.
    */
  def printStack(): Unit = {
    var temp = head
    while (temp != null) {
      print(temp.data + " ")
      temp = temp.next
    }
  }
}

object stackUsingLinkedList {
  def main(args: Array[String]): Unit = {
    val stackLinkedList = new stackUsingLinkedList
    println("::::::: Pushing element in stack :::::::")
    stackLinkedList.pushLinked(15)

    println("::::::: Pushing element in stack :::::::")
    stackLinkedList.pushLinked(12)

    println("::::::: Pushing element in stack :::::::")
    stackLinkedList.pushLinked(18)

    println("::::::: Pushing element in stack :::::::")
    stackLinkedList.pushLinked(5)

    println("::::::: Printing element in stack :::::::")
    stackLinkedList.printStack()

    println("\n" +"::::::: Removing element from stack :::::::")
    stackLinkedList.popLinked()

    println("::::::: Pushing element in stack :::::::")
    stackLinkedList.pushLinked(28)

    println("::::::: Printing element in stack :::::::")
    stackLinkedList.printStack()
  }
}

