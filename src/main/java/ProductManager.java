import java.util.Arrays;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        Product[] tmp = new Product[0];
        for (Product product : repo.getProducts()) {
            if (matches(product, text)) {
                tmp = Arrays.copyOf(result, result.length + 1);
                tmp[tmp.length - 1] = product;
            }
        }
        result = tmp;
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

    public Product[] getRepo(){
        return repo.getProducts();
    }
}
