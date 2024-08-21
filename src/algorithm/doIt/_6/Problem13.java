package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-9 도수정렬
 * 1. 도수분포표(특정 값이나 범위에 속한 데이터 수) 만들기
 * 2. 누적도수분포표 만들기
 * 3. 목적배열 만들기
 * 4. 배열 복사하기
 * 도수분포표를 만들기 위한 최소값,최대값을 미리 알아야한다.
 * 중복된 값이 있으면 그 순서가 보장되지 않는다.
 */

public class Problem13 {
    static void fSort(int[] arr, int n, int max) {
        int[] f = new int[max + 1];
        int[] b = new int[n];

        //1단계 도수분포표 만들기
        //이상황에서 이미 정렬이 됨
        for (int i = 0; i < n; i++) {
            f[arr[i]]++;
        }

        //2단계 누적도수분포표 만들기
        //새로운 배열에 넣기 위한 유니크한 인덱스 번호 생성
        for (int i = 1; i <= max; i++) {
            f[i] += f[i - 1];
        }

        //3단계 목적배열 만들기
        //누적도수분포표 f배열은 목적배열 b에 index값을 가지고 있다.
        //이 index 값으로 목적배열의 index에 arr배열의 값을 넣는다.
        //값이 중복일수 있기 때문에 n-1을 하면서 index의 중복이 발생하지 않도록 한다.
        //이게 가능한 이유는 도수분포표를 만들때 중복값은 +1씩 더해졌기 때문이다.
        for (int i = n - 1; i >= 0; i--) {
            b[--f[arr[i]]] = arr[i];
        }

        //4단계
        for (int i = 0; i < n; i++) {
            arr[i] = b[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 6, 10, 7, 8, 1, 6, 4};

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        fSort(arr, arr.length, max);

        System.out.println(Arrays.toString(arr));
    }
}