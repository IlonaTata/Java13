import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.ProductRepository;
import ru.netology.Smartphone;

public class ProductRepositoryTest {
    Product type1 = new Product(1, ":Жизнь", 200);
    Product type2 = new Book(2, ":Учеба", 300, "Акунин");
    Product type3 = new Smartphone(3, ":Телефон", 400, "Москва");


    @Test
    public void shouldSetId() {
        ProductRepository repo = new ProductRepository();
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.findAll();
        Product[] expected = {type1, type2, type3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSave() {
        ProductRepository repo = new ProductRepository();
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.findAll();
        Product[] expected = {type1, type2, type3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveById(){
        ProductRepository repo = new ProductRepository();
        repo.save(type1);
        repo.save(type2);
        repo.save(type3);
        repo.findAll();
        repo.removeById(2);
        Product[]expected={type1, type3};
        Product[]actual=repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

}