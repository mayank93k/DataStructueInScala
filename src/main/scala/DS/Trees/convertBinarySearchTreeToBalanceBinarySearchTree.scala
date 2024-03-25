package DataStructures
package DS.Trees

class convertBinarySearchTreeToBalanceBinarySearchTree {
  var root: Node = _ // creating root of tree and assigning its value as null

  /**
    * This utility method to do inorder traversal of BST
    *
    * @param root -> Data to be Inserted
    */
  def inOrder(root: Node): convertBinarySearchTreeToBalanceBinarySearchTree.this.Node = {
    if (root == null) {
      return null
    }
    inOrder(root.left)
    print(root.data + " ")
    inOrder(root.right)
  }

  /**
    * This utility method to do preOrder traversal of BST
    *
    * @param root -> Data to be Inserted
    */
  def preOrder(root: Node): convertBinarySearchTreeToBalanceBinarySearchTree.this.Node = {
    if (root == null) {
      return null
    }
    print(root.data + " ")
    preOrder(root.left)
    preOrder(root.right)
  }

  /**
    * This method insert a new key in BST
    *
    * @param root -> Root of the tree
    * @param key  -> Data to be inserted
    * @return -> This method return the Node of tree
    */
  def insert(root: Node, key: Int): convertBinarySearchTreeToBalanceBinarySearchTree.this.Node = {
    if (root == null) {
      return new Node(key)
    }
    if (key < root.data) {
      root.left = insert(root.left, key)
    }
    else if (key > root.data) {
      root.right = insert(root.right, key)
    }
    root
  }

  /**
    * This method convert BST(Binary Search Tree) to Balance Binary Search Tree
    *
    * @param nodes -> Array element
    * @param start -> Start index of Array
    * @param end   -> End index of Array
    * @return -> Return BalancedBinarySearchTree
    */
  def convertBSTtoBalancedBST(nodes: Array[Int], start: Int, end: Int): convertBinarySearchTreeToBalanceBinarySearchTree.this.Node = {
    if (start > end) {
      return null
    }
    val mid: Int = (start + end) / 2
    val node: Node = new Node(nodes(mid))
    node.left = convertBSTtoBalancedBST(nodes, start, mid - 1)
    node.right = convertBSTtoBalancedBST(nodes, mid + 1, end)
    node
  }

  // This class Tree Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var left: Node = _ // creating link which points to the left address of the left node
    var right: Node = _ // creating link which points to the right address of the right node
  }
}

object convertBinarySearchTreeToBalanceBinarySearchTree {
  def main(args: Array[String]): Unit = {
    val balanceBST = new convertBinarySearchTreeToBalanceBinarySearchTree
    val keys = Array(2, 3, 4, 5, 6, 8, 12, 15, 18, 22, 71)
    for (key <- keys) {
      balanceBST.root = balanceBST.insert(balanceBST.root, key)
    }
    println("::::::: InOrder traversal of tree :::::::")
    balanceBST.inOrder(balanceBST.root)
    println("\n")

    val a = balanceBST.convertBSTtoBalancedBST(keys, 0, keys.length - 1)

    println("::::::: PreOrder traversal of tree After converting Binary Search Tree to Balance Binary Search Tree:::::::")
    balanceBST.preOrder(a)
    println("\n")

    println("::::::: InOrder traversal of tree After converting Binary Search Tree to Balance Binary Search Tree :::::::")
    balanceBST.inOrder(a)
  }
}
