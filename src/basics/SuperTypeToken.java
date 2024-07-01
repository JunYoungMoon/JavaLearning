package basics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class SuperTypeToken {
    static class TypeSafeMap {
        Map<Type, Object> map = new HashMap<>();

        <T> void put(TypeReference<?> tr, T value) {
            map.put(tr.type, value);
        }

        <T> T get(TypeReference<T> tr) {
            if (tr.type instanceof Class<?>) {
                return ((Class<T>) tr.type).cast(map.get(tr.type)); // <String>
            } else {
                return ((Class<T>) ((ParameterizedType) tr.type).getRawType()).cast(map.get(tr.type)); // List<String>
            }
        }
    }

    static class TypeReference<T> {
        Type type;

        public TypeReference() {
            Type stype = getClass().getGenericSuperclass();
            if (stype instanceof ParameterizedType) {
                this.type = ((ParameterizedType) stype).getActualTypeArguments()[0];
            } else throw new RuntimeException();
        }
    }

//    static class Sup<T>{
//        T value;
//    }
//
//    static class Sub extends Sup<List<String>>{
//
//    }

    public static void main(String[] args) throws NoSuchFieldException {
//        TypeReference t = new TypeReference<List<String>>() {
//        };
//        System.out.println(t.type);

        // 1. 서브클래스를 만들면서 슈퍼 클래스의 타입을 지정해주면 런타임시에도 정보 접근이 가능하다.
//        Sup s = new Sub();

        // 2. Local Class로 가져와 Anonymous Class로 만들면 상속을 받은 것과 동일하게 정보를 얻을수 있다.
//        Sup s = new Sup<List<String>>() {};
//
//        Type type = s.getClass().getGenericSuperclass();
//        ParameterizedType ptype = (ParameterizedType) type;
//        System.out.println(Arrays.toString(ptype.getActualTypeArguments()));

        TypeSafeMap typeSafeMap = new TypeSafeMap();
        typeSafeMap.put(new TypeReference<String>() {
        }, "aaa");
        typeSafeMap.put(new TypeReference<Integer>() {
        }, 1);
        typeSafeMap.put(new TypeReference<List<Integer>>() {
        }, Arrays.asList(1, 2, 3, 4));
        typeSafeMap.put(new TypeReference<List<List<String>>>() {
        }, Arrays.asList(Arrays.asList("a", "b", "c", "d"), Arrays.asList("a", "b", "c", "d"), Arrays.asList("a", "b", "c", "d"), "d"));

        System.out.println(typeSafeMap.get(new TypeReference<String>() {
        }));
        System.out.println(typeSafeMap.get(new TypeReference<Integer>() {
        }));
        System.out.println(typeSafeMap.get(new TypeReference<List<Integer>>() {
        }));
        System.out.println(typeSafeMap.get(new TypeReference<List<List<String>>>() {
        }));


    }
}
