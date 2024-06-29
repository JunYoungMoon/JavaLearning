package basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Type Token 타입 정보를 값으로 넘기겠다. 여기서는 String.class, Integer.class, List.class
// type erasure(타입소거) : 제네릭 타입이 컴파일 시점에서 제거되어, 런타임 시에는 실제 타입 정보가 없는 것을 의미
// 런타임시에는 Generic<String> 의 String이 삭제가 되고 Object 타입으로 변경된다.
// 컴파일시점에 코드를 검증 받는것이 안전하고 좋다. 타입 캐스팅은 런타임때 어떤 문제가 야기 될지 모른다.
public class TypeToken {
    static class TypeSafeMap {
        Map<Class<?>, Object> map = new HashMap<>();

        <T> void put(Class<?> clazz, T value) {
            map.put(clazz, value);
        }

        <T> T get(Class<T> clazz){
            return clazz.cast(map.get(clazz));
        }
    }

    public static void main(String[] args) {
        TypeSafeMap typeSafeMap = new TypeSafeMap();

        typeSafeMap.put(String.class, "aaa");
        typeSafeMap.put(Integer.class, 1);
        typeSafeMap.put(List.class, Arrays.asList(1,2,3,4));
        //같은 키일때 Map을 덮어 써버린다 type erasure 때문에 List<String>.class도 불가능하다.
//        typeSafeMap.put(List<String>.class, Arrays.asList("a","b","c","d"));

        System.out.println(typeSafeMap.get(String.class));
        System.out.println(typeSafeMap.get(Integer.class));
        System.out.println(typeSafeMap.get(List.class));
    }
}
