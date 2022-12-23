package com.december.epi.datastructure.graph.enums;

public enum NodeColor {

    UNCOLORED,
    WHITE,
    BLACK;

    public static NodeColor complement(NodeColor color) {
        NodeColor complement = UNCOLORED;
        if(color == WHITE)
            complement = BLACK;
        if( color == BLACK )
            complement = WHITE;

        return complement;
    }
}
