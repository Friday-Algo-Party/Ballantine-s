package mincoding.DAT;

import java.util.*;

public class 성실한직원찾기 {
    public static void main(String[] args) {
        int arr[][] = {
            {65000, 35, 42, 70},
            {70, 35, 65000, 1300},
            {65000, 30000, 38, 42}
        };

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }
        }
        int max = 0;
        int index = 0;
        for (int key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                index = key;
            }
        }
        System.out.println(index);
    }
}
