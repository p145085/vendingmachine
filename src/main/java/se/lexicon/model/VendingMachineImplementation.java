package se.lexicon.model;

public class VendingMachineImplementation implements VendingMachine {
    Product[] products;
    int depositPool;
    int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

    public VendingMachineImplementation(Product[] products) {
        this.products = products;
    }

    @Override
    public void addCurrency(int amount) {
        if (amount > 0) {
            for (int i = denominations.length - 1; i > 0; i--) {
                if (amount < denominations[i]) {
                    //System.out.println("DEBUG: Bill provided was not even with the denominations.");
                } else if (amount % denominations[i] == 0) {
                    depositPool = amount;
                }
            }
        } else {
            System.out.println("You can't add 0 or less.");
        }
    }

    @Override
    public int endSession() {
        int change = this.depositPool;
        this.depositPool = 0;

        return change;
    }

    @Override
    public int getBalance() {
        return this.depositPool;
    }

    @Override
    public Product request(int id) {
        Product product = null;

        for (Product element : products) {
            if (element.getId() == id) {
                product = element;
            }
        }

        if (product == null) {
            throw new IllegalArgumentException("Product does not exist.");
        }
        if (product.getPrice() > depositPool) {
            throw new IllegalArgumentException("You don't have enough money.");
        }

        depositPool -= product.getPrice();
        return product;
    }

    @Override
    public String getDescription(int id) {
        Product product = null;

        for (Product element : products) {
            if (element.getId() == id) {
                product = element;
            }
        }

        if (product == null) {
            throw new IllegalArgumentException("Product does not exist.");
        }

        return product.examine();
    }

    @Override
    public String[] getProducts() {
        String[] productsList = new String[this.products.length];

        for (int i = 0; i < productsList.length; i++) {
            productsList[i] = products[i].examine();
        }

        return productsList;
    }
}
