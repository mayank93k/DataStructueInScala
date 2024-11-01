package DataStructures
package DS.Queue

/**
 * About: Queue Implementation
 *
 * A Queue is a linear structure which follows a particular order in which the operations are performed.
 * The order is First In First Out (FIFO).
 * Ex: Any queue of consumers for a resource where the consumer that came first is served first.
 * The difference between stacks and queues is in removing.
 * In a stack we remove the item the most recently added where as in a queue, we remove the item the least recently added.
 */
class queueImplementation {
  var n = 5 // Size of Queue
  var queue: Array[Int] = new Array[Int](n) // empty array
  private var front: Int = -1 // No element in Queue
  private var rear: Int = -1 // No element in Queue

  /**
   * Get top most element of the queue
   */
  def peek: Int = {
    val peek = queue(front + 1)
    println("Top element of queue is: " + peek)
    peek
  }

  /**
   * Return size of Queue
   */
  def size: Int = {
    val size = queue.length
    println("Size of queue is: " + size)
    size
  }

  /**
   * This method which pushes the data into Queue through rear end
   *
   * @param data -> Data to be Inserted
   */
  def enqueue(data: Int): Unit = {
    if (isFull) {
      println("Queue overflow")
    } else {
      println("Before enqueue rear is at position: " + rear)
      rear = rear + 1
      queue(rear) = data
      println("Element enqueued into queue is:===> " + data)
      println("After enqueue rear is at position: " + rear)
    }
  }

  /**
   * Check weather Queue is full or not.
   *
   * @return true or false
   */
  private def isFull: Boolean = {
    if (rear == n - 1) {
      true
    } else {
      false
    }
  }

  /**
   * This method deletes the data from Quw=eue from front end
   */
  def dequeue(): Unit = {
    if (isEmpty) {
      println("Queue underflow")
    } else {
      println("Before dequeue front is at position: " + front)
      front = front + 1
      val d = queue(front)
      println("Element to dequeue into queue is:===> " + d)
      println("After dequeue front is at position: " + front)
    }
  }

  /**
   * Check weather Queue is empty or not
   *
   * @return true or false
   */
  def isEmpty: Boolean = {
    if (front < -1 || front > rear) {
      true
    } else {
      false
    }
  }
}

object queueImplementation {
  def main(args: Array[String]): Unit = {
    val queue = new queueImplementation

    println("What is the size of the Queue?")
    queue.size
    println("")

    println("Is Empty Check: " + queue.isEmpty)

    println("::::::: Inserting element in Queue :::::::")
    queue.enqueue(5)
    println("")

    println("::::::: Inserting element in Queue :::::::")
    queue.enqueue(10)
    println("")

    println("::::::: Inserting element in Queue :::::::")
    queue.enqueue(15)
    println("")

    println("::::::: Inserting element in Queue :::::::")
    queue.enqueue(20)
    println("")

    println("::::::: Inserting element in Queue :::::::")
    queue.enqueue(25)
    println("")

    println("::::::: Top most element in Queue is? :::::::")
    queue.peek
    println("")

    println("::::::: Removing element from Queue :::::::")
    queue.dequeue()
    println("")

    println("::::::: Top most element in Queue is? :::::::")
    queue.peek
  }
}
