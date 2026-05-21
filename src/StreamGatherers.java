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

        // Moving average over a sliding window — impossible cleanly before Gatherers
        List<Double> prices = List.of(100.0, 102.0, 98.0, 105.0, 110.0, 108.0);

        List<Double> movingAverage = prices.stream()
                .gather(Gatherers.windowSliding(3))
                .map(window -> window.stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .orElse(0.0))
                .toList();
        IO.println(movingAverage);// [100.00, 101.67, 104.33, 107.67]

        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        // Sliding window: overlapping sub-lists of size n
        List<List<Integer>> sliding = numbers2.stream()
                .gather(Gatherers.windowSliding(3))
                .toList();
        // [[1,2,3], [2,3,4], [3,4,5], [4,5,6], [5,6,7], [6,7,8]]

        // Fixed (tumbling) window: non-overlapping chunks
        List<List<Integer>> chunks = numbers2.stream()
                .gather(Gatherers.windowFixed(3))
                .toList();
        // [[1,2,3], [4,5,6], [7,8]]

        // Scan: emit the running state at each element
        List<Integer> runningTotal = numbers2.stream()
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .toList();
        // [1, 3, 6, 10, 15, 21, 28, 36]
    }
}
