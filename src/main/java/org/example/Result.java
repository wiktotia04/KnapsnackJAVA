package org.example;

import java.util.List;

public class Result {
    private int value;
    private int weight;
    private int capacity;
    private List<Integer> taken;

    public Result(int value, int weight, List<Integer> taken, int capacity) {
        this.value = value;
        this.weight = weight;
        this.taken = taken;
        this.capacity = capacity;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Integer> getTaken() {
        return taken;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("value = ").append(value).append("\n");
        sb.append("weight = ").append(weight).append("\n");
        sb.append("capacity = ").append(capacity).append("\n");
        sb.append("taken = ").append(taken).append("\n");
        return sb.toString();
    }
}
