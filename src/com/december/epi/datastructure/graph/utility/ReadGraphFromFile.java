package com.december.epi.datastructure.graph.utility;

import com.december.epi.datastructure.graph.adt.*;

import java.io.*;
import java.util.*;

public class ReadGraphFromFile {

    public static final String FILE_PATH = "/Users/vivekumar/Documents/DecemberCode/src/test/graph/GraphSample";


     public static Graph readGraph(String fileName) throws FileNotFoundException {
         File graphFIle = new File(FILE_PATH+fileName+".txt");
         Graph graph = null;
         if(graphFIle.exists()) {
             Scanner graphTokens = new Scanner(graphFIle);
             while( graphTokens.hasNext() ) {
                 String graphLine = graphTokens.nextLine();
                 graphLine.trim();
                 if(graphLine.length()==0 || graphLine.startsWith("#")) {
                     continue;
                 }

                 String[] tokens = graphLine.split(" ");
                 if( tokens.length == 0 )
                     continue;

                 if(graph == null && !(tokens[0].equals("true")  || tokens[0].equals("false"))) {
                     break;
                 } else if(graph == null){
                     //allwoing some space for errors
                     graph = new Graph(Integer.parseInt(tokens[1]),Boolean.parseBoolean(tokens[0]));
                 } else {
                     if(tokens.length == 2) {
                        int x = Integer.parseInt(tokens[0]);
                        int y = Integer.parseInt(tokens[1]);
                        if(x < 0 || x > graph.getVerticesNum() -1 || y < 0 || y > graph.getVerticesNum() -1) {
                            System.out.println("Invalid Edge "+ x +"=>" +y);
                            continue;
                        } else {
                            graph.insertEdge(x,y);
                        }
                     }

                 }
             }
             graphTokens.close();
         }
         return graph;
     }
}
