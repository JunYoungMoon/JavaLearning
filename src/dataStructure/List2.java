package dataStructure;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * 배열 리스트 초기값 설정 확인
 * VN option : --add-opens java.base/java.util=ALL-UNNAMED
 */
public class List2 {
    public static void main(String[] args) throws Exception {
        // 기본 초기 용량을 사용하는 ArrayList
        ArrayList<Integer> defaultList = new ArrayList<>();
        System.out.println("Default initial size: " + defaultList.size());
        System.out.println("Default initial capacity: " + getCapacity(defaultList));

        // 첫 번째 요소 추가
        defaultList.add(1);
        System.out.println("Size after adding 1 element: " + defaultList.size());
        System.out.println("Capacity after adding 1 element: " + getCapacity(defaultList));

        // 9개의 요소 추가 (총 10개)
        for (int i = 2; i <= 10; i++) {
            defaultList.add(i);
        }
        System.out.println("Size after adding 10 elements: " + defaultList.size());
        System.out.println("Capacity after adding 10 elements: " + getCapacity(defaultList));

        // 11번째 요소 추가
        defaultList.add(11);
        System.out.println("Size after adding 11th element: " + defaultList.size());
        System.out.println("Capacity after adding 11th element: " + getCapacity(defaultList));
    }

    // ArrayList의 용량을 반환하는 메서드
    private static int getCapacity(ArrayList<?> arrayList) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        Object[] internalArray = (Object[]) dataField.get(arrayList);
        return internalArray.length;
    }
}
