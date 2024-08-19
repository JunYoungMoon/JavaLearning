package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-8 힙정렬
 */

public class Problem12 {

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void downHeap(int[] arr, int left, int right) {
        int temp = arr[left];
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && arr[cr] > arr[cl]) ? cr : cl;
            if (temp >= arr[child]) {
                break;
            }
            arr[parent] = arr[child];
        }

        arr[parent] = temp;

    }

    static void heapSort(int[] arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(arr, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            downHeap(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1,0};

        heapSort(arr, 4);

        System.out.println(Arrays.toString(arr));
    }
}