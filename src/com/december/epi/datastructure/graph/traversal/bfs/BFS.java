package com.december.epi.datastructure.graph.traversal.bfs;

import com.december.epi.datastructure.graph.adt.*;
import static com.december.epi.datastructure.graph.enums.TraversalDiscoveryEnum.*;

import com.december.epi.datastructure.graph.enums.*;
import  com.december.epi.datastructure.graph.traversal.*;

import java.util.*;
import java.util.concurrent.*;

/**
 * Breadth First search. Always find Shortest Path.
 *
 * To help a)finding shortest path
 *              i) only helpful -- when for x-y , BFS start from x and graph is NOn-weighted
 *      b) connected components
 *          i) Rubix cube solvable or not
 *      c)Vertex Two Coloring
 *          i) Bipartate graph
 *          ii) Mutual Intrested Social Media Connected Gender Partate
 *
 *
 *  Non-tree edges has its own uses -- In vertex coloering if any of non-adge tree color is same ,
 *  it's not bipartate
 *
 *       .
 */
public class BFS implements GraphTraversalI {

    private int startVertex;
    private Graph graph;

    //Traverse related vars
    private List<Integer> parentNode; // parent node corresponding to vertex
    //above could help in tracing shortest path
    private List<TraversalDiscoveryEnum> nodeStatus;  // status of a node, initially all UNDISCOVERED
    private int numEdges = 0;

    private Queue<Integer> traversalQ;



    public BFS(int startVertex, Graph graph) {
        this.startVertex = startVertex;
        this.graph = graph;
        if(graph !=null) {
            initSearchComponent();
        } else {
            System.out.println("Graph is null.");
        }
    }

    @Override
    public void initSearchComponent() {
        int numVertex = graph.getVerticesNum();
        parentNode = new ArrayList<>(numVertex);
        nodeStatus = new ArrayList<>(numVertex);

        if(startVertex < 0 || startVertex > graph.getVerticesNum() -1 )
            throw new IllegalArgumentException("Invalid start Vertex");

        for(int i =0; i < numVertex; i++) {
            parentNode.add(-1);         //initialize all parent at -1
            nodeStatus.add(UNDISCOVERED);  // intiaslize all vertex as undiscovered in the beginning
        }
    }

    @Override
    public void traverseGraph() {
        int start = this.startVertex; // just localizing to remember
        traversalQ = new LinkedBlockingQueue<>();
        nodeStatus.set(start,DISCOVERED);
        traversalQ.add(start);

        while( !traversalQ.isEmpty() ) {
            int vertex = traversalQ.poll();
            processVertexEarly(vertex);
            nodeStatus.set(vertex,PROCESSED);

            List<EdgeNode> edges = graph.getAdjacencyList().get(vertex);

            for(EdgeNode edge : edges) {
                int oppositeNode = edge.getAdjacencyInfo();
                if(nodeStatus.get(oppositeNode) != PROCESSED || graph.isDirected()) {
                    processEdge(vertex,edge.getAdjacencyInfo());
                    if(nodeStatus.get(oppositeNode) == UNDISCOVERED) {
                        parentNode.set(oppositeNode,vertex);
                        nodeStatus.set(oppositeNode,DISCOVERED);
                        traversalQ.add(oppositeNode);
                    }
                }

            }

            processVertexLate(vertex);
        }

    }

    @Override
    public void processVertexEarly(int x) {
        System.out.println("Processing vertex :: " + x);
    }

    @Override
    public void processVertexLate(int x) {
        //do nothing
    }

    @Override
    public void processEdge(int x, int y) {
        System.out.println("Processing edge :: " + x+ "==>" +y);
        numEdges = numEdges+1;
    }

}
