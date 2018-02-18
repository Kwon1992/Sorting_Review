package com.kwonhyunwoo;


public class InsertionSort extends Sort {
    @Override
    /*
        Insertion Sort는 현재 위치의 직전 값과 비교하면서 순서대로 정렬되어있는지 확인하는게 기본이다.
          --------------------
          | 12 | 2 | 18 | 1 |
          --------------------
          에서 만약 현재 위치가 2라면, 12와 비교해서 순서대로 정렬되어있는지 확인.
          위의 상태에서는 12가 2보다 크므로 정렬이 되어있지 않는 상황이다. 따라서 정렬이 필요하다.


     */
    public void sort() {
        for (int sortCheckIdx = 1; sortCheckIdx < arr.length; sortCheckIdx++) { // sortCheckIdx는 순서대로 나아가면서 정렬상태인지 확인한다.
            for (int reverseCheckIdx = sortCheckIdx - 1; reverseCheckIdx >= 0; reverseCheckIdx--) {
                // 정렬이 되어있는지 확인하는 방법은 바로 직전 위치의 값과 비교하는 것이라고 위에서 설명헀다.
                // 따라서 비교를 위해 for문을 하나 더 돌면서 reverseCheckIdx를 통해 비교한다.
                if (arr[reverseCheckIdx] > arr[reverseCheckIdx + 1]) { // 만약, reverseCheckIdx의 값이 reverseCheckIdx+1 값보다 크다면, 정렬이 되어있지 않은 상태이다.
                    // 따라서 위치를 바꾸어준다.
                    int temp = arr[reverseCheckIdx + 1];
                    arr[reverseCheckIdx + 1] = arr[reverseCheckIdx];
                    arr[reverseCheckIdx] = temp;
                } else {
                    break;
                }
                //여기서 이를 for문으로 처리한 이유는 다음과 같은 상황이 발생할 수 있기 때문이다.
                /*
                    --------------------
                    | 12 | 17 | 18 | 1 |
                    --------------------
                    위의 상황에서 현재 sortCheckIdx가 3이라면, 1을 가리키게 된다.
                    이 떄, 1은 바로 직전의 18보다 작으므로, 두 값의 위치를 swap하면 다음과 같아진다.
                    --------------------
                    | 12 | 17 | 1 | 18 |
                    --------------------
                    하지만, 여기서 끝나면 정렬상태가 아니다. 바꾼 뒤 1의 직전값이 17이므로, 1보다 크기 때문이다.
                    따라서, 1은 다시 한 번 17과 자리를 바꾸어야 하므로 for문을 돌면서 바로 직전값이 더 큰지 작은지 확인하여 크다면 계속해서 위치를 바꿔주고,
                    작다면 정렬이 된 것이므로 break를 통해 탈출하는 것이다.
                 */
            }

        }
    }
}
