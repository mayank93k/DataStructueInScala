package datastructures.scala.org

import scala.util.control._

/**
  * About: Find intersection point of  two Linked List
  *
  * We have to find the intersection point of two Linked List(Common Node where two linked list meets each other)
  */
class intersectionPointOfTwoLinkedList {
  var head1: Node = _ // creating head1 of linked list1 and assigning its value as null
  var head2: Node = _ // creating head2 of linked list2 and assigning its value as null

  // This class Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var Next: Node = _ // creating link which points to the next address of the current node
  }

  /**
    * This method is used to find the intersectionPoint of Two linked list
    *
    * @param head1 -> Head node
    * @param head2 -> Head node
    */
  def intersect(head1: Node, head2: Node): Unit = {
    var count1 = 0
    var temp1 = head1
    while (temp1 != null) {
      count1 += 1
      temp1 = temp1.Next
    }
    // println("First Count " + count1)

    var count2 = 0
    var temp2 = head2
    while (temp2 != null) {
      count2 += 1
      temp2 = temp2.Next
    }
   // println("Second Count " + count2)
    val NodeDiff = count1 - count2
   // println("Diff of Node " + NodeDiff)

    var temp = head1.Next

    val loop = new Breaks
    loop.breakable {
      var temp3 = head2
      while (temp != null && temp3 != null) {
        if (temp.data == temp3.data) {
          println("Node is " + temp3.data)
          loop.break
        }
        temp = temp.Next
        temp3 = temp3.Next
      }
    }
  }

  /**
    * This method is used to create New Nodes
    *
    * @param key -> Element to be inserted in node
    * @return -> Return Node
    */
  def newNode(key: Int): intersectionPointOfTwoLinkedList.this.Node = {
    val temp = new Node(key)
    temp
  }
}

object intersectionPointOfTwoLinkedList {
  def main(args: Array[String]): Unit = {
    val intersectionPoint = new intersectionPointOfTwoLinkedList
    val head1 = intersectionPoint.newNode(1)
    head1.Next = intersectionPoint.newNode(2)
    head1.Next.Next = intersectionPoint.newNode(3)
    head1.Next.Next.Next = intersectionPoint.newNode(4)
    head1.Next.Next.Next.Next = intersectionPoint.newNode(5)
    head1.Next.Next.Next.Next.Next = intersectionPoint.newNode(6)

    val head2 = intersectionPoint.newNode(7)
    head2.Next = intersectionPoint.newNode(8)
    head2.Next.Next = head1.Next.Next.Next

    println("::::::: Intersection Point of two Linked List is: :::::::")
    intersectionPoint.intersect(head1, head2)

  }
}
