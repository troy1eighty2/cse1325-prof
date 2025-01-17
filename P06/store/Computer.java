package store;

import java.util.ArrayList;

public class Computer {
    public Computer(String name, String model) {
        this.name = name;
        this.model = model;
    }
    public void addOption(Option option) {
        options.add(option);
    }
    public long cost() {
        long cost = 0;
        for(Option o : options) cost += o.cost();
        return cost;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " (" + model + "}");
        for(Option o : options) sb.append("\n  " + o);
        return sb.toString();
    }
    
    // WARNING: The equals method relies on a stable toString method
    //   that includes ALL significant fields to be compared
    // This includes the order in which Option objects were added
    // A better implementation would sort field options,
    //   which would require that Option implement Comparable
    // We'll leave that as a challenge for the enthusiastic student
    @Override
    public boolean equals(Object o) {
        try {
            if(this == o) return true;
            if(this.getClass() != o.getClass()) return false;
            Computer c = (Computer) o;
            return this.toString().equals(c.toString());
        } catch (Exception e) {
            return false;
        }
    }
    
    private String name;
    private String model;
    private ArrayList<Option> options = new ArrayList<>();
}
