package com.kwonhyunwoo;


public class SelectionSort extends Sort {
    @Override
    // 우선 전체 순회 후 제일 큰 값을 마지막 위치의 값과 바꿔가는 방식으로 구현한다.
    public void sort() {
        int maxIdx = 0;
        int maxVal = arr[maxIdx];
        for (int sortedIdx = arr.length - 1; sortedIdx >= 0; sortedIdx--) { // sortedIdx는 배열 중 제일 큰 값이 올 위치를 나타낸다. 즉, sortedIdx가 점점 작아지면서 정렬을 해야하는 index 위치가 0에 수렴한다. (점점 정렬이 되어감을 의미)
            maxIdx = 0; // 시작할 때는 맨 첫 요소가 max이므로 임의로 지정해준다.
            maxVal = arr[maxIdx]; // 위 주석과 동일.
            for (int checkMaxValue = 0; checkMaxValue <= sortedIdx; checkMaxValue++) { // checkMaxValue는 현재 정렬되지 않은 부분에서 최대값의 위치(index)를 찾기 위해 for문을 돌면서 일일이 확인한다.
                if (maxVal < arr[checkMaxValue]) {
                    maxIdx = checkMaxValue;
                    maxVal = arr[maxIdx];
                }
            }
            // 확인이 끝나면 값을 바꿔준다.
            int temp = arr[sortedIdx];
            arr[sortedIdx] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }
}
