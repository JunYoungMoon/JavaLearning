package algorithm.doIt._9;

import java.util.Comparator;
import java.util.Scanner;

/**
 * 9-4 원형 이중 연결 리스트
 */

public class Problem2 {
    static Scanner stdIn = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        public String toString() {
            return "(" + no + "," + name + ")";
        }

        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            //& 연산자는 비트 AND 연산자로, 두 피연산자의 각각의 비트를 비교하여 둘 다 1인 경우에만 결과 비트를 1로 설정한다.
            //그렇지 않으면 0이 된다.
            if ((sw & NO) == NO) {
                System.out.print("번호 : ");
                no = stdIn.nextInt();
            }

            if ((sw & NAME) == NAME) {
                System.out.print("이름 : ");
                name = stdIn.next();
            }
        }

        //회원번호로 순서를 매기는 comparator
        public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data> {
            @Override
            public int compare(Data o1, Data o2) {
                return (o1.no > o2.no) ? 1 : (o1.no < o2.no) ? -1 : 0;
            }
        }

        //이름으로 순서를 매기는 comparator
        public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

        private static class NameOrderComparator implements Comparator<Data> {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.name.compareTo(o2.name);
            }
        }
    }

    enum Menu {
        // JVM에 의해 하나씩 객체가 생성된다.
        ADD_FIRST("머리에 노드를 삽입 "), ADD_LAST("꼬리에 노드를 삽입 "), RMV_FIRST("머리 노드를 삭제"), RMV_LAST("꼬리 노드를 삭제"),
        RMV_CRNT("선택 노드를 삭제"), CLEAR("모든 노드를 삭제"), SEARCH_NO("번호로 검색"), SEARCH_NAME("이름으로 검색"),
        NEXT("선택 노드를 하나 뒤쪽으로 이동"), ADD("선택 노드 바로 뒤에 노드 삽입"), PRINT_CRNT("선택 노드를 출력"), DUMP("모든 노드를 출력"),
        DUMP_REVERSE("모든 노드를 거꾸로 출력"), TERMINATE("종료");

        private final String message;

        static Menu MenuAt(int idx) {
            for (Menu m : Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        Menu(String string) { // 생성자
            message = string;
        }

        String getMessage() { // 표시용 문자열을 반환
            return message;
        }
    }

    // 메뉴선택
    static Menu SelectMenu() {
        int key;
        do {
            for (Menu m : Menu.values()) {
                //Menu 상수의 인덱스와 메시지를 출력
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());

                //현재 인덱스를 3으로 나눈 나머지가 2인지 확인 즉, 인덱스가 2, 5, 8 등일 때 이 조건이 참이 되고 3개씩 메뉴가 출력되도록 줄을 바꾼다.
                if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
                    System.out.println();
            }
            System.out.print("：");
            key = stdIn.nextInt();
        } while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu; // 메뉴
        Data data; // 추가용 데이터 참조
        Data ptr; // 검색용 데이터 참조
        Data temp = new Data(); // 입력 받기용 데이터

        DblLinkedList<Data> list = new DblLinkedList<>();

        do {
            switch (menu = SelectMenu()) {
                case ADD_FIRST: // 머리에 노드를 삽입
                    data = new Data();
                    data.scanData("머리에 삽입 ", Data.NO | Data.NAME);
                    list.addFirst(data);
                    break;

                case ADD_LAST: // 꼬리에 노드를 삽입
                    data = new Data();
                    data.scanData("꼬리에 삽입 ", Data.NO | Data.NAME);
                    list.addLast(data);
                    break;

                case RMV_FIRST: // 머리노드를 삭제
                    list.removeFirst();
                    break;

                case RMV_LAST: // 꼬리노드를 삭제
                    list.removeLast();
                    break;

                case RMV_CRNT: // 선택 노드를 삭제
                    list.removeCurrentNode();
                    break;

                case CLEAR: // 모든 노드를 삭제
                    list.clear();
                    break;

                case SEARCH_NO: // 번호로 검색
                    temp.scanData("검색", Data.NO);
                    ptr = list.search(temp, Data.NO_ORDER);
                    if (ptr == null)
                        System.out.println("그 번호의 데이터가 없습니다.");
                    else
                        System.out.println("검색성공：" + ptr);
                    break;

                case SEARCH_NAME: // 이름으로 검색
                    temp.scanData("검색", Data.NAME);
                    ptr = list.search(temp, Data.NAME_ORDER);
                    if (ptr == null)
                        System.out.println("그 이름의 데이터가 없습니다.");
                    else
                        System.out.println("검색성공：" + ptr);
                    break;

                case NEXT: // 선택 노드를 하나 뒤쪽으로 이동
                    list.next();
                    break;

                case ADD: // 선택 노드 바로 뒤에 노드 삽입
                    data = new Data();
                    data.scanData("선택 노드 바로 뒤에 노드 삽입 ", Data.NO | Data.NAME);
                    list.add(data);
                    break;

                case PRINT_CRNT: // 선택 노드를 출력
                    list.printCurrentNode();
                    break;

                case DUMP: // 모든 노드를 리스트 순서로 나타냄
                    list.dump();
                    break;

                case DUMP_REVERSE: // 모든 노드를 거꾸로 출력
                    list.dumpReverse();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}