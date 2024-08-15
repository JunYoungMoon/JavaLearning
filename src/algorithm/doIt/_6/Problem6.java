package algorithm.doIt._6;

/**
 * 6-6 퀵정렬 사전 (배열 두 그룹 나누기)
 * 피벗을 기준으로 좌우 값을 구분하였지만 정렬은 안된상태
 */

public class Problem6 {
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void partition(int[] arr, int n) {
        int pl = 0;
        int pr = n - 1;
        int pivot = arr[n / 2];

        //pl,pr이 교차 할때까지 포인트를 증가,감소 하면서 swap을 진행한다.
        //피벗을 기준으로 좌측은 피벗보다 작은 값들이 우측은 피벗보다 큰 값들이 배치된다.
        do {
            while (arr[pl] < pivot) pl++;
            while (arr[pr] > pivot) pr--;
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        System.out.println("피벗 이하의 그룹");
        for (int i = 0; i <= pl - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        if (pl > pr + 1) {
            System.out.println("피벗과 일치하는 그룹");
            for (int i = pr + 1; i <= pl - 1; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        System.out.println();

        System.out.println("피벗 이상의 그룹");
        for (int i = pr + 1; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 9, 44, 13, 3, 7, 1, 6, 14, 3, 4, 1};
        partition(arr, arr.length);
    }
}