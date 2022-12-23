package com.december.epi.datastructure.problem.arrays;

import com.sun.xml.internal.ws.api.model.wsdl.*;

import java.util.*;

import static com.december.epi.datastructure.utils.DataGenerator.*;
import static com.december.epi.datastructure.utils.PrintUtils.*;
import static com.december.epi.datastructure.utils.Utils.*;

public class StocksSell {

    public static void main(String[] args) {
//        System.out.println("Printing max profit for single sell input1::" +
//                getMaxProfitOnOneSell(getStockSellProblemInput()));

        System.out.println("Printing max profit of double sell input1::" +
                getMaxProfitOnDoubleSellNative(getStockSellProblemInput()));

//        System.out.println("Printing max profit for single sell input2::" +
//                getMaxProfitOnOneSell(getStockSellProblemInput2()));

//        System.out.println("Printing max profit of double sell input2::" +
//                getMaxProfitOnDoubleSellNative(getStockSellProblemInput2()));
    }

    /**
     * This is one of dynamic problem. Or simple array problem.
     * For getting maximum profit iterate array and keep track of minimum seen and maxProfit.
     * Maximum profit can be get by
     * maxProfit = max(A[i] - minSeen,maxProfit)
     *
     * Constraint is buy before sell and not on same day.
     *
     * O(n) & O(1)
     * @param arr
     * @return
     */
    public static int getMaxProfitOnOneSell(int arr[]) {
        int maxProfit = 0;
        if(arr.length > 1) {
            int minSeen = arr[0];
            for(int i=0; i < arr.length; i++) {
                maxProfit = Math.max(maxProfit,arr[i] - minSeen);
                minSeen = Math.min(minSeen,arr[i]);
            }
        }
        return maxProfit;
    }

    /**
     * Probelm statement is same as above, 2 buy sell allowed.
     * 2nd buy only after first sell.
     * Max 2 transaction allowed on a trade day.
     * To solve this divide array for all combination.
     * e.g for array length 7 -- 0:1::1:6; 0:2::26;.....;0:5::5:6
     *
     * ```division loop
     *      0:i:size-1
     *The above division of breaking of aary takes O(n) times.
     *
     * For solution of each use the 1st single sell algorithm on both divided part.
     * Keep track of GlobalMaxProfit and retutn result.
     *
     * O(n2) and O(1).
     *
     * Problem with this approach , on divided array we never get use of already calculated
     * calculation.
     *
     * Constraint array size must be minimum 3
     * @param arr
     * @return
     */
    public static int getMaxProfitOnDoubleSellNative(int arr[]) {
        int globalMaxProfit = 0;
        if(arr.length > 2) {
            for(int i = 0; i < arr.length -1; i++) {
                int totalIterationProfit = 0;
                    int firstHalf = getMaxProfitOnOneSell(Arrays.copyOfRange(arr,0,i+2));
                    int secondHalf = getMaxProfitOnOneSell(Arrays.copyOfRange(arr,i+1,arr.length));
                    totalIterationProfit = firstHalf + secondHalf;
                    System.out.println("Iteration Profit :: 0::" + (i+1) + "==" + firstHalf+ "   ::" +(i+1)+"::" +(arr.length-1)+
                            "==="+ secondHalf+
                            "  ::value=== " + totalIterationProfit);
                    globalMaxProfit = Math.max(totalIterationProfit,globalMaxProfit);
            }
        }
        return globalMaxProfit;
    }

    /**
     * With above approach we are not taking advantage of already calculated sum
     * We can do better with O(n).
     * @param arr
     * @return
     */
    public static int getMaxProfitOnDoubleSellOptimized(int[] arr) {
        return 0;
    }
}
