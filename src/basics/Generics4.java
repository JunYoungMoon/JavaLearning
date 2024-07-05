package basics;

import java.util.*;

/**
 * 제한된 타입 파라미터
 */
public class Generics4 {
    // Bounded Type Parameter
//    static <T extends List> void print(T t){}

    // Multiple Bounds
//    static <T extends List & Serializable & Comparable & Closeable> void print(T t) {}

    // 타입에 자유롭지 못하다.
//    static long countGreaterThan(Integer[] arr, Integer elem) {
//        return Arrays.stream(arr).filter(s -> s > elem).count();
//    }

    // Integer, String은 Comparable을 구현한 클래스로 제한된 타입 파라미터로 사용가능하다.
    // s > elem로 숫자의 비교만 하는것이 아닌 compareTo로 문자 비교도 가능하다.
    static <T extends Comparable<T>> long countGreaterThan(T[] arr, T elem) {
        return Arrays.stream(arr).filter(s -> s.compareTo(elem) > 0).count();
    }

    static class A {}
    static class B extends A {}
    static class C extends B {}
    static class D {}

    public static void main(String[] args) {
        Integer[] arrInt = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] arrStr = new String[]{"a", "b", "c", "d", "e"};

        System.out.println(countGreaterThan(arrStr, "b"));
        System.out.println(countGreaterThan(arrInt, 5));

        // ------------------------------------------

        // 컴파일에러 발생
        // List<Integer> 타입은 List<Number> 타입의 슈퍼타입이 아니다. 제네릭은 기본적으로 공변성을 지원하지 않는다.
        // Covariance : 어느 한쪽으로 치우치거나 사사롭지 않고 공평하다. 상속관계가 유지 된다.
        // 상속관계의 제네릭 타입(<Integer>,<Number>)은 적용된 타입(List)에 영향을 주지 않는다.
//        List<Integer> integerList = new ArrayList<>();
//        List<Number> numberList = integerList;

        // 정상동작
        // List<Integer> 타입은 ArrayList<Integer> 타입의 슈퍼타입이 맞다.
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        List<Integer> integerList = integerArrayList;

        List<A> a = new ArrayList<>();
        List<B> b = new ArrayList<>();
        List<C> c = new ArrayList<>();
        List<D> d = new ArrayList<>();

        a.add(new A());
        b.add(new B());
        c.add(new C());
        d.add(new D());

        //이하만 가능
        List<? extends A> aExtend = b;
        //이상만 가능
        List<? super B> bSuper = a;
    }
}
