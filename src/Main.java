import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        findMinMax(Stream.empty(), Comparator.naturalOrder(),(min, max) ->
                System.out.println("min = " + min + " max = " + max));
        task2Stream();
    }

    public static void findMinMax(Stream<? extends Integer> stream,
                                  Comparator<? super Integer> comparator,
                                  BiConsumer<? super Integer, ? super Integer> minMaxConsumer) {
        List<Integer> integers = stream.map(Integer::valueOf).toList();
        Integer min = integers.stream().min(comparator).orElse(null);
        Integer max = integers.stream().max(comparator).orElse(null);
        if (min == null) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(min, max);
        }
    }

    private static void task2Stream() {
        Stream.iterate(2,i -> i+2).limit(20).forEach(System.out::println);
    }
}