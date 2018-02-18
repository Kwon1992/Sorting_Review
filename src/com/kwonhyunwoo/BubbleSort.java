package com.kwonhyunwoo;

public class BubbleSort extends Sort {
    @Override
    public void sort() {
        /*
            Bubble Sort는 array의 처음부분과 다음 부분을 계속해서 비교해 나가면서 가장 크기가 큰 값을 맨 오른쪽으로 보내
            오른쪽 끝부터 정렬해가는 Sorting Algorithm이다
         */
        for (int sorted = arr.length - 1; sorted >= 0; sorted--) {
            // sorted는 정렬후 저장될 값을 표시하는 idx이다. ( 즉, 현재까지 정렬된 + 이번 차례에 정렬될 index를 가리킴)
            for (int toSort = 0; toSort < sorted; toSort++) {
                // toSort는 처음부터 sorted까지 순회하면서 정렬하기 위한 index
                if (arr[toSort] > arr[toSort + 1]) {
                    //만약 array의 왼쪽에 있는 element 값이 오른쪽보다 크다면...
                    /*
                        --------------------
                        | 12 | 2 | 18 | 19 |
                        -------------------- 에서
                               |
                          (toSort + 1)
                        이 위치의 2는 왼쪽의 12보다 작다. 즉, arr[toSort]인 12는 arr[toSort+1]인 2보다 크다.
                        따라서, 12와 2의 위치를 바꾼다.
                     */
                    int temp = arr[toSort + 1];
                    arr[toSort + 1] = arr[toSort];
                    arr[toSort] = temp;
                    // 위 3 statement의 결과는 다음과 같다.
                    /*

                        --------------------
                        | 2 | 12 | 18 | 19 |
                        --------------------
                     */
                }
            }
        }
    }
}
