package se.lexicon.model;

public class Ramlösa extends Product {

    private boolean avslagen;

    public Ramlösa(int id, double price, String productName, boolean avslagen) {
        setId(id);
        setPrice(price);
        setProductName(productName);
        setAvslagen(avslagen);
    }

    public String examine() {
        String toString;

        toString = getProductName() + " " + getId() + " " + getPrice() + " " + isAvslagen();

        return toString;
    }

    public String use() {
        return "You drink the " + this.getProductName();
    }

    public boolean isAvslagen() {
        return avslagen;
    }

    public void setAvslagen(boolean avslagen) {
        this.avslagen = avslagen;
    }
}
