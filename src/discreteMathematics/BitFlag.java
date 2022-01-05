package discreteMathematics;

public class BitFlag {
    public static void main(String[] args) {
        final byte ATTACK_NONE = 0;
        final byte ATTACK_FIRE = 1;
        final byte ATTACK_ICE = 2;
        final byte ATTACK_WIND = 3;
        final byte ATTACK_ARCANE = 4;
        final byte ATTACK_SIZE = 5;

        byte propertyFlags = 8; //외부에서 받은값
        System.out.printf("0%s\n", Integer.toBinaryString(propertyFlags));

        byte mask1 = (byte) ((1 << ATTACK_FIRE) | (1 << ATTACK_ARCANE));
        propertyFlags |= mask1; //화속성, 비전속성 켬
        System.out.println(Integer.toBinaryString(propertyFlags));

        byte mask2 = (byte) (1 << ATTACK_ICE);
        propertyFlags ^= mask2; // 빙속성 토글
        System.out.println(Integer.toBinaryString(propertyFlags));

        byte mask3 = (byte) (1 << ATTACK_WIND);
        propertyFlags &= (byte) ~mask3; // 풍속성 끔
        System.out.println(Integer.toBinaryString(propertyFlags));
    }
}
