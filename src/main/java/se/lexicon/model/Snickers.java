package se.lexicon.model;

public class Snickers extends Product {

    private int calories;

    public Snickers(int id, double price, String productName, int calories) {
        setId(id);
        setPrice(price);
        setProductName(productName);
        setCalories(calories);
    }

    public String examine() {
        String toString;

        toString = getProductName() + " " + getId() + " " + getPrice() + " " + getCalories();

        return toString;
    }

    public String use() {
        return "You eat the " + this.getProductName();
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return this.calories;
    }

}
