package se.lexicon.model;

public interface VendingMachine {
    public void addCurrency(int amount);

    public int getBalance();

    public Product request(int id);

    public int endSession();

    public String getDescription(int id);

    public String[] getProducts();

}
