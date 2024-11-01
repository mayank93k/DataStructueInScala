package DataStructures
package DS.Stack

import scala.collection.mutable

/**
 * About: StackUsingTwoQueue
 *
 * A stack can be implemented using two queues.
 * Let stack to be implemented be ‘s’ and queues used to implement be ‘q1’ and ‘q2’.
 * Stack ‘s’ can be implemented in below ways:
 * In push operation, the new element is always enqueued to q1.
 * In pop() operation, if q2 is empty then all the elements except the last, are moved to q2.
 * Finally the last element is dequeued from q1 and returned.
 *
 * push(s, x) operation:
 * Enqueue x to q1 (assuming size of q1 is unlimited).
 * pop(s) operation:
 * One by one dequeue everything except the last element from q1 and enqueue to q2.
 * Dequeue the last item of q1, the dequeued item is result, store it.
 * Swap the names of q1 and q2
 * Return the item stored in step 2.
 * filter_none
 */
class stackUsingTwoQueue {
  /* Stack Implementation using 2 queue*/
  var q1: mutable.Queue[Int] = new mutable.Queue[Int]()
  private var q2: mutable.Queue[Int] = new mutable.Queue[Int]()

  /**
   * This method Inserts the data into Queue
   *
   * @param data -> Input data to be inserted into queue
   */
  def enqueue(data: Int): Unit = {
    println(data)
    q1.enqueue(data)
  }

  /**
   * This method removes the element from Q1 and pushes to Q2 and
   * finally removes the last most element from Q1.
   */
  def dequeue(): Unit = {
    while (q1.length > 1) {
      val top = q1.dequeue()
      q2.enqueue(top)
    }
    println(q1.head)
    q1.dequeue()
    val temp = q1
    q1 = q2
    q2 = temp
  }
}

object stackUsingTwoQueue {
  def main(args: Array[String]): Unit = {
    val stackUsingQueue = new stackUsingTwoQueue
    println("::::::: Inserting element in queue :::::::")
    stackUsingQueue.enqueue(5)
    println("::::::: Inserting element in queue :::::::")
    stackUsingQueue.enqueue(10)
    println("::::::: Inserting element in queue :::::::")
    stackUsingQueue.enqueue(15)
    println("::::::: Inserting element in queue :::::::")
    stackUsingQueue.enqueue(20)
    println("::::::: Inserting element in queue :::::::")
    stackUsingQueue.enqueue(25)

    println("::::::: Elements in Stack :::::::")
    println(stackUsingQueue.q1.mkString(","))

    println("::::::: Removing element from queue :::::::")
    stackUsingQueue.dequeue()

    println("::::::: Elements in Stack :::::::")
    println(stackUsingQueue.q1.mkString(","))

    println("::::::: Inserting element in queue :::::::")
    stackUsingQueue.enqueue(30)

    println("::::::: Elements in Stack :::::::")
    println(stackUsingQueue.q1.mkString(","))
  }
}
