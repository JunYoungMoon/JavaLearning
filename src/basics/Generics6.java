package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 캡처 문제 해결하기
 */
public class Generics6 {

    //정상 동작
//    static <T> List<T> reverse(List<T> list){
//        List<T> temp = new ArrayList<>(list);
//
//        for (int i = 0; i < list.size(); i++) {
//            temp.set(i, list.get(list.size() - i - 1));
//        }
//        return temp;
//    }

    //capture of ? 에러 발생
//    static List<?> reverse(List<?> list){
//        List<?> temp = new ArrayList<>(list);
//
//        for (int i = 0; i < list.size(); i++) {
//            temp.set(i, list.get(list.size() - i - 1));
//        }
//        return temp;
//    }

    // 방법1 : 로우타입으로 변경하기
//    static List<?> reverse(List<?> list){
//        List temp = new ArrayList<>(list);
//        List list2 = temp;
//
//        for (int i = 0; i < list.size(); i++) {
//            list2.set(i, list.get(list.size() - i - 1));
//        }
//        return list2;
//    }

    // 방법2 : 헬퍼메서드를 사용하기
    static List<?> reverse(List<?> list) {
        return reverseHelper(list);
    }

    static <T> List<T> reverseHelper(List<T> list) {
        List<T> temp = new ArrayList<>(list);

        for (int i = 0; i < list.size(); i++) {
            temp.set(i, list.get(list.size() - i - 1));
        }
        return temp;
    }

    //권장 사항은 헬퍼 메서드를 사용하는 것이지만 그냥 <T>를 사용하자

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(reverse(list));
    }
}
