package com.december.epi.datastructure.graph.traversal;

/**
 * Common methods for both dfs and BFS
 */
public interface GraphTraversalI {

    /**
     * Task to do when Vertex just got DISCOVERED
     * @param x
     */
    public void processVertexEarly(int x);

    /**
     * Task to do when Vertex is completely Processed
     * @param x
     */
    public void processVertexLate(int x);

    /**
     * Edge processing while an edge got discovered while traversing
     * @param x
     * @param y
     */
    public void processEdge(int x, int y);

    @Deprecated
    public void traverseGraph();

    public void traverseGraph(int startVertex);

    public void initSearchComponent();

}
