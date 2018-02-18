package com.kwonhyunwoo;

public class Main {

    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>BUBBLE SORT<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        sorting(new BubbleSort());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>SELECTION SORT<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        sorting(new SelectionSort());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>INSERTION SORT<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        sorting(new InsertionSort());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>MERGE SORT<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        sorting(new MergeSort());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>QUICK SORT<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        sorting(new QuickSort());

        // TO BE UPDATED : RADIX SORT, COUNTING SORT, HEAP SORT(*MANDANTORY)

    }

    public static void sorting(Sort sorting) {
        for (int i = 0; i < 5; i++) {
            sorting.randInit();
            System.out.println("BEFORE >> " + sorting.print());
            sorting.sort();
            System.out.println("AFTER  >> " + sorting.print());

        }
    }


}
