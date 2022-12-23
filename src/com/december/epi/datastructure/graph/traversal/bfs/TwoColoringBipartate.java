package com.december.epi.datastructure.graph.traversal.bfs;

import com.december.epi.datastructure.graph.adt.*;
import com.december.epi.datastructure.graph.enums.*;
import static com.december.epi.datastructure.graph.enums.NodeColor.*;
import static com.december.epi.datastructure.graph.enums.TraversalDiscoveryEnum.*;

import java.util.*;

public class TwoColoringBipartate extends BFS {

    boolean bipartate = true;
    List<NodeColor> color;     //to color node on vertices number, intial all uncolored

    public TwoColoringBipartate(Graph graph) {
        super(graph);
        color = new ArrayList<>();
        for(int i=0; i< graph.getVerticesNum(); i++) {
            color.add(UNCOLORED);
        }
    }

    public void colorGraph() {
        int numVertex = getGraph().getVerticesNum();

        for(int i=0; i <numVertex; i++) {
            if(getNodeStatus().get(i) == UNDISCOVERED) {
                color.set(i,WHITE);
                super.traverseGraph(i);
            }
        }
        System.out.println("Graph is biparitate ?? :: " + bipartate);
    }

    /**
     * While processing edge we need to change color.
     * If we visit any egde which has same color on both vertex we are not bi0parirtate
     * @param x
     * @param y
     */
    @Override
    public void processEdge(int x, int y) {
        if(color.get(x) == color.get(y)) {
            bipartate = false;
            System.out.println("Graph is not bipartate at edge " +x+"::"+y);
        }

        color.set(y,complement(color.get(x)));
    }
}
