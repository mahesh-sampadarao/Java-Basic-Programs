import java.util.List;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class StreamGatherers {
    static void main() {
        IO.println("Welcome to Java 25");

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        Stream folded = numbers.gather(Gatherers.fold(() -> 0, Integer::sum));
        List<Integer> resultList = folded.toList();
        System.out.println(resultList);

        Stream<String> words = Stream.of("a", "b", "c", "d");
        List<String> resultList2 = words.gather(Gatherers.mapConcurrent(2, String::toUpperCase)).toList();
        IO.println(resultList2);
    }
}
