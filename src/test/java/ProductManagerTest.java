import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.ProductManager;
import ru.netology.Smartphone;

public class ProductManagerTest {
    ProductRepository repo= new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product type1 = new Product(1, "Жизнь", 200);
    Product type2 = new Book(2, "Счастье", 300, "Акунин");
    Product type3 = new Smartphone(3, "Телефон", 400, "Москва");
    Product type4 = new Book(4, "Рецепты", 500, "Толстой");
    Product type5 = new Product(5, "Картошка", 50);
    @Test
    public void shouldSearchBy() {
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.save(type4);
        repo.save(type5);
        repo.findAll();
        manager.searchBy("Картошка");
        Product[] expected = {type5};
        Product[] actual = manager.searchBy("Картошка");
      Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldSearchBy1() {
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.findAll();
        manager.searchBy("Жизнь");
        Product[] expected = {type1};
        Product[] actual = manager.searchBy("Жизнь");
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldSearchBy2() {
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.findAll();
        manager.searchBy("Она");
        Product[] expected = {};
        Product[] actual = manager.searchBy("Она");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatches() {
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.findAll();
        manager.searchBy("а");
        Product[] expected = {type3};
        Product[] actual = manager.searchBy("а");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldMatches1() {
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.findAll();
        manager.searchBy("Москва");
        Product[] expected = {type3};
        Product[] actual = manager.searchBy("Москва");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatches2() {
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.save(type4);
        repo.findAll();
        manager.searchBy("с");
        Product[] expected = {type3,type4};
        Product[] actual = manager.searchBy("с");
        Assertions.assertArrayEquals(expected, actual);
    }
}



