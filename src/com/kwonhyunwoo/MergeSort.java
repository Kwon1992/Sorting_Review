package com.kwonhyunwoo;

public class MergeSort extends Sort {

    @Override
    public void sort() {
        mergeSort(arr, 0, arr.length);
    }

    /*
       --------------------
       | 12 | 17 | 1 | 18 |
       --------------------
       이걸 mergesort로 정렬하고자 한다.
       mergesort는 divide and conquer를 이용한다.
       기본적으로 Bubble, Selection, Insertion은 O(n^2)의 시간이 걸리는 반면,
       mergesort는 O(nlogn)의 시간이 걸린다. 이는 Divide And Conquer이라는 기법을 이용함으로써 시간복잡도를 낮추는 것이 가능한 것이다.


       
       이후, 오른쪽의 17의 경우도 더 이상 쪼갤 수 있는 상태가 아니므로 return이 되고 실제 merge가 시작된다.
     */

    private void mergeSort(int[] arr, int start, int end) {
        if (end - start < 2) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        // mid는 실제로는 사용할 마지막 idx+1의 값이다. 우리는 0,1을 사용하지만 mid는 4/2 == 2가 됨.

        /*
            우선 위의 길이 4의 배열이 주어진 경우 mergesort는 다음과 같이 2개로 나눈다.
            -----------             ----------
            | 12 | 17 |             | 1 | 18 |
            -----------             ----------

            이후  Recursive에 의해 왼쪽부터 시작된다.

            ------    ------             ----------
            | 12 |    | 17 |             | 1 | 18 |
            ------    ------             ----------

            다시 맨 왼쪽에서 Recursive하게 들어가는데 더 이상 쪼갤 수 있는 배열 상태가 아니므로 그냥 return하게 된다.
            "if(end - start < 2) return;"
         */

        // 이후, return된 배열들을 서로 merge하면서 실제로 정렬을 시작한다.
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int temp[] = new int[end - start];
        //정렬한 배열을 저장할 int 배열을 선언한다. end - start로 길이를 만드는 이유는 비효율적으로 공간을 낭비하지 않기 위해서이다.
        int leftIdx = start;
        int rightIdx = mid;
        int tempIdx = 0;


        while (leftIdx < mid && rightIdx < end) {
            temp[tempIdx++] = (arr[leftIdx] > arr[rightIdx]) ? arr[rightIdx++] : arr[leftIdx++];
        }
        // 두 분할된 배열 (개념적으로 분할함) 중 값이 작은 것부터 순서대로 채워나간다.
        // 단, left 배열이 mid보다 작은 경우이면서 right 배열이 end보다 작은 경우에만 가능!! 하나라도 넘어가는 경우 해당 배열에 대한 정렬이 끝난 것이므로.



        /*
            만약 left 배열이 끝났다면....

            {-12, 25} || {10, 22, 155}
            leftIdx < 2; rightIdx < 5;
            tempIdx = 0; leftIdx = 0; rightIdx = 2
            temp = {-12,} => tempIdx = 1; leftIdx = 1; rightIdx = 2;
            temp = {-12, 10} => tempIdx = 2; leftIdx = 1; rightIdx = 3;
            temp = {-12, 10, 22} => tempIdx = 3; leftIdx = 1, rightIdx = 4;
            temp = {-12, 10, 22, 25} => tempIdx = 4; leftIdx = 2, rightIdx = 4;
            그리고 아직 right에 155가 temp에 저장되지 않았다.
            => 그냥 남은 것을 순서대로 넣어주면 된다.

            만약 right 배열이 끝났다면....

            {2, 10, 15) || {-10, 3}
            temp = {-10} tempIdx : 1 leftIdx 1
            temp = {-10, 2} tempIdx : 2 leftIdx 1, rightIdx 1;
            temp = {-10, 2, 3} tempIdx : 3 leftIdx 2, rightIdx 1;
            stop
            아직 left의 10, 15가 temp에 저장되지 않았다.

           기존 배열 arr에서 (이 때 arr은 클래스 자체의 arr이 아닌, merge method로 넘겨받은 parameter에 해당하는 arr)
           left 배열의 해당하는 부분을 그냥 끝으로 옮긴뒤, 지금까지 temp에 담은 나머지 부분을 copy하면 된다.

         */

        /*
            leftOverStart는 위의 while문을 탈출한 뒤 leftIdx를 담는다.
            sortedEnd는 위의 while문을 탈출한 뒤 지금까지 temp에서 정렬된 idx 위치를 갖는다. start + tempIdx인 이유는 실제 arr에서 시작위치가 무조건 0부터라는 보장이 없기 때문이다.
            leftLength는 merge 함수가 받은 개념적인 left 배열의 길이를 담는다.

            우리는 while문을 탈출한 이유가 left 배열이 끝나서인지 혹은 right 배열이 끝나서인지 알 수 없다.
            하지만 left가 끝났을 경우는 단순히 뒤에 추가만 해주면 되고, right가 끝났을 경우는 left의 남은 부분을 뒤로 넘겨두고 앞에서부터 채워주면 되므로 후자의 경우만 신경써주만 알아서 해결이 된다.
            이를 그림으로 표현한다면...
                          |
            --------------|----------
            | 2 | 10 | 15 | -10 | 3 |
            --------------|---------- 에서 첫 번째 while문을 지나고 나면 다음과 같아진다.
                          |



            start   leftIdx        rightIdx
              |        |               |
              |        |  |            |
            --------------|----------
            | 2 | 10 | 15 | -10 | 3 |   <arr>
            --------------|---------- 가 merge에서 arr로 받은 개념적 배열이라면
                          |  |    |
                          |  |    |
                            mid  end

                                 tempIdx
                                   |
                  <채워진 부분> |  |
            --------------------|-----
            | -10 | 2 | 3 | 10  |    |    <temp>
            --------------------|----- temp는 왼쪽과 같다.
                                |

            따라서. leftIdx에 대항하는 부분을 arr의 맨 오른쪽으로 보내준다. [" System.arraycopy(arr, leftOverStart, arr, sortedEnd, leftLength); "]
            --------------------------
            | 2 | 10 | 15 | -10 | 15 |   <arr>
            --------------------------
            그 뒤 나머지 앞 부분을 temp의 부분으로 대체하면 정렬이 된다.  [" System.arraycopy(temp, 0, arr, start, tempIdx); "]

            -------------------------
            | -10 | 2 | 3 | 10 | 15 |    <arr>
            -------------------------

            이러한 과정은 아래의 구현으로 가능하다.
         */
//        int leftOverStart = leftIdx;
//        int sortedEnd = start + tempIdx; // 0 + 3,
//        int leftLength = mid - leftIdx; // 맨 오른쪽에 추가되어야할 나머지 left 배열의 길이.
//        System.arraycopy(arr, leftOverStart, arr, sortedEnd, leftLength); //arr에서 leftOverStart부터 시작해서, arr로 sortedEnd부터 leftLength만큼 복사한다.
//        System.arraycopy(temp, 0, arr, start, tempIdx);



        // 또는... boolean을 이용해보자.
        boolean isLeftFin = (leftIdx > mid);
        if(isLeftFin) {
            while(rightIdx < end ){
                temp[tempIdx++] = arr[rightIdx++];
            }
        } else {
            while(leftIdx < mid) {
                temp[tempIdx++] = arr[leftIdx++];
            }
        }
        System.arraycopy(temp, 0, arr, start, tempIdx);
    }
}
