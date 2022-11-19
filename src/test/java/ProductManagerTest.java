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
    Product type1 = new Product(1, ":Жизнь", 200);
    Product type2 = new Book(2, ":Жизнь", 300, "Акунин");
    Product type3 = new Smartphone(3, ":Телефон", 400, "Москва");


    @Test
    public void shouldSearchBy() {
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.findAll();
        manager.searchBy("Телефон");
        Product[] expected = {type3};
        Product[] actual = manager.searchBy("Телефон");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy1() {
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.findAll();
        manager.searchBy("Жизнь");
        Product[] expected = {type1,type2};
        Product[] actual = manager.searchBy("Жизнь");
        Assertions.assertArrayEquals(expected, actual);
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
        manager.matches(type2,"Жизнь");
        boolean expected = true;
        boolean actual = manager.matches(type2,"Жизнь");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatches1() {
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.findAll();
        manager.matches(type2,"А");
        boolean expected = false;
        boolean actual = manager.matches(type2,"А");
        Assertions.assertEquals(expected, actual);
    }



}



