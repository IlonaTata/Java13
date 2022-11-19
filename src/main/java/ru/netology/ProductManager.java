package ru.netology;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product type : repo.findAll()) {
            if (type.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = type;
                result = tmp;
            }
        }
        return result;
    }


}
