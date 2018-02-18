package com.kwonhyunwoo;


import java.util.ArrayList;
import java.util.List;

public class QuickSort extends Sort {
    //int[] arr을 가지고 있음.

    @Override
    public void sort() {
        quickSort();
    }

        /*
       주어진 배열의 값 중 기준이 될 pivot을 하나 정한다.
       이 후 pivot과 해당 값을 비교하면서 pivot보다 작으면 왼쪽으로, 같거나 크면 오른쪽으로 보낸다.
       이후 pivot을 넣어서 하나의 정렬된 배열을 만들어내면 된다.

       -----------------------------
       | 96 | 72 | 25 | 55 | 9 | 1 |
       -----------------------------
       에서 만약 pivot이 55라면...

       우선 기존 pivot을 제거

       ------------------------
       | 96 | 72 | 25 | 9 | 1 |
       ------------------------

       left arr
       --------------
       | 25 | 9 | 1 |
       --------------

       right arr
       -----------
       | 96 | 72 |
       -----------
       이 되며 이를 recursive하게 계속 들어가면서 정렬하면 하나의 정렬이 완료된 array가 된다.

       left 부터...
       --------------
       | 25 | 9 | 1 |
       --------------
       에서 pivot이 9이므로 (pivot을 제거 한 뒤 다음과 같아진다.)

       left arr
       -----
       | 1 |
       -----
       right arr
       ------
       | 25 |
       ------

       더 이상 쪼갤 수가 없으므로 combine에서 계속 recursive를 돌다가 나오게 된다.
       이 때 맨 처음 combine의 quicksort(left) 결과는 다음과 같아진다.
       --------------
       | 1 | 9 | 25 |
       --------------


       그 다음 right...
       -----------
       | 96 | 72 |
       -----------
       에서 pivot이 72라면

       left는 없고 right만 다음과 같다.
       ------
       | 96 |
       ------
       이후 pivot을 붙여서
       quicksort(right)의 결과는 다음과 같아진다.
       -----------
       | 72 | 96 |
       -----------

       이 때 마지막으로 combine이 돌 때는 다음과 같다.
       left
       --------------
       | 1 | 9 | 25 |
       --------------

       pivot
       ------
       | 55 |
       ------


       right
       -----------
       | 72 | 96 |
       -----------

       따라서 combine을 통해 나온 결과는 다음과 같아진다.
       -----------------------------
       | 1 | 9 | 25 | 55 | 72 | 96 |
       -----------------------------

     */

    private void quickSort() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        List<Integer> result = quickSort(list);
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
    }

    private List<Integer> quickSort(List<Integer> list) {
        if (list.size() < 2) return list;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int pivot = list.get(list.size() / 2);
        list.remove(list.size() / 2);

        for (Integer element : list) {
            if (pivot > element)
                left.add(element);
            else
                right.add(element);

        }

        return combine(quickSort(left), pivot, quickSort(right));
    }

    private List<Integer> combine(List<Integer> left, int pivot, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        for (Integer leftInteger : left) {
            result.add(leftInteger);
        }
        result.add(pivot);
        for (Integer rightInteger : right) {
            result.add(rightInteger);
        }

        return result;
    }
}

