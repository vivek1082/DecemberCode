package com.december.epi.datastructure.graph;

import com.december.epi.datastructure.graph.adt.*;
import com.december.epi.datastructure.graph.traversal.bfs.*;
import com.december.epi.datastructure.graph.utility.*;

import java.io.*;

public class GraphMain {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("********Initializing Graph*****************");
        Graph graph = ReadGraphFromFile.readGraph("Input1");

        if(graph == null) {
            System.out.println("Invalid Graph File or Non Existent file");
        } else {
            graph.printGraph();
        }

        System.out.println("********Initializing Graph End*****************");
        System.out.println("************Traversing via BFS************");
        BFS bfsTraversal = new BFS(1,graph);
        bfsTraversal.traverseGraph();
        System.out.println("************Traversing via BFS End************");

    }
}
