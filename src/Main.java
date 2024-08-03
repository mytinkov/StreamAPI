import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        findMinMax(Stream.empty(), Comparator.naturalOrder(),(min, max) ->
                System.out.println("min = " + min + " max = " + max));
        task2Stream(Arrays.asList(1, 2, 5, 8, 7, 2, 1, 5, 9, 6, 3, 4));
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

    private static void task2Stream(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}