package Feb2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Level 1. 데이터 분석
 */
public class DataAnalysis {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                solution(new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, "date", 20300501, "remain")));
    }

    private static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> dataIndex = new HashMap<>(){{
            put("code", 0); put("date", 1); put("maximum", 2); put("remain", 3);
        }};

        return Arrays.stream(data)
                .filter(d -> d[dataIndex.get(ext)] < val_ext)
                .sorted(Comparator.comparingInt(d -> d[dataIndex.get(sort_by)]))
                .toArray(int[][]::new);
    }
}
