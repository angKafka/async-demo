import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q1 {
    static String question = "rajkumar";

    public static void main(String[] args) {
        Map<String, Long> countMap = Arrays.stream(question.split(""))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );
        System.out.println(countMap);
    }
}
