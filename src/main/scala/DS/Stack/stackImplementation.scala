package DataStructures
package DS.Stack

/**
  * About: Stack Implementation
  *
  * Stack is a linear data structure which follows a particular order in which the operations are performed.
  * The order may be LIFO(Last In First Out) or FILO(First In Last Out).
  * Example of Stack: plates stacked over one another in the canteen.
  * The plate which is at the top is the first one to be removed,
  * i.e. the plate which has been placed at the bottommost position remains in the stack for the longest period of time.
  */
class stackImplementation {
  var top: Int = -1 // No element in the stack(Empty Stack)
  var n: Int = 7 // size of stack is for 5 element(0,1,2,3,4 positions)(top=n-1 means 4=5-1 above this overflows)
  var a: Array[Int] = new Array[Int](n) // empty array

  /**
    * Check stack is empty or not(Initially position of top is at -1 when no elements is there)
    */
  def isEmpty: Boolean = if (top == -1) true else false

  /**
    * Get top most element of the stack
    */
  def peek(): Unit = {
    if (top < -1) {
      println("Stack Underflow")
    }
    else {
      a(top)
      println("Element at top of Queue: " + a(top) + "\n")
    }
  }

  /**
    * This method push the element at the top of the stack.
    *
    * @param x -> Element to be pushed into stack
    */
  def push(x: Int): Unit = {
    if (top > (n - 1)) {
      println("Stack Overflow")
    }
    else {
      println("Before push top is at position: " + top)
      top = top + 1
      println("After increment top by 1, top is at: " + top)
      a(top) = x
      println("Element pushed into stack is:===> " + x)
      println("After push top is at position: " + top + "\n")
    }
  }

  /**
    * This method pop(removes) the element from top of the stack.
    */
  def pop(): Unit = {
    if (top < -1) {
      println("Stack underflow")
    }
    else {
      println("Before pop top is at position: " + top)
      a(top)
      println("Element pop from stack is:===> " + a(top))
      top = top - 1
      println("After pop top is at position: " + top + "\n")
    }
  }
}

object stackImplementation {
  def main(args: Array[String]): Unit = {
    val stack = new stackImplementation
    println("Check weather stack is empty or not?")
    stack.isEmpty
    println("")

    println("::::::: Pushing element in stack :::::::")
    stack.push(5)
    println("")

    println("Check weather stack is empty or not?")
    stack.isEmpty
    println("")

    println("::::::: Pushing element in stack :::::::")
    stack.push(10)
    println("")

    println("::::::: Pushing element in stack :::::::")
    stack.push(-1)
    println("")

    println("::::::: Pushing element in stack :::::::")
    stack.push(15)
    println("")

    println("::::::: Pushing element in stack :::::::")
    stack.push(20)
    println("")

    println("::::::: Pushing element in stack :::::::")
    stack.push(25)
    println("")

    println("::::::: Top most element in stack :::::::")
    stack.peek()
    println("")

    println("::::::: Remove (top) element in stack :::::::")
    stack.pop()
    println("")

    println("::::::: Top most element in stack :::::::")
    stack.peek()

    println("::::::: Pushing element in stack :::::::")
    stack.push(-7)
    println("")

    println("::::::: Top most element in stack :::::::")
    stack.peek()

    println("::::::: Remove (top) element in stack :::::::")
    stack.pop()
    println("")
  }
}

