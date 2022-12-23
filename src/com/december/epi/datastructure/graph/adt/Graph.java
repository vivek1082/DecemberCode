package com.december.epi.datastructure.graph.adt;

import java.util.*;

/**
 * Graph ADT -- AdjacencyList representation -- Array of List Of Edges
 *
 * To initialize start with direction|noOfVertex|numEdges
 *
 * Degree = Number of edges incident to a particular node
 *
 * In this ADT of Graph, we consider each vertex a unique and given a number 1 to n
 *
 * x & y vertex number starts from 0
 * as it is represented by arrayList
 */
public class Graph {

    List<List<EdgeNode>> adjacencyList;  // array of list of EdgeNode List

    int verticesNum;             // total number of vertices
    int edgeNum;                 // total number of edges
    boolean directed;
    List<Integer> degree;        // degree of vertices for each node

    public Graph(int verticesNum, int edgeNum, boolean directed) {
        this.verticesNum = verticesNum;
        this.edgeNum = edgeNum;
        this.directed = directed;

        initGraph();
    }

    public Graph(int verticesNum, boolean directed) {
        this.verticesNum = verticesNum;
        this.directed = directed;

        initGraph();
    }

    private void initGraph() {
        adjacencyList = new ArrayList<>(verticesNum);    // array of list-- this is array
        degree = new ArrayList<>(verticesNum);   // list of vertices number

        for(int i = 0; i < verticesNum; i++ ) {
            adjacencyList.add(new LinkedList<EdgeNode>());   // declaring list of Egde List
        }

        for(int i=0; i< verticesNum; i++) {
            degree.add(0);              //initialize degree for each vertices in the beginning
        }
    }

    /**
     * Insertion will happen at the beginning of Linked List Always
     * @param x -- represents starting vertex
     * @param y  -- represents end vertex
     */
    public void insertEdge(int x, int y) {

        EdgeNode edge = new EdgeNode(y);  //array marking to subtract 1
        List<EdgeNode> edgeList = this.adjacencyList.get(x);
        if(edgeList.size() > 0)
            edge.setNext(edgeList.get(0));
        edgeList.add(0,edge);
        degree.set(x,degree.get(x)+1);

        // for y-x edge
        if(!directed) {
            edge = new EdgeNode(x);  // for undirected graph add the other part
            edgeList = this.adjacencyList.get(y);
            if(edgeList.size() > 0)
                edge.setNext(edgeList.get(0));
            edgeList.add(0,edge);     //always add at the head of List of Edges

            degree.set(y,degree.get(y)+1);  // set the degree
        }

        this.edgeNum++;

    }

    public void printGraph() {

        System.out.println("Total No of vertices in graph :: "+ verticesNum);
        System.out.println("Total No of edges in graph :: "+ edgeNum);
        System.out.println("####################################");
        for(int i=0; i< verticesNum; i++ ) {
            System.out.println("*****************************************");
            List<EdgeNode> adjacencyEdges = adjacencyList.get(i);
            System.out.println("No of Edge Incident to vertex :: "+ i +" is :: "+ adjacencyEdges.size());
            System.out.println("Degree of vertex " + i + " is :: "+ degree.get(i));
            System.out.println("Printing all Edges incident to vertex no :: " + i);
            for(EdgeNode edge : adjacencyEdges) {
                System.out.println(i + " ==> " + edge.getAdjacencyInfo());
            }
        }
        System.out.println("####################################");
    }

    public List<List<EdgeNode>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<List<EdgeNode>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public int getVerticesNum() {
        return verticesNum;
    }

    public void setVerticesNum(int verticesNum) {
        this.verticesNum = verticesNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(int edgeNum) {
        this.edgeNum = edgeNum;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public List<Integer> getDegree() {
        return degree;
    }

    public void setDegree(List<Integer> degree) {
        this.degree = degree;
    }
}
