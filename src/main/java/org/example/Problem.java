package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    public int n;
    public long seed;
    public int lowerBound, upperBound;
    public List<Integer> weights;
    public List<Integer> values;

    public Problem(int n, long seed, int lowerBound, int upperBound) {
        this.n = n;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        weights = new ArrayList<>();
        values = new ArrayList<>();
        Random random = new Random(seed);
        for (int i = 0; i < n; i++) {
            weights.add(random.nextInt(upperBound - lowerBound + 1) + lowerBound);
            values.add(random.nextInt(upperBound - lowerBound + 1) + lowerBound);
        }
    }

    public Result Solve(int capacity) {
        int[] dp = new int[capacity + 1];
        int[] lastItemIndex = new int[capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j < n; j++) {
                if (weights.get(j) <= i) {
                    int newValue = dp[i - weights.get(j)] + values.get(j);
                    if (newValue > dp[i]) {
                        dp[i] = newValue;
                        lastItemIndex[i] = j;
                    }
                }
            }
        }

        List<Integer> itemsTaken = new ArrayList<>();
        int remainingCapacity = capacity;
        int totalWeight = 0;
        while (remainingCapacity > 0) {
            int itemIndex = lastItemIndex[remainingCapacity];
            if (dp[remainingCapacity] == 0) break;
            itemsTaken.add(itemIndex);
            remainingCapacity -= weights.get(itemIndex);
            totalWeight += weights.get(itemIndex);
        }

        return new Result(dp[capacity], totalWeight, itemsTaken, capacity);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("n = ").append(n).append("\n");
        //sb.append("seed = ").append(seed).append("\n");
        //sb.append("lowerBound = ").append(lowerBound).append("\n");
       // sb.append("upperBound = ").append(upperBound).append("\n");
        //sb.append("Items:\n");
        for (int i = 0; i < n; i++) {
            sb.append("Item ").append(i).append(": Weight = ").append(weights.get(i))
                    .append(", Value = ").append(values.get(i)).append("\n");
        }
        return sb.toString();
    }

}
