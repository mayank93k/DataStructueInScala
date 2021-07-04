package datastructures.scala.org

import java.util.{LinkedList, Queue}

import scala.collection.mutable.Stack
import scala.util.control.Breaks

/**
  * About: Various Tree Traversal Ways
  *
  * A binary tree can be traversed in various ways as below:
  * 1) Spiral Traversal
  * 2) Level By Level Traversal
  * 3) Level Order Traversal
  * 4) Level Order Traversal Left View
  */
class treeTraversal {
  var root: Node = _ // creating root of tree and assigning its value as null

  // This class Tree Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var left: Node = _ // creating link which points to the left address of the left node
    var right: Node = _ // creating link which points to the right address of the right node
  }

  /**
    * This method insert a new key in Binary Tree
    *
    * @param root -> Root of the Tree
    * @param key  -> Data to be Inserted
    * @return ->  This method return the Node of tree
    */
  def insert(root: Node, key: Int): treeTraversal.this.Node = {
    val loop1 = new Breaks
    if (root == null) {
      return new Node(key)
    } else {
      var temp: Node = root
      val queue: Queue[Node] = new LinkedList[Node]()
      queue.add(temp)
      loop1.breakable {
        while (!queue.isEmpty) {
          temp = queue.poll()
          if (temp.left == null) {
            temp.left = new Node(key)
            loop1.break()
          } else
            queue.add(temp.left)
          if (temp.right == null) {
            temp.right = new Node(key)
            loop1.break()
          } else
            queue.add(temp.right)
        }
      }
    }
    root
  }

  /**
    * This method implements Level order traversal in spiral form
    *
    * @param root -> Root of the Tree
    * @return -> returns the data in spiral form
    */
  def spiralTraversal(root: Node): treeTraversal.this.Node = {
    val node: Node = root
    val s1: Stack[Node] = new Stack[Node]()
    val s2: Stack[Node] = new Stack[Node]()
    s1.push(node)
    while (s1.nonEmpty || s2.nonEmpty) {
      while (s1.nonEmpty) {
        val temp: Node = s1.top
        s1.pop()
        print(temp.data + " ")

        if (temp.right != null) {
          s2.push(temp.right)
        }
        if (temp.left != null) {
          s2.push(temp.left)
        }
      }
      while (s2.nonEmpty) {
        val temp: Node = s2.top
        s2.pop()
        print(temp.data + " ")
        if (temp.left != null) {
          s1.push(temp.left)
        }
        if (temp.right != null) {
          s1.push(temp.right)
        }
      }
    }
    node
  }

  /**
    * This method implements Level order traversal line by line
    *
    * @param root -> Root of the Tree
    * @return -> return the data level by level
    */
  def levelByLevel(root: Node): treeTraversal.this.Node = {
    val node: Node = root
    if (node == null) {
      return null
    }
    val q1: Queue[Node] = new LinkedList[Node]()
    q1.add(root)
    q1.add(null)
    while (!q1.isEmpty) {
      val temp: Node = q1.poll()
      if (temp == null) {
        if (!q1.isEmpty) {
          q1.add(null)
          println("")
        }
      } else {
        if (temp.left != null) {
          q1.add(temp.left)
        }
        if (temp.right != null) {
          q1.add(temp.right)
        }
        print(temp.data + " ")
      }
    }
    node
  }

  /**
    * This method implements Level Order Tree Traversal
    *
    * @param root -> Root of the Tree
    * @return -> return the data in level order
    */
  def levelOrderTraversal(root: Node): treeTraversal.this.Node = {
    val node: Node = root
    if (node == null) {
      return null
    }
    val q1: Queue[Node] = new LinkedList[Node]()
    q1.add(node)
    while (!q1.isEmpty) {
      val temp: Node = q1.poll()
      print(temp.data + " ")

      if (temp.left != null) {
        q1.add(temp.left)
      }
      if (temp.right != null) {
        q1.add(temp.right)
      }
    }
    node
  }

  /**
    * This method implements Level Order Tree Traversal Left View
    *
    * @param root -> Root of the Tree
    * @return -> return the data in which can be viewed from left side
    */
  def levelOrderTraversalLeftView(root: Node): treeTraversal.this.Node = {
    val node: Node = root
    if (node == null) {
      return null
    }
    val q1: Queue[Node] = new LinkedList[Node]()
    q1.add(node)
    while (!q1.isEmpty) {
      val temp: Node = q1.poll()
      print(temp.data + " ")

      if (temp.left != null && temp.right != null) {
        q1.add(temp.left)
      }
      if (temp.left == null && temp.right != null) {
        q1.add(temp.right)
      }
      if (temp.left != null && temp.right == null) {
        q1.add(temp.left)
      }
    }
    node
  }
}
  object treeTraversal {
  def main(args: Array[String]): Unit = {
    val treeTraversal =new treeTraversal
    val keys = Array(1, 2, 3, 7, 6, 5, 4)
    for (key <- keys) {
      treeTraversal.root = treeTraversal.insert(treeTraversal.root, key)
    }
    println("::::::: Spiral Traversal of Binary tree :::::::")
    treeTraversal.spiralTraversal(treeTraversal.root)
    println("\n")

    println("::::::: Level By Level Traversal of Binary tree :::::::")
    treeTraversal.levelByLevel(treeTraversal.root)
    println("\n")

    println("::::::: Level Order Traversal of Binary tree :::::::")
    treeTraversal.levelOrderTraversal(treeTraversal.root)
    println("\n")

    println("::::::: Level Order Traversal Left View of Binary tree :::::::")
    treeTraversal.levelOrderTraversalLeftView(treeTraversal.root)
    println("\n")

    treeTraversal.insert(treeTraversal.root.left.left, 65)
    println("\n")

    println("::::::: Level By Level Traversal of Binary tree :::::::")
    treeTraversal.levelByLevel(treeTraversal.root)
    println("\n")

    println("::::::: Level Order Traversal of Binary tree :::::::")
    treeTraversal.levelOrderTraversal(treeTraversal.root)
    println("\n")

    println("::::::: Level Order Traversal Left View of Binary tree :::::::")
    treeTraversal.levelOrderTraversalLeftView(treeTraversal.root)
  }
}
