package se.lexicon.model;

public class VendingMachineImplementation implements VendingMachine {
    Product[] products;
    int depositPool;
    int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

    //TO-DO: ENUM
    public enum denominations_SEK {
        SEK_1000(1000),
        SEK_500(500),
        SEK_200(200),
        SEK_100(100),
        SEK_50(50),
        SEK_20(20),
        SEK_10(10),
        SEK_5(5),
        SEK_2(2),
        SEK_1(1);

        private final int value;

        denominations_SEK(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    @Override
    public void addCurrency(int amount) {
        if (amount > 0) {
            for (denominations_SEK denomination : denominations_SEK.values()) {
                if (amount < denomination.value) {
                    System.out.println("nope");
                } else if (amount % denomination.value == 0) {
                    depositPool = amount;
                }
            }
        } else {
            System.out.println("You can't add 0 or less.");
        }
    }

    public VendingMachineImplementation(Product[] products) {
        this.products = products;
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
