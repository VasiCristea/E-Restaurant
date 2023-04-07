package DataAccess;

import Models.Product;

import java.util.Optional;
import java.util.UUID;

public interface IProductsDAO {
    Optional<Product> GetProductById(UUID productId);
    UUID SaveProduct(Product product);
    boolean ReadFromFile();
    boolean SaveToFile();
    void DeleteProduct(Product product);
}
