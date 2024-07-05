package basics;

import java.util.*;

/**
 * 클래스,메서드 레벨 제네릭
 */
public class Generics2<T> { // <T> 클래스 레벨의 제네릭
//    static class Hello<T> { // T -> type parameter
//        T value;
//
//        T method(T value) {
//            return null;
//        }
//    }
    T value;

    public void setValue(T value) {
        this.value = value;
    }

    // <S> 메서드 레벨의 제네릭
    // static void print(T t) 메서드 레벨의 제네릭이 없는데 클래스 레벨의 제네릭이 있다고 해도
    // static 메서드기 때문에 클래스 레벨의 제네릭을 사용 할수 없다.
    static <S> void print(S s) {
        System.out.println(s);
    }


    //생성자에서도 제네릭 사용
//    public <S> Generics2(S s) {
//    }

    //클래스 레벨과 메서드 레벨을 섞어서 사용
    <S> T print2(S s) {
        System.out.println(s);
        return value;
    }

    public static void main(String[] args) {
        //new Hello<String>();    // String type argument

        Map<String, String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(map);

        Generics2.print(list);
        Generics2.print(1);
        Generics2.print("string");
        Generics2.print(Arrays.asList(1, 2, 3, 4));

        //클래스 레벨과 메서드 레벨을 섞어서 사용
        String a = new Generics2<String>().print2(1);
        System.out.println(a);
        String b = new Generics2<String>().print2(Arrays.asList("a", "b", "c"));
        System.out.println(b);
    }
}
