package com.december.epi.datastructure.graph;

import com.december.epi.datastructure.graph.adt.*;
import com.december.epi.datastructure.graph.utility.*;

import java.io.*;

public class GraphMain {

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = ReadGraphFromFile.readGraph("Input1");

        if(graph == null) {
            System.out.println("Invalid Graph File or Non Existent file");
        } else {
            graph.printGraph();
        }

    }
}
