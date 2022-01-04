package dataStructure;

//각 열에 1개의 퀸을 배치하는 조합을 재귀적으로 나열
public class QueenB {
    static int[] pos = new int[8];

    static void set(int i){
        for(int j =0 ; j < 8 ; j++){
            pos[i] = j;
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
