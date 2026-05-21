import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecordDestructuringInsideStreams {
    static void main() {
        List<Order> orders = List.of(
                new Order("O001", "C100", 150.0, "PAID"),
                new Order("O002", "C101", 89.5,  "PENDING"),
                new Order("O003", "C100", 230.0, "PAID"),
                new Order("O004", "C102", 45.0,  "CANCELLED")
        );

        // Filter using record pattern + unnamed variables for ignored components
        double paidTotal = orders.stream()
                .filter(o -> o instanceof Order(_, _, double amount, String status)
                        && "PAID".equals(status) && amount > 100)
                .mapToDouble(Order::amount)
                .sum();
        // 380.0 (O001 + O003)

        // Route into different buckets based on status
        Map<String, List<String>> grouped = orders.stream()
                .collect(Collectors.groupingBy(
                        o -> switch (o) {
                            case Order order when "PAID".equals(order.status())    -> "completed";
                            case Order order when "PENDING".equals(order.status()) -> "in-progress";
                            case Order order                                       -> "other: " + order.status();
                        },
                        Collectors.mapping(Order::id, Collectors.toList())
                ));
        // {completed=[O001, O003], in-progress=[O002], other: CANCELLED=[O004]}
    }
}

record Order(String id, String customerId, double amount, String status) {}