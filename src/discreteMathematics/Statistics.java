package discreteMathematics;

import java.math.BigInteger;

public class Statistics {
    public static void main(String[] args) {

        BigInteger bigNumber1 = BigInteger.valueOf(174);
        BigInteger bigNumber2 = BigInteger.valueOf(174);

        for (int i = 1; i < 55; i++) {
            bigNumber1 = bigNumber1.multiply(BigInteger.valueOf(174));
        }

        for (int i = 1; i < 110; i++) {
            bigNumber2 = bigNumber2.multiply(BigInteger.valueOf(174));
        }

        System.out.println(bigNumber1.remainder(BigInteger.valueOf(221)));
        System.out.println(bigNumber2.remainder(BigInteger.valueOf(221)));
    }
}
