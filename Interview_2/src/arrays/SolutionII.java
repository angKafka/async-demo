package arrays;

import java.util.ArrayList;
import java.util.List;

public class SolutionII {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int number = 1;
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <=  i; j++) {
                row.add(number);
                number = number * (i - j) / (j + 1);
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionII solution = new SolutionII();
        System.out.println(solution.generate(5));
    }
}
