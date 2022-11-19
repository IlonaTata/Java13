package ru.netology;

public class ProductRepository {
    private Product[] types = new Product[0];

    public void save(Product type) {
        Product[] tmp = new Product[types.length + 1];
        for (int i = 0; i < types.length; i++) {
            tmp[i] = types[i];
        }
        tmp[tmp.length - 1] = type;
        types = tmp;
    }
    public  Product[] findAll() {
        return types;
    }
   public void removeById(int id) {
       Product[] tmp = new Product[types.length - 1];
       int copyToIndex = 0;
       for (Product type : types) {
           if (type.getId() != id) {
               tmp[copyToIndex] = type;
               copyToIndex++;
            }
       }
       types = tmp;
    }


}
