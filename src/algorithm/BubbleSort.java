package algorithm;

import java.util.Scanner;

public class BubbleSort {
    public void bubbleSort(int[] dataArray) {
        int temp;
        for (int i = 0; i < dataArray.length - 1; i++) {
            for (int j = 0; j < dataArray.length - i - 1; j++) {
                if (dataArray[j] > dataArray[j + 1]) {
                    temp = dataArray[j];
                    dataArray[j] = dataArray[j + 1];
                    dataArray[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        String[] inputArray = input.split(" ");
        int n = inputArray.length;
        int[] dataArray = new int[n];
        for (int i = 0; i < n; i++) {
            dataArray[i] = Integer.parseInt(inputArray[i]);
        }
        sorter.bubbleSort(dataArray);
        for (int x : dataArray) {
            System.out.println(x);
        }
    }
}
