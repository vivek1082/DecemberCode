package com.december.epi.datastructure.utils;

import java.util.*;

public class Utils {

    public static <T> void swapListElement(int firstElementIndex, int nextElementIndex, List<T> list) {
        if(list!= null && list.size() >1) {
            if(firstElementIndex < 0 || firstElementIndex > list.size()-1 || nextElementIndex < 0 || nextElementIndex > list.size() -1) {
                System.out.println("Swap index not proper.");
            } else {
                T temp = list.get(firstElementIndex);
                list.set(firstElementIndex, list.get(nextElementIndex));
                list.set(nextElementIndex, temp);
            }
        }
    }
}
