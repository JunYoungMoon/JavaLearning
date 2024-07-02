package basics;

import java.util.ArrayList;
import java.util.List;

// 제네릭 사용이유
// 1. 컴파일 시점에 정확하게 타입 체킹을 할수 있다.
//  - 대부분 리스트나 자료구조에는 타입을 미리 선언하고 사용하는데 그렇지 않은 경우(제네릭이 도입되기 전)에는
//    강제 캐스팅시에 런타임할때 언제든지 에러가 발생할수 있다. 즉 타입이 안전하지 않다.
// 2. 타입의 유연성이 생겨 재사용성이 늘어난다.
public class Generics1 {

    public static void main(String[] args) {
        // 1. 제네릭 타입을 사용한 선언
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        // stringList.add(1); // 컴파일 오류

        // 2. Raw 타입을 사용한 선언
        // Raw type은 제네릭 타입을 사용할 때 타입 인자를 명시하지 않은 타입을 말한다.
        // 제네릭이 도입되기 이전 버전의 호환성을 위해 존재하는 개념으로, 제네릭을 사용하지 않고 선언된 타입이다.
        List rawList = new ArrayList();
        rawList.add("String");
        rawList.add(1); // 컴파일러는 이 타입 오류를 감지하지 못합니다.

        for (Object obj : rawList) {
            String str = (String) obj; // 런타임에 ClassCastException 발생 가능
        }
    }
}
