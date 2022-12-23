package com.december.epi.datastructure.graph.adt;


public class EdgeNode {

    private int weight;
    private int adjacencyInfo;  // corresponds to y in x-y
    EdgeNode next;     // always insert at first

    public EdgeNode(int weight, int adjacencyInfo, EdgeNode next) {
        this.weight = weight;
        this.adjacencyInfo = adjacencyInfo;
        this.next = next;
    }

    public EdgeNode(int weight, int adjacencyInfo) {
        this.weight = weight;
        this.adjacencyInfo = adjacencyInfo;
    }

    public EdgeNode(int adjacencyInfo) {
        this.adjacencyInfo = adjacencyInfo;
        this.weight =0;
        this.next = null;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAdjacencyInfo() {
        return adjacencyInfo;
    }

    public void setAdjacencyInfo(int adjacencyInfo) {
        this.adjacencyInfo = adjacencyInfo;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "EdgeNode{" +
                "weight=" + weight +
                ", adjacencyInfo=" + adjacencyInfo +
                ", next=" + next +
                '}';
    }
}
