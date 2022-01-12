package se.lexicon.model;

public class Kaffe extends Product {

    private boolean ljummet;

    public Kaffe(int id, double price, String productName, boolean ljummet) {
        setId(id);
        setPrice(price);
        setProductName(productName);
        setLjummet(ljummet);
    }

    public String examine() {
        String toString;

        toString = getProductName() + " " + getId() + " " + getPrice() + " " + isLjummet();

        return toString;
    }

    public String use() {
        return "You drink the " + this.getProductName();
    }

    public boolean isLjummet() {
        return ljummet;
    }

    public void setLjummet(boolean ljummet) {
        this.ljummet = ljummet;
    }
}
