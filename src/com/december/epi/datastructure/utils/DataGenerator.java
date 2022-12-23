package com.december.epi.datastructure.utils;

import java.util.*;

public class DataGenerator {

    public static List<Integer> getIntList() {
        List<Integer> returnList = new ArrayList<>();
        returnList.add(5);
        returnList.add(0);
        returnList.add(73);
        returnList.add(4);
        returnList.add(5);
        returnList.add(1);
        returnList.add(33);
        returnList.add(6);

        return returnList;
    }

    public static List<Integer> getBoardGameIntListArrays() {
        List<Integer> returnList = new ArrayList<>();
        returnList.add(3);
        returnList.add(3);
        returnList.add(1);
        returnList.add(0);
        returnList.add(2);
        returnList.add(0);
        returnList.add(1);

        return returnList;
    }

    public static List<Integer> getBoardGameUnreachableIntListArrays() {
        List<Integer> returnList = new ArrayList<>();
        returnList.add(3);
        returnList.add(2);
        returnList.add(0);
        returnList.add(0);
        returnList.add(2);
        returnList.add(0);
        returnList.add(1);

        return returnList;
    }

    public static int[] getStockSellProblemInput() {
        int[] arr = {12,11,13,9,12,8,14,13,15};
        return  arr;
    }

    public static int[] getStockSellProblemInput2() {
        int[] arr = {310,315,275,290,260,270,290,230,255,250};
        return  arr;
    }
}
