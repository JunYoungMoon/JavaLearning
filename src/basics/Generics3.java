package basics;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

interface RedisCodec<K, V> {
    static <K, V> RedisCodec<K, V> of(RedisCodec<K, ?> keyCodec, RedisCodec<?, V> valueCodec) {

        // 해당 매개변수의 타입 출력
        System.out.println(keyCodec.getClass());
        System.out.println(valueCodec.getClass());

        return new ComposedRedisCodec<>(keyCodec, valueCodec);
    }
}

class ComposedRedisCodec<K, V> implements RedisCodec<K, V> {
    private final RedisCodec<K, ?> keyCodec;

    private final RedisCodec<?, V> valueCodec;

    ComposedRedisCodec(RedisCodec<K, ?> keyCodec, RedisCodec<?, V> valueCodec) {
        this.keyCodec = keyCodec;
        this.valueCodec = valueCodec;
    }
}

class StringCodec implements RedisCodec<String, String> {
    public static final StringCodec UTF8 = new StringCodec(StandardCharsets.UTF_8);

    private final Charset charset;

    public StringCodec(Charset charset) {
        this.charset = charset;
    }
}

class ByteArrayCodec implements RedisCodec<byte[], byte[]> {
    public static final ByteArrayCodec INSTANCE = new ByteArrayCodec();
}

public class Generics3 {
    public static void main(String[] args) {
        //redis 코덱 설정
        RedisCodec<String, String> strArr = StringCodec.UTF8;
        RedisCodec<byte[], byte[]> byteArr = ByteArrayCodec.INSTANCE;
//        RedisCodec.of(StringCodec.UTF8, ByteArrayCodec.INSTANCE);
        RedisCodec.of(strArr, byteArr);
    }
}
