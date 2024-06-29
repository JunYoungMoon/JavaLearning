package basics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class SuperTypeToken {
    static class Sup<T> {
        T value;
    }

//    static class Sub extends Sup<List<String>> {
//
//    }

    public static void main(String[] args) throws NoSuchFieldException {
        // 서브클래스를 만들면서 슈퍼 클래스의 타입을 지정해주면 런타임시에도 정보 접근이 가능하다.
//        Sup s = new Sub();
        
        // Local Class로 가져와 Anonymous Class로 만들면 상속을 받은 것과 동일하게 정보를 얻을수 있다.
        Sup s = new Sup<List<String>>() {};

        Type type = s.getClass().getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType) type;
        System.out.println(Arrays.toString(ptype.getActualTypeArguments()));
    }
}
