import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class StreamGatherers {
    static void main() {
        IO.println("Welcome to Java 25");

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> folded = numbers.gather(Gatherers.fold(() -> 0, Integer::sum));
        List<Integer> resultList = folded.toList();
        System.out.println(resultList);

        Stream<String> words = Stream.of("a", "b", "c", "d");
        List<String> resultList2 = words.gather(Gatherers.mapConcurrent(2, String::toUpperCase)).toList();
        IO.println(resultList2);

        List<List<Integer>> expectedOutput = List.of(List.of(1, 2, 3), List.of(2, 3, 4), List.of(3, 4, 5));
        Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);
        List<List<Integer>> resultList3 = numbers1.gather(Gatherers.windowSliding(3))
                .toList();
        IO.println(resultList3);

        List<Integer> expectedOutput1 = List.of(5, 6, 3);
        Stream<String> inputStrings = Stream.of("apple", "banana", "cat");
        List<Object> resultList4 = inputStrings.gather(Gatherer.of((state, element, downstream) -> {
                    downstream.push(element.length());
                    return true;
                }))
                .toList();
        IO.println(resultList4);

    }
}
