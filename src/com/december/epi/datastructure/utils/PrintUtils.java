package com.december.epi.datastructure.utils;

import java.util.*;

public class PrintUtils {

    public static <T> void printList(List<T> toPrint) {
        if(toPrint !=null && toPrint.size() > 0) {
            for(T data : toPrint) {
                System.out.println(data);
            }
        } else {
            System.out.println("Empty or Null List");
        }
    }

    public static <T> void printArray(T[] toPrint) {
        if(toPrint !=null && toPrint.length > 0) {
            for(T data : toPrint) {
                System.out.println(data);
            }
        } else {
            System.out.println("Empty or Null List");
        }
    }
}
