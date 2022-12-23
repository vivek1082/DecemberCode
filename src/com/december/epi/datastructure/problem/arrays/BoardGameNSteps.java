package com.december.epi.datastructure.problem.arrays;

import java.util.*;

import static com.december.epi.datastructure.utils.DataGenerator.*;
import static com.december.epi.datastructure.utils.PrintUtils.*;
import static com.december.epi.datastructure.utils.Utils.*;
/**
 * Given an array with corresponding steps, reach end.
 * Find out whether we can reach at end or not.
 * If yes how many steps/jump required to reach end of array/board.
 *
 * e.g <3,3,1,0,2,0,1>
 *     we can do brute force search, We can start with max jump in the beginning , but it can leave
 *     higher intermidiate jump. e.g <2,4,1,1,0,2,3> -- 1st steps of 2 can leave the 2nd higher jump.
 *
 *     Above approach suggest we should iterate to check the max jump.
 *     While iterating calculate furthest for each jump.
 *     ```fur(i) -> Max(i+A[i],knownMax)```
 *     ```if for any i < size: fur(i) = i. We can not reach to the end.```
 *
 *     ```To trace the path back trace and negate the size of array from actual value.
 *     V[i] - A[i] > 0.```
 */
public class BoardGameNSteps {

    public static void main(String args[]) {
        List<Integer> boardSteps = trackSteps(getBoardGameIntListArrays());
        System.out.println("Track Reachable :: " +isReachableTracks(boardSteps));

        boardSteps = trackSteps(getBoardGameUnreachableIntListArrays());
        System.out.println("Track Reachable :: " +isReachableTracks(boardSteps));


    }

    private static List<Integer> trackSteps(List<Integer> board) {
        List<Integer> furthestDistance = new ArrayList<>(board.size());
        if( board!=null && board.size() > 0 ) {
            int maxKnownDistance = 0;

            int i =0;
            for(Integer step : board) {
                maxKnownDistance = Math.max(maxKnownDistance, i + step);
                furthestDistance.add(i,maxKnownDistance);
                i++;
                if( i == maxKnownDistance) {
                    break;
                }
            }
            if(furthestDistance.get(furthestDistance.size() -1) < board.size()-1) {
                furthestDistance.clear();
            }
        }
        return furthestDistance;
    }

    private static boolean isReachableTracks(List<Integer> steps) {
        return steps.size() > 0;
    }

//    private static int noOfJump(List<Integer> furthestDistance, List<Integer> gameBoard, int originalTrackSize) {
//        int totalJump = 0;
//        int i=gameBoard.size();
//        int minSeen = furthestDistance.get(furthestDistance.size());
//        int trackSize= furthestDistance.size();
//        while( originalTrackSize > 0 ) {
//            for()
//            totalJump++;
//
//        }
//        return totalJump;
//    }





















}
