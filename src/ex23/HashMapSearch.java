package ex23;

import java.util.HashMap;

public class HashMapSearch {
    public static int hashMapSearch(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        return -1;
    }
}
