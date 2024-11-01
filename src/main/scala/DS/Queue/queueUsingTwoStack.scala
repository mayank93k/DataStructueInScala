package DataStructures
package DS.Queue

import scala.collection.mutable.ListBuffer

/**
 * About: QueueUsingTwoStack
 *
 * A queue can be implemented using two stacks.
 * Let queue to be implemented be q and stacks used to implement q be stack1 and stack2.
 * queue can be implemented in below ways:
 *
 * In this method, in en-queue operation, the new element is entered at the top of stack1.
 * In de-queue operation, if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.
 *
 * enQueue(q,  x)
 * 1) Push x to stack1 (assuming size of stacks is unlimited).
 * Here time complexity will be O(1)
 * deQueue(q)
 * 1) If both stacks are empty then error.
 * 2) If stack2 is empty
 * While stack1 is not empty, push everything from stack1 to stack2.
 * 3) Pop the element from stack2 and return it.
 * Here time complexity will be O(n)
 *
 */
class queueUsingTwoStack {
  /* Queue Implementation using 2 stacks using List Buffer */
  var s1: ListBuffer[Int] = ListBuffer[Int]()
  var s2: ListBuffer[Int] = ListBuffer[Int]()


  /**
   * This method Pushes the data into Stack
   *
   * @param data -> Input data to be pushed into stack
   */
  def push(data: Int): Unit = {
    println(data)
    s1.prepend(data)
  }

  /**
   * This method removes the element from S1 and pushes to S2 and
   * finally removes the top most element from S2.
   */
  def pop(): Unit = {
    while (s1.nonEmpty) {
      val top = s1.remove(0)
      s2.prepend(top)
    }
    println(s2.head)
    s2.remove(0)

    for (i <- s2.indices) {
      for (j <- i + 1 until s2.length) {
        val temp1 = s2(j)
        s2(j) = s2(i)
        s2(i) = temp1
      }
    }
    val temp = s1
    s1 = s2
    s2 = temp
  }
}

object queueUsingTwoStack {
  def main(args: Array[String]): Unit = {
    val queueUsingStack = new queueUsingTwoStack
    println("::::::: Pushing element in stack :::::::")
    queueUsingStack.push(5)
    println("::::::: Pushing element in stack :::::::")
    queueUsingStack.push(10)
    println("::::::: Pushing element in stack :::::::")
    queueUsingStack.push(15)
    println("::::::: Pushing element in stack :::::::")
    queueUsingStack.push(20)
    println("::::::: Pushing element in stack :::::::")
    queueUsingStack.push(25)

    println("::::::: Elements in Queue :::::::")
    println(queueUsingStack.s1.mkString(","))

    println("::::::: Removing element from Stack :::::::")
    queueUsingStack.pop()

    println("::::::: Elements in Queue :::::::")
    println(queueUsingStack.s1.mkString(","))

    println("::::::: Pushing element in stack :::::::")
    queueUsingStack.push(30)

    println("::::::: Elements in Queue :::::::")
    println(queueUsingStack.s1.mkString(","))

    println("::::::: Removing element from Stack :::::::")
    queueUsingStack.pop()

    println("::::::: Elements in Queue :::::::")
    println(queueUsingStack.s1.mkString(","))

    println("::::::: Removing element from Stack :::::::")
    queueUsingStack.pop()

    println("::::::: Elements in Queue :::::::")
    println(queueUsingStack.s1.mkString(","))
  }
}
