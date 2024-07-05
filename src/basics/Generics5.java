package basics;

import java.util.*;

/**
 * 제네릭 와일드카드
 */
public class Generics5 {

    // method1, method2의 차이점
    // method1은 선언 된 타입 파라미터 T는 메서드 내 어떤곳이든 정의 해서 사용 할수 있다.
    static <T> void method1(List<T> list){
        T t;
    }
    // method2의 와일드카드 ?는 메서드 내부에 정의해서 사용하지 않는다.
    static void method2(List<?> list){
        //사용 가능한 것
//        list.size();
//        list.clear();
//        Iterator<?> it = list.iterator();
//        list.add(null);
//        list.isEmpty();

        //사용 불가능한 것
//        list.add(1);
//        list.add("string");
    }

    //제네릭 타입 T를 정의 하거나 와일드카드를 사용해도 모두 동작한다.
//    static <T> boolean isEmpty(List<T> list){
    static boolean isEmpty(List<?> list){
        return list.isEmpty();
    }

    //마찬가지로 와일드카드를 사용해도 모두 동작한다.
//    static <T> long frequency(List<T> list, T element){
    static long frequency(List<?> list, Object element){
        //equals는 Object 클래스안에 선언 되어있다.
        //와일드카드 사용법중에 또한가지는 Object 클래스안에 적용된 toString, equals등을 사용하는 것은 허용이 된다.
        //그렇기 때문에 와일드카드로도 equals 코드가 작성이 가능하다.
        return list.stream().filter(s -> s.equals(element)).count();
    }

    //위의 경우 <T>, ?중에 어떤걸 사용하는게 더 적절할까? 물론 두가지 기능은 완벽하게 동작을 한다.
    //자바 설계 원칙으로 보면 "와일드카드"를 사용하는것이 맞다.
    //왜냐하면 <T>를 사용하는 경우에는 내부 구현에서 T타입을 이용해서 작업을 하겠다라는 의미로 내부 구현이 노출이 된다.

    static <T extends Comparable<? super T>> T max(List<? extends T> list){
        return list.stream().reduce((a, b) -> a.compareTo(b) > 0 ? a : b).get();
    }

    public static void main(String[] args) {
        // wildcards 이자리에는 뭐든지 와도 되고 나는 여기에 들어갈 타입을 모른다. 그래서 리스트에만 있는 기능(size, clear, iterator, add(null)...)만 사용한다.
        List<?> wildcard = new ArrayList<>();

        // Object 타입중에서 나는 여기에 들어갈 타입을 모른다. 그래서 Object 클래스에 정의 된 기능(hashCode, toString, equals...)만 사용한다.
        List<? extends Object> objectFeaturesOnly;

        // 지금 이 T의 타입은 모르지만 이타입이 정해지면 이타입이 뭔지 알고 사용 하겠다.
//        List<T> list2;

        List<Integer> list = Arrays.asList(1,2,3,4,5,3,3,2);
        method1(list);
        method2(list);

        System.out.println(isEmpty(list));
        System.out.println(frequency(list,3));

        System.out.println(max(list));
        System.out.println(Collections.max(list, (Comparator<Object>)(a, b) -> a.toString().compareTo(b.toString())));

        //---------------------------------------------------------------
        List<Integer> src = new ArrayList<>();
        src.add(1);
        src.add(2);
        src.add(3);

        List<Integer> dest = new ArrayList<>(Collections.nCopies(src.size(), 0)); // dest 리스트를 src 크기만큼 초기화

        System.out.println("Before copy:");
        System.out.println("Source: " + src);
        System.out.println("Destination: " + dest);

        Collections.copy(dest, src);

        System.out.println("After copy:");
        System.out.println("Source: " + src);
        System.out.println("Destination: " + dest);

        //<? extends T>와 <? super T>를 잘나타내는 Collections.copy() 메서드를 보면,
        //메서드 내부에서 사용되는 값이라면 <? extends T>를 사용하고
        //메서드 외부에서 사용되는 값이라면 <? super T>를 사용한다.
        //왜? 메인타입(List)의 서브타입(<? extends Integer>)은 "뭐가 될지 모르기 때문"에 메인타입만 사용이 가능하다.
        //그래서 값의 정보를 가져오는 정도의 기능만 사용되도록 제한을 한다.(읽기제약)
        List<? extends Integer> list2 = new ArrayList<>();
        //list2.add(1); // 컴파일 오류: List<? extends Integer>에 요소를 추가할 수 없음
        System.out.println(list2.size()); // 읽기 가능

        //메서드 외부에서는 읽기와 쓰기가 모두 가능 해야한다.
        List<? super Integer> list3 = new ArrayList<>();
        list3.add(1); // 쓰기 가능
        System.out.println(list3.get(0)); // 읽기 가능
    }
}
