package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GreedyAlgorithm {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", 2, 10));
        items.add(new Item("Item 2", 3, 15));
        items.add(new Item("Item 3", 5, 20));
        items.add(new Item("Item 4", 7, 25));
        items.add(new Item("Item 5", 1, 5));

        int capacity = 10;

        List<Item> selectedItems = knapsackGreedy(items, capacity);

        System.out.println("Selected items:");
        for (Item item : selectedItems) {
            System.out.println(item.getName() + " (Weight: " + item.getWeight() + ", Value: " + item.getValue() + ")");
        }
    }

    private static List<Item> knapsackGreedy(List<Item> items, int capacity) {
        items.sort((item1, item2) -> {
            double ratio1 = (double) item1.value / item1.weight;
            double ratio2 = (double) item2.value / item2.weight;

            return Double.compare(ratio1, ratio2);
        });

        List<Item> selectedItem = new ArrayList<>();
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (item.weight < remainingCapacity) {
                remainingCapacity -= item.weight;
                selectedItem.add(item);
            }
        }

        return selectedItem;
    }


    public static class Item {
        private String name;
        private int weight;
        private int value;

        public Item(String name, int weight, int value) {
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }
    }
}
