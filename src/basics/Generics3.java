package basics;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 실제 Redis 라이브러리에서 사용되는 제네릭 파악하기
 */
interface RedisCodec<K, V> {
    static <K, V> RedisCodec<K, V> of(RedisCodec<K, ?> keyCodec, RedisCodec<?, V> valueCodec) {
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
    static <T> List<T> temp(){
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        //redis 코덱 설정
        RedisCodec<String, String> strArr = StringCodec.UTF8;
        RedisCodec<byte[], byte[]> byteArr = ByteArrayCodec.INSTANCE;
//        RedisCodec.of(StringCodec.UTF8, ByteArrayCodec.INSTANCE);

        //메서드에 argument(strArr, byteArr)가 있을때 argument의 타입을 추론한다.
        //of 메서드의 (RedisCodec<K, ?> keyCodec, RedisCodec<?, V> valueCodec) 파라미터를 먼저 보고 파라미터의 타입을 추론하여 K, V값을 매핑시킨다.
        RedisCodec.of(strArr, byteArr);

        //만약 메서드 argument가 없는 경우에는 반환받는 <String>으로 타입을 추론한다.
        List<String> temp = Generics3.temp();
        temp.add("a");
    }
}
