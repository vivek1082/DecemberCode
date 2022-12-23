package com.december.epi.datastructure.graph.traversal.bfs;

import com.december.epi.datastructure.graph.adt.*;
import static com.december.epi.datastructure.graph.enums.TraversalDiscoveryEnum.*;

public class ConnectedComponents extends BFS{

    public ConnectedComponents( Graph graph) {
        super(graph);
    }

    public void connectedComponents() {
        System.out.println("**********Connected Component Start");
        int componentNum = 0;
        int numVertex = this.getGraph().getVerticesNum();
        for(int i =0; i < numVertex; i ++) {
            if(getNodeStatus().get(i) == UNDISCOVERED) {
                componentNum++;
                System.out.println("****Component " + componentNum + " *********");
                super.traverseGraph(i);
            }
        }
        System.out.println("**********Connected Component End");
    }

    @Override
    public void processVertexEarly(int x) {
        super.processVertexEarly(x);
    }

    @Override
    public void processEdge(int x, int y) {
    }
}
