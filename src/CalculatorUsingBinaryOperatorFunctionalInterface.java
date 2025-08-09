import java.util.function.BinaryOperator;

public class CalculatorUsingBinaryOperatorFunctionalInterface {
    public static void main(String[] args) {
        int result=calculator((a,b)->a+b,5,2);
        double resultDouble=calculator((a,b)->a*b,2.5,2.5);
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}
