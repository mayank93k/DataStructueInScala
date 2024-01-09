package DataStructures
package DS.Trees

/**
  * About: Binary Search Tree (Implemented using recursive method)
  *
  * Binary Search Tree, is a node-based binary tree data structure which has the following properties:
  * The left subtree of a node contains only nodes with keys lesser than the node’s key.
  * The right subtree of a node contains only nodes with keys greater than the node’s key.
  * The left and right subtree each must also be a binary search tree.
  * There must be no duplicate nodes.
  * The above properties of Binary Search Tree provide an ordering among keys so that the operations like search,
  * minimum and maximum can be done fast. If there is no ordering, then we may have to compare every key to search a given key.
  */
class binarySearchTreeUsingRecursiveMethod {
  var root: Node = _ // creating root of tree and assigning its value as null

  // This class Tree Node creates the Node and its takes the int type of values
  class Node(var data: Int) {
    var left: Node = _ // creating link which points to the left address of the left node
    var right: Node = _ // creating link which points to the right address of the right node
  }

  /**
    * This utility method to do inorder traversal of BST
    *
    * @param root -> Data to be Inserted
    */
  def inOrder(root: Node): binarySearchTreeUsingRecursiveMethod.this.Node = {
    if (root == null)
      return null
    inOrder(root.left)
    print(root.data + " ")
    inOrder(root.right)
  }

  /**
    * This utility method to do preOrder traversal of BST
    *
    * @param root -> Data to be Inserted
    */
  def preOrder(root: Node): binarySearchTreeUsingRecursiveMethod.this.Node = {
    if (root == null)
      return root
    println(root.data + " ")
    preOrder(root.left)
    preOrder(root.right)
  }

  /**
    * This utility method to do postOrder traversal of BST
    *
    * @param root -> Data to be Inserted
    */
  private def postOrder(root: Node): binarySearchTreeUsingRecursiveMethod.this.Node = {
    if (root == null)
      return root
    postOrder(root.left)
    postOrder(root.right)
    println(root.data + " ")
    root
  }

  /**
    * This method insert a new key in BST
    *
    * @param root -> Root of the tree
    * @param key  -> Data to be inserted
    * @return -> This method return the Node of tree
    */
  def insert(root: Node, key: Int): binarySearchTreeUsingRecursiveMethod.this.Node = {
    if (root == null) {
      return new Node(key)
    }
    if (key < root.data) {
      root.left = insert(root.left, key)
    } else {
      root.right = insert(root.right, key)
    }
    root
  }

  /**
    * This method searches the key element in the BST
    *
    * @param root -> Root of the tree
    * @param key  -> Data to be searched
    * @return -> Return the searched element
    */
  def search(root: Node, key: Int): String = {
    if (root == null) {
      return "No"
    }
    if (key < root.data) {
      search(root.left, key)
    } else if (key > root.data)
      search(root.right, key)
    else
      "Yes"
   }

  /**
    * This method fetches the maximum key in the node
    *
    * @param root -> Root of the tree
    * @return -> Return the maximum element
    */
  private def maximumKey(root: Node): binarySearchTreeUsingRecursiveMethod.this.Node = {
    var max: Node = root
    while (max.right != null) {
      max = max.right
    }
    max
  }

  /**
    * This method deletes the node
    *
    * @param root -> Root of the tree
    * @param key  -> Data to be Deleted
    * @return
    */
  def deleteNode(root: Node, key: Int): binarySearchTreeUsingRecursiveMethod.this.Node = {
    if (root == null) {
      return root
    }
    if (key < root.data) {
      root.left = deleteNode(root.left, key)
    }
    else if (key > root.data) {
      root.right = deleteNode(root.right, key)
    } else {
      if (root.left == null && root.right == null) {
        return null
      }
      else if (root.left != null && root.right == null) {
        val predecessor: Node = maximumKey(root.left)
        root.data = predecessor.data
        root.left = deleteNode(root.left, predecessor.data)
      } else {
        val child = if (root.left != null) root.left else root.right
        return child
      }
    }
    root
  }

  /**
    * This method fetches the maximum value in the node
    *
    * @param root -> Root of the tree
    * @return -> Return the maximum element
    */
  def maximumNodeValue(root: Node): Int = {
    var max: Node = root
    while (max.right != null) {
      max = max.right
    }
    max.data
  }

  /**
    * This method fetches the minimum key in the node
    *
    * @param root -> Root of the tree
    * @return -> Return the minimum element
    */
  def minimumNodeValue(root: Node): Int = {
    var min: Node = root
    while (min.left != null) {
      min = min.left
    }
    min.data
  }

  /**
    * This method size(Level) of tree
    *
    * @param root -> Root of the tree
    * @return -> Return the size of tree
    */
  def sizeOfTree(root: Node): Int = {
    if (root == null) {
      0
    }
    else {
      sizeOfTree(root.left) + 1 + sizeOfTree(root.right)
    }
  }

  /**
    * This method count the number of left node in a tree
    *
    * @param root -> Root of the tree
    * @return -> Return the number of right nodes
    */
  def numberOfLeftNode(root: Node): Int = {
    if (root == null) {
      return 0
    }
    if (root.left == null) {
      numberOfLeftNode(root.left)
    } else {
      numberOfLeftNode(root.left) + 1 + numberOfLeftNode(root.right)
    }
  }

  /**
    * This method count the number of right nodes
    *
    * @param root -> Root of the tree
    * @return -> Return the number of right nodes
    */
  def numberOfRightNode(root: Node): Int = {
    if (root == null) {
      return 0
    }
    if (root.right == null) {
      numberOfRightNode(root.right)
    } else {
      numberOfRightNode(root.right) + 1 + numberOfRightNode(root.left)
    }
  }

  /**
    * This method gives the root value
    *
    * @param root -> Root of the tree
    * @return -> Return the root Data
    */
  def rootData(root: Node): Int = {
    if (root == null) {
      0
    } else {
      root.data
    }
  }

  /**
    * This method return the height of Binary Tree
    *
    * @param root -> Root of the tree
    * @return -> Return the height of Binary Tree
    */
  def heightOfBinaryTree(root: Node): Int = {
    var leftHeight = 0
    var rightHeight = 0
    if (root == null) {
      -1
    }
    else {
      leftHeight = heightOfBinaryTree(root.left)
      rightHeight = heightOfBinaryTree(root.right)
      if (leftHeight > rightHeight) {
        leftHeight + 1
      }
      else {
        rightHeight + 1
      }
    }
  }

  /**
    * This method returns the number of leaves in a tree
    *
    * @param root -> Root of the tree
    * @return -> return the number of leaves
    */
  def numberOfLeaves(root: Node): Int = {
    if (root == null) {
      return 0
    }
    if (root.left == null && root.right == null) {
      1
    } else {
      numberOfLeaves(root.left) + numberOfLeaves(root.right)
    }
  }

  /**
    * This method check that tree is Binary Search Tree
    *
    * @param root -> Root of the tree
    * @param min  -> Minimum value of tree
    * @param max  -> Maximum value of tree
    * @return -> Returns true if tree is BST else false
    */
  def checkBST(root: Node, min: Int, max: Int): Boolean = {
    if (root == null) {
      return true
    }
    if (min < root.data && root.data < max) {
      checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max)
    } else {
      false
    }
  }

  /**
    * This method swap left and right node of the tree
    *
    * @param root -> Root of the tree
    * @return -> Returns the tree after swapping left and right node
    */
  def swapNodes(root: Node): binarySearchTreeUsingRecursiveMethod.this.Node = {
    if (root != null) {
      swapNodes(root.left)
      swapNodes(root.right)
      val temp: Node = root.left
      root.left = root.right
      root.right = temp
    }
    root
  }

  /**
    * This method returns the sum of all nodes of the tree
    *
    * @param root -> Root of the tree
    * @return -> Returns the sum of all nodes in a tree
    */
  def addNodeValue(root: Node): Int = {
    if (root == null) {
      0
    }
    else {
      root.data + addNodeValue(root.left) + addNodeValue(root.right)
    }
  }

  /**
    * This method returns the number of full node(Node which is having both left and right node as child)
    *
    * @param root -> Root of the tree
    * @return -> Returns the number of Full Node
    */
  def numberOfFullNodes(root: Node): Int = {
    if (root == null) {
      return 0
    }
    var count = 0
    if (root.left != null && root.right != null) {
      count += 1
      count += (numberOfFullNodes(root.left) + numberOfFullNodes(root.right))
    }
    count
  }
}

object binarySearchTreeUsingRecursiveMethod {
  def main(rags: Array[String]): Unit = {
    val binarySearchTree = new binarySearchTreeUsingRecursiveMethod
    val keys = Array(8, 18, 12, 3, 4, 15, 2, 71, 5, 6, 22)
    for (key <- keys) {
      binarySearchTree.root = binarySearchTree.insert(binarySearchTree.root, key)
    }
    println("::::::: Inorder traversal of tree :::::::")
    binarySearchTree.inOrder(binarySearchTree.root)
    print("\n")

    println("\n::::::: Given Element is Present in the tree? :::::::")
    println("Element 15: " + binarySearchTree.search(binarySearchTree.root, 15))

    println("\n::::::: Given Element is Present in the tree? :::::::")
    println("Element  8: " + binarySearchTree.search(binarySearchTree.root, 8))

    println("\n::::::: Given Element is Present in the tree? :::::::")
    println("Element 55: " + binarySearchTree.search(binarySearchTree.root, 55))

    println("\n::::::: Element to be deleted from the tree :::::::")
    binarySearchTree.deleteNode(binarySearchTree.root, 71)

    println("::::::: Inorder traversal of tree :::::::")
    binarySearchTree.inOrder(binarySearchTree.root)
    print("\n")

    println("\n::::::: Maximum value in a tree? :::::::")
    println("Maximum value in a tree is: " + binarySearchTree.maximumNodeValue(binarySearchTree.root))

    println("\n::::::: Minimum value in a tree? :::::::")
    println("Minimum value in a tree is: " + binarySearchTree.minimumNodeValue(binarySearchTree.root))

    println("\n::::::: Size of a tree? :::::::")
    println("Size of a tree is: " + binarySearchTree.sizeOfTree(binarySearchTree.root))

    println("\n::::::: Number of left Node in a tree? :::::::")
    println("Number of left Node in a tree is: " + binarySearchTree.numberOfLeftNode(binarySearchTree.root))

    println("\n::::::: Number of right Node in a tree? :::::::")
    println("Number of right Node in a tree is: " + binarySearchTree.numberOfRightNode(binarySearchTree.root))

    println("\n::::::: Data at Root Node in a tree? :::::::")
    println("Data at Root Node in a tree is: " + binarySearchTree.rootData(binarySearchTree.root))

    println("\n::::::: Height of a Binary Search tree? :::::::")
    println("Height of a Binary Search tree is: " + binarySearchTree.heightOfBinaryTree(binarySearchTree.root))

    println("\n:::::::Number of Leaves in a Binary Search tree? :::::::")
    println("Number of Leaves in a Binary Search tree is: " + binarySearchTree.numberOfLeaves(binarySearchTree.root))

    println("\n:::::::The number of full nodes in a tree? :::::::")
    println("The number of full nodes in a tree is: " + binarySearchTree.numberOfFullNodes(binarySearchTree.root))

    println("\n:::::::The given tree is Binary Search tree or not? :::::::")
    println(binarySearchTree.checkBST(binarySearchTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE))

    println("\n:::::::The given tree after swapping Nodes :::::::")
    binarySearchTree.swapNodes(binarySearchTree.root)
    binarySearchTree.inOrder(binarySearchTree.root)
    print("\n")

    println("\n:::::::The given tree is Binary Search tree or not After Swap? :::::::")
    println(binarySearchTree.checkBST(binarySearchTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE))

    println("\n:::::::The sum of all the node values is :::::::")
    println(binarySearchTree.addNodeValue(binarySearchTree.root))

  }
}
