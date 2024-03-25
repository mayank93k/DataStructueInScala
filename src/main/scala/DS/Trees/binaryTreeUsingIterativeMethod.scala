package DataStructures
package DS.Trees

import scala.util.control.Breaks

/**
  * About: Binary Tree
  *
  * A tree whose elements have at most 2 children is called a binary tree. Since each element in a binary tree can have only 2 children,
  * we typically name them the left and right child.
  * A tree is represented by a pointer to the topmost node in tree. If the tree is empty, then value of root is NULL.
  * A Tree node contains following parts.
  * 1. Data
  * 2. Pointer to left child
  * 3. Pointer to right child
  */
class binaryTreeUsingIterativeMethod {
  var root: Node = _ // creating root of tree and assigning its value as null

  /**
    * This utility method to do inorder traversal of BST
    *
    * @param root -> Data to be Inserted
    */
  def inorder(root: Node): binaryTreeUsingIterativeMethod.this.Node = {
    if (root == null) {
      return null
    }
    inorder(root.left)
    print(root.data + " ")
    inorder(root.right)
  }

  /**
    * This method insert a new key in Binary Tree
    *
    * @param root -> Root of the Tree
    * @param key  -> Data to be Inserted
    * @return ->  This method return the Node of tree
    */
  def insert(root: Node, key: Int): binaryTreeUsingIterativeMethod.this.Node = {
    val loop1 = new Breaks
    if (root == null) {
      return new Node(key)
    } else {
      var temp: Node = root
      val queue: java.util.Queue[Node] = new java.util.LinkedList[Node]()
      queue.add(temp)
      loop1.breakable {
        while (!queue.isEmpty) {
          temp = queue.peek()
          queue.remove()
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
    * This method searches the key element in the Binary Tree
    *
    * @param root -> Root of the tree
    * @param key  -> Data to be searched
    * @return -> Return the searched element
    */
  def search(root: Node, key: Int): Boolean = {
    if (root == null) {
      false
    } else {
      var temp: Node = root
      val queue: java.util.Queue[Node] = new java.util.LinkedList[Node]()
      queue.add(temp)
      while (!queue.isEmpty) {
        temp = queue.peek()
        if (temp.data == key) {
          return true
        }
        queue.remove()
        if (temp.left != null) {
          queue.add(temp.left)
        }
        if (temp.right != null) {
          queue.add(temp.right)
        }
      }
      false
    }
  }

  // This class Tree Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var left: Node = _ // creating link which points to the left address of the left node
    var right: Node = _ // creating link which points to the right address of the right node
  }
}

object binaryTreeUsingIterativeMethod {
  def main(args: Array[String]): Unit = {
    val binaryTree = new binaryTreeUsingIterativeMethod
    val keys = Array(8, 18, 12, 3, 4, 15, 2, 71, 5, 6, 22)
    for (key <- keys) {
      binaryTree.root = binaryTree.insert(binaryTree.root, key)
    }

    println("::::::: Inorder traversal of Binary tree :::::::")
    binaryTree.inorder(binaryTree.root)

    binaryTree.insert(binaryTree.root.left.right.left, 501)
    println("\n")

    println("::::::: Inorder traversal of Binary tree :::::::")
    binaryTree.inorder(binaryTree.root)
    print("\n")

    println("\n::::::: Element 12 is present? :::::::")
    println(binaryTree.search(binaryTree.root, 12))

    println("\n::::::: Element 97 is present? :::::::")
    println(binaryTree.search(binaryTree.root, 97))
  }

}
