package algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int key = 99;

        int result = binarySearch(arr, key);

        if (result == -1) {
            System.out.println("찾는값 없음");
        } else {
            System.out.println("찾는값 arr[" + result + "]에 있음");
        }
    }

    static int binarySearch(int[] arr, int key) {
        int pl = 0;
        int pr = arr.length-1;

        while (pl <= pr) {
            int pc = (pr + pl) >> 1;
            if (arr[pc] == key) {
                return pc;
            } else if (arr[pc] > key) {
                pr = pc - 1;
            } else if (arr[pc] < key) {
                pl = pc + 1;
            }
        }

        return -1;
    }
}
