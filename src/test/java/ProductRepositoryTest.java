import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product product = new Product(1, "Стол", 5000);
    Book book = new Book(2, "Книга", 1000, "Есенин");
    Smartphone smartphone = new Smartphone(3, "Телефон", 50000, "Samsung");

    @Test
    public void shouldSaveProduct() {
        repo.save(product);
        repo.save(book);
        repo.save(smartphone);
        Product[] expected = {product, book, smartphone};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemove() {
        repo.save(product);
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(3);
        Product[] expected = {product, book};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldThrowNotFoundException(){
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);
        });
    }

    @Test
    public void shouldThrowAlreadyExistException(){
        repo.save(product);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(product);;
        });
    }
}
