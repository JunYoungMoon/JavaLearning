package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-8 힙정렬
 * 1. downHeap을 호출하여 전체 배열을 힙 구조로 만들기
 * 2. 배열의 첫 요소(최대값)를 배열의 끝으로 보내고, 배열의 나머지 부분을 다시 힙으로 재구성
 */

public class Problem12 {
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void downHeap(int[] arr, int left, int right) {
        int temp = arr[left]; //현재 부모 노드의 값을 temp에 저장
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1; // 왼쪽 자식
            int cr = cl + 1;         // 오른쪽 자식

            //자식 노드의 인덱스 cl, cr을 계산하여, 두 자식 중 더 큰 값을 가진 자식을 child로 선택
            child = (cr <= right && arr[cr] > arr[cl]) ? cr : cl;

            //부모 노드의 값이 자식 노드의 값보다 크거나 같으면 힙의 조건을 만족하므로 반복문을 종료
            if (temp >= arr[child]) {
                break;
            }
            //그렇지 않으면 자식 노드의 값을 부모 노드로 이동시키고, 자식 노드로 내려가면서 이 과정을 반복
            arr[parent] = arr[child];
        }

        arr[parent] = temp;
    }

    static void heapSort(int[] arr, int n) {
        //힙 구성: 배열의 중간부터 시작하여, 부모 노드를 대상으로 downHeap을 호출하여 전체 배열을 힙 구조로 만든다.
        //중간부터 시작하는 이유는 힙의 가장 아래 레벨에 있는 노드들은 자식이 없기 때문에 재구성할 필요가 없기 때문
        for (int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(arr, i, n - 1);
        }

        //정렬 과정: 배열의 첫 요소(최대값)를 배열의 끝으로 보내고,
        //배열의 나머지 부분을 다시 힙으로 재구성(downHeap)하는 과정을 반복한다.
        //이렇게 하면 배열이 역순으로 정렬된다.
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            downHeap(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 10, 7, 8};

        heapSort(arr, 5);

        System.out.println(Arrays.toString(arr));
    }
}