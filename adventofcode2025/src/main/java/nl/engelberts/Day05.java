package nl.engelberts;

import java.util.ArrayList;

public class Day05 {
    private final Parser parser;
    private ArrayList<String> ranges;
    private ArrayList<Long> ingredients;
    private ArrayList<Long> validIngredients = new ArrayList<>();
    private long totalB = 0;

    public Day05(String filename) {
        this.parser = new Parser(filename);
        this.ranges = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        boolean isIngredients = false;
        for (String line : parser.getDataLines()) {
            if (line.equals("")) {
                isIngredients = true;
            } else {
                if (isIngredients) {
                    ingredients.add(Long.parseLong(line));
                } else {
                    ranges.add(line);
                }
            }
        }
        for (Long ingredient : ingredients) {
            for (String range : ranges) {
                String[] parts = range.split("-");
                Long min = Long.parseLong(parts[0]);
                Long max = Long.parseLong(parts[1]);
                if (ingredient >= min && ingredient <= max) {
                    if (!validIngredients.contains(ingredient)) {
                        validIngredients.add(ingredient);
                    }
                }
            }
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < ranges.size(); i++) {
                if (ranges.get(i).equals("0-0")) {
                    continue;
                }
                for (int j = i + 1; j < ranges.size(); j++) {
                    if (ranges.get(j).equals("0-0")) {
                        continue;
                    }
                    // System.out.println("Comparing " + ranges.get(i) + " with " + ranges.get(j));
                    String[] parts1 = ranges.get(i).split("-");
                    String[] parts2 = ranges.get(j).split("-");
                    Long min1 = Long.parseLong(parts1[0]);
                    Long max1 = Long.parseLong(parts1[1]);
                    Long min2 = Long.parseLong(parts2[0]);
                    Long max2 = Long.parseLong(parts2[1]);
                    if (min1 <= min2 && max1 >= max2) {
                        // System.out.println("Range " + ranges.get(i) + " fully contains " + ranges.get(j));
                        ranges.set(j, "0-0");
                        changed = true;
                    } else if (min2 <= min1 && max2 >= max1) {
                        // System.out.println("Range " + ranges.get(j) + " fully contains " + ranges.get(i));
                        ranges.set(i, ranges.get(j));
                        changed = true;
                        ranges.set(j, "0-0");
                    } else if (min1 <= min2 && (max1 <= max2 && max1 >= min2)) {
                        // System.out.println("Range " + ranges.get(i) + " overlaps with " + ranges.get(j));
                        ranges.set(i, "" + min1 + "-" + max2);
                        ranges.set(j, "0-0");
                        changed = true;
                        // System.out.println("Updated range " + ranges.get(i) + " after merging with " + ranges.get(j));
                    } else if (min2 <= min1 && (max2 <= max1 && max2 >= min1)) {
                        // System.out.println("Range " + ranges.get(j) + " overlaps with " + ranges.get(i));
                        ranges.set(i, "" + min2 + "-" + max1);
                        ranges.set(j, "0-0");
                        changed = true;
                        // System.out.println("Updated range " + ranges.get(i) + " after merging with " + ranges.get(j));
                    } else {
                        // System.out.println("No overlap between " + ranges.get(i) + " and " + ranges.get(j));
                    }
                }
            }
        }
        for (String range : ranges) {
            if (range.equals("0-0")) {
                continue;
            }
            String[] parts = range.split("-");
            Long min = Long.parseLong(parts[0]);
            Long max = Long.parseLong(parts[1]);
            totalB += (1 + max - min);
            System.out.println("Range: " + range + " has " + (1 + max - min) + " ingredients");
        }   
    }

    public String resultA() {
        return String.valueOf(validIngredients.size())  + " valid ingredients";
    }

    public String resultB() {
        return String.valueOf("" + totalB  + " valid ingredients");
    }    
}
