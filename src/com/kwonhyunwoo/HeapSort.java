package com.kwonhyunwoo;

public class HeapSort extends Sort {
    /*
    - Heap? "완전 이진 트리(Complete Binary Tree)"에 있는 노드 중 Key가 가장 크거나(Max heap) 작은(Min heap) 노드를 찾기 위해 만든 자료구조
            우선순위 큐(Priority Queue)를 구현할 때 Heap이 자주 사용됨.
    - 완전 이진 트리? 트리의 마지막 레벨을 제외한 모든 레벨이 포화 이진 트리(Full Binary Tree)이고
                      마지막 레벨은 노드가 왼쪽부터 순서대로 채워져 있는 상태.

    cf. 이진 트리의 하부는 이진 트리이다 -> Recursive를 사용하기 편하다.

    - HeapSort : O(nlogn)의 시간이 걸리면서 in-place sorting이다.

     */
    @Override
    public void sort() {

    }

}

class Heap {
    /*
     heap은 array로도 표현이 가능하다.
     이 때, array의 각 element가 heap의 각 node를 표현한다.

      */
    int[] heapArr;

    public Heap(int size) {
        this.heapArr = new int[size];
    }
}
