package ru.netology;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product type: repo.findAll()) {
            if (matches(type, text)) {
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
    public boolean matches(Product type, String search) {
        if (type.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}
