import java.util.*;

public class Solution {
    public static List<Integer> popularKScores(int[] numbers, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : numbers) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priority = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priority.offer(entry);
            if (priority.size() > k) priority.poll();
        }

        List<Integer> res = new LinkedList<>();
        while (!priority.isEmpty()) {
            res.add(0, priority.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        List<Integer> res = popularKScores(arr, k);
        System.out.println(res);

        scanner.close();
    }
}