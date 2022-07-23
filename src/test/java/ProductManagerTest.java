import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product = new Product(1, "Стол", 5000);
    Book book = new Book(2, "Книга", 1000, "Есенин");
    Smartphone smartphone = new Smartphone(3, "Телефон", 50000, "Samsung");
    @Test
    public void shouldAdd(){
        manager.add(product);
        manager.add(book);
        manager.add(smartphone);
        Product[] expected = {product, book, smartphone};
        Product[] actual = manager.getRepo();
        Assertions.assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldSearch(){
        manager.add(product);
        manager.add(book);
        manager.add(smartphone);
        Product[] expected = {book};
        Product[] actual = manager.searchBy("Книга");
        Assertions.assertArrayEquals(actual, expected);
    }
}
