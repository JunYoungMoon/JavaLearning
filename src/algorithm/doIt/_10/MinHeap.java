package algorithm.doIt._10;

import java.util.ArrayList;

/**
 * 추상 데이터 타입 (ADT): 데이터와 연산의 개념적 정의. 구현 방법은 포함되지 않음.
 * 예: 우선순위 큐(Priority Queue)
 * 자료구조: ADT를 실제로 구현하는 방법. 데이터의 저장 및 조작 방법을 구체적으로 정의.
 * 예: 힙(Heap)
 */
public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // 부모 노드 인덱스 구하기
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    // 왼쪽 자식 노드 인덱스 구하기
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    // 오른쪽 자식 노드 인덱스 구하기
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // 값을 추가할 때 (삽입)
    public void insert(int value) {
        heap.add(value); // 맨 끝에 값을 추가
        heapifyUp(heap.size() - 1); // 힙 속성을 유지하도록 재정렬
    }

    // 삽입 후 힙 속성을 유지하기 위해 위로 이동하며 재정렬
    private void heapifyUp(int index) {
        int current = index;
        //현재 노드가 부모 노드보다 작으면 swap
        while (current > 0 && heap.get(current) < heap.get(getParentIndex(current))) {
            swap(current, getParentIndex(current));
            current = getParentIndex(current);
        }
    }

    // 최솟값(루트) 제거
    public int remove() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        // 루트 값(최솟값)을 저장하고, 마지막 값을 루트로 이동
        int rootValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0); // 힙 속성을 유지하도록 재정렬

        return rootValue;
    }

    // 삭제 후 힙 속성을 유지하기 위해 아래로 이동하며 재정렬
    private void heapifyDown(int index) {
        int current = index;
        while (getLeftChildIndex(current) < heap.size()) {
            int smallerChildIndex = getLeftChildIndex(current);

            if (getRightChildIndex(current) < heap.size() &&
                    heap.get(getRightChildIndex(current)) < heap.get(smallerChildIndex)) {
                smallerChildIndex = getRightChildIndex(current);
            }

            if (heap.get(current) <= heap.get(smallerChildIndex)) {
                break;
            }

            swap(current, smallerChildIndex);
            current = smallerChildIndex;
        }
    }

    // 두 노드의 값을 바꾸는 메서드
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    // 힙이 비어 있는지 확인
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // 힙에서 최솟값(루트) 반환
    public int peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0); // 루트가 최솟값
    }

    // 힙 출력
    public void printHeap() {
        System.out.println(heap);
    }
}

