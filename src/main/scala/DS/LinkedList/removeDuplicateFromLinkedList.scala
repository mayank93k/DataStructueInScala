package DataStructures
package DS.LinkedList

/**
  * About: Remove Duplicate Elements from the linked lists
  */
class removeDuplicateFromLinkedList {
  var head: Node = _ // creating head of linked list and assigning its value as null

  // This class Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var Next: Node = _ // creating link which points to the next address of the current node
  }

  /**
    * This method remove the duplicate element from the linked list
    *
    * @param head -> Head of the Linked list
    */
  def duplicateNode(head: Node): Unit = {
    var temp = head
    var temp1 = head
    while (temp.Next != null) {
      if (temp.data == temp.Next.data) {
        temp1 = temp.Next.Next
        temp.Next = null
        temp.Next = temp1
      }
      temp = temp.Next
    }
  }

  /**
    * Print the element of the linked list
    */
  def printList(head: Node): Unit = {
    var temp = head
    while (temp != null) {
      print(temp.data + " ")
      temp = temp.Next
    }
  }

  /**
    * Insert the data at front of the linked list
    *
    * @param key -> Data to be Inserted
    */
  def newNode(key: Int): removeDuplicateFromLinkedList.this.Node = {
    val temp = new Node(key)
    temp
  }
}

object removeDuplicateFromLinkedList {
  def main(args: Array[String]): Unit = {
    val removeDuplicate = new removeDuplicateFromLinkedList
    val head = removeDuplicate.newNode(1)
    head.Next = removeDuplicate.newNode(1)
    head.Next.Next = removeDuplicate.newNode(3)
    head.Next.Next.Next = removeDuplicate.newNode(4)
    head.Next.Next.Next.Next = removeDuplicate.newNode(4)
    head.Next.Next.Next.Next.Next = removeDuplicate.newNode(6)

    println("::::::: Element in the Linked list is :::::::")
    removeDuplicate.printList(head)
    println("\n")

    println("::::::: After Removing Duplicates, Element in the Linked list is :::::::")
    removeDuplicate.duplicateNode(head)
    removeDuplicate.printList(head)
  }
}
