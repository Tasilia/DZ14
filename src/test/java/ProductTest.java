import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product product = new Product();
    @Test
    public void shouldSetId(){
        Product product = new Product();
        int expected = 3;
        product.setId(expected);
        int actual = product.getId();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetPrice(){
        Product product = new Product();
        int expected = 1000;
        product.setPrice(expected);
        int actual = product.getPrice();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetName(){
        Product product = new Product();
        String expected = "Пиво";
        product.setName(expected);
        String actual = product.getName();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetManufacturer(){
        Smartphone smartphone = new Smartphone();
        String expected = "Samsung";
        smartphone.setManufacturer(expected);
        String actual = smartphone.getManufacturer();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetAuthor(){
        Book book = new Book();
        String expected = "Есенин";
        book.setAuthor(expected);
        String actual = book.getAuthor();
        Assertions.assertEquals(expected, actual);
    }
}
