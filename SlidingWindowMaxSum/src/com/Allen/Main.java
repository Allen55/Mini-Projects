package com.Allen;

public class Main {
    /*
        The sliding window tips:
        Typically well suited for iterable items.
        Contiguous/Sequential sequence of elements (items that are grouped together) (subset)
        Strings, arrays of ints or chars, linked lists
        Trying to find the min, max, longest, shortest, contained within a given string/array
        - maybe we need to calculate something
        Question Variants:
          - Fixed length variant
              - Max Sum subarray of size k
          - Dynamic Variant
              - Smallest sum >= to some value s
          - Dynamic variant with auxillary data structure
              - Longest substring w/ no more than k distinct characters
          - String permutations
       - Commonalities
          - Everything grouped sequentially
          - Longest smallest contains
          - Max min
      **************************************************************************************************
      Find the max sum subarray of a fixed size K

      Example input:
      [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]

    */

    public static int findMaxSubArray(int[] arr, int k){

        int maxValue = Integer.MIN_VALUE;
        int currentRunningSum = 0;

        for(int i = 0; i < arr.length; i++){
            currentRunningSum += arr[i];
            if(i >= k-1){
                maxValue = Math.max(maxValue, currentRunningSum);
                currentRunningSum -= arr[i - (k-1)];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {


        int[] intArray = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        System.out.println(findMaxSubArray(new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0}, 3));
        int test = Integer.MIN_VALUE;
        System.out.println(test);

    }
}
