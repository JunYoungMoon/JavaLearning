package basics;

import java.util.*;

// 제한된 타입 파라미터
public class Generics3 {
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

    static class MyList<T, S> implements List<T> {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T1> T1[] toArray(T1[] a) {
            return null;
        }

        @Override
        public boolean add(T t) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends T> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public T get(int index) {
            return null;
        }

        @Override
        public T set(int index, T element) {
            return null;
        }

        @Override
        public void add(int index, T element) {

        }

        @Override
        public T remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<T> listIterator() {
            return null;
        }

        @Override
        public ListIterator<T> listIterator(int index) {
            return null;
        }

        @Override
        public List<T> subList(int fromIndex, int toIndex) {
            return null;
        }
    }

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

        List<String> list1 = new MyList<String,String>();
        List<String> list2 = new MyList<String,Integer>();
    }
}
