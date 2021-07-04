package datastructures.scala.org

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, Stack}

/**
  * About: Graph Data Structure
  *
  * A Graph is a non-linear data structure consisting of nodes and edges.
  * The nodes are sometimes also referred to as vertices and the edges are lines or arcs that connect any two nodes in the graph.
  * Example:
  * Graphs are used to represent networks. The networks may include paths in a city or telephone network or circuit network.
  * Graphs are also used in social networks like linkedIn, Facebook. For example, in Facebook, each person is represented with a vertex(or node).
  * Each node is a structure and contains information like person id, name, gender, locale etc.
  */
class graphBFSandDFSImplementation {

  // This class Graph creates the Node and its takes the int type of values
  class Graph(var V: Int) {
    var adjListArray: ArrayBuffer[ArrayBuffer[Int]] = new ArrayBuffer[ArrayBuffer[Int]]
    for (i <- 0 until V) {
      adjListArray.insert(i, ArrayBuffer[Int]())
    }
  }

  /**
    * This method to add an edge into the graph
    *
    * @param graph -> Graph Node
    * @param src   -> Source node
    * @param dest  -> Destination Node
    */
  def addEdge(graph: Graph, src: Int, dest: Int): Unit = {
    graph.adjListArray(src).append(dest)
    graph.adjListArray(dest).append(src)
  }

  /**
    * This method prints BFS traversal from a given source s
    *
    * @param s     -> Source Node
    * @param v     -> No of Vertex
    * @param graph -> Graph Node
    */
  def BFS(s: Int, v: Int, graph: Graph): Unit = {
    val visited: Array[Boolean] = new Array[Boolean](v)
    val queue: java.util.Queue[Int] = new java.util.LinkedList[Int]()
    visited(s) = true
    queue.add(s)
    while (queue.size != 0) {
      val s = queue.poll()
      print(s + " ")
      val i: Iterator[Int] = graph.adjListArray(s).toIterator
      while (i.hasNext) {
        val n: Int = i.next()
        if (!visited(n)) {
          visited(n) = true
          queue.add(n)
        }
      }
    }
  }

  /**
    * This method is used by DFS
    *
    * @param i       -> Counter Variable
    * @param visited -> Array contains the visited node
    * @param graph   -> Graph Node
    */
  def DFSUtil(i: Int, visited: Array[Boolean], graph: Graph): Unit = {
    val stack: Stack[Int] = new mutable.Stack[Int]()
    stack.push(i)
    while (stack.nonEmpty) {
      val s = stack.top
      stack.pop()

      if (!visited(s)) {
        print(s + " ")
        visited(s) = true
      }
      val j: Iterator[Int] = graph.adjListArray(i).toIterator
      while (j.hasNext) {
        val n = j.next()
        if (!visited(n)) {
          stack.push(n)
        }
      }
    }
  }

  /**
    * The method to do DFS traversal. It uses recursive DFSUtil()
    *
    * @param v     -> No of Vertex
    * @param graph -> Graph Node
    */
  def DFS(v: Int, graph: Graph): Unit = {
    val visited: Array[Boolean] = new Array[Boolean](v)
    for (i <- 0 until v)
      visited(i) = false
    for (i <- 0 until v)
      if (!visited(i)) {
        DFSUtil(i, visited, graph)
      }
  }

  /**
    * This method is used to print all the nodes of the graph
    *
    * @param graph -> Graph Node
    */
  def printGraph(graph: Graph): Unit = {
    for (v <- 0 until graph.V) {
      println("Adjacency List of Vertex " + v)
      print("head")
      for (p <- graph.adjListArray(v)) {
        print(" -> " + p)
      }
      println("\n")
    }
  }
}

object graphBFSandDFSImplementation {
  def main(args: Array[String]): Unit = {
    val graphImplementation = new graphBFSandDFSImplementation
    val V = 5
    val graph = new graphImplementation.Graph(V)
    graphImplementation.addEdge(graph, 0, 1)
    graphImplementation.addEdge(graph, 0, 4)
    graphImplementation.addEdge(graph, 1, 2)
    graphImplementation.addEdge(graph, 1, 3)
    graphImplementation.addEdge(graph, 1, 4)
    graphImplementation.addEdge(graph, 2, 3)
    graphImplementation.addEdge(graph, 3, 4)
    graphImplementation.printGraph(graph)
    println("\n")

    println("::::::: BFS Implementation of Graph :::::::")
    graphImplementation.BFS(2, V, graph)
    println("\n")

    println("::::::: DFS Implementation of Graph :::::::")
    graphImplementation.DFS(V, graph)
  }
}