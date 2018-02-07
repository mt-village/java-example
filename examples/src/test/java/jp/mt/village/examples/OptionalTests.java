package jp.mt.village.examples;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.Test;

public class OptionalTests {

    /**
     * nullableな結果に対してさらにfilterしてそのままOptionalで返すくらいしか使い道がなさそう
     */
    @Test
    public void filter() {
        Optional.ofNullable("hoge")
                .filter(s -> s.startsWith("h"))
                .filter(s -> s.endsWith("e"))
                .ifPresent(System.out::println);
    }

    /**
     * mapの場合はmapperがOptionalを返すと入れ子になるがflatMapはならない
     * ただし、flatMapの場合、mapperはnullを返しちゃダメ。Optional.EMPTYはOK
     */
    @Test
    public void flatMap() {
        Optional<Integer> nullable = Optional.ofNullable(1);
        Optional<Optional<String>> useMap = nullable.map(num -> Optional.ofNullable(num.toString()));
        assertThat(useMap.get().get()).isEqualTo("1");
        Optional<String> useFlatMap = nullable.flatMap(num -> Optional.ofNullable(num.toString()));
        assertThat(useFlatMap.get()).isEqualTo("1");
    }
}
