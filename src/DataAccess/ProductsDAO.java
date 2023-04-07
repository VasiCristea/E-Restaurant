package DataAccess;

import Models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductsDAO implements IProductsDAO {
    private final String productFilePath = "products.json";
    private ArrayList<Product> _products;
    public ProductsDAO() {
        _products = new ArrayList();
        ReadFromFile();
    }

    public List<Product> get_products() {
        return _products;
    }

    @Override
    public Optional<Product> GetProductById(UUID productId) {
        return this._products.stream().filter(x -> x.getId() == productId).findFirst();
    }

    @Override
    public UUID SaveProduct(Product product) {
        if(null == product.getId()) {
            product.setId(UUID.randomUUID());
            this._products.add(product);
        }else {
            this._products.stream().filter(x -> x.getId().equals(product.getId())).findAny().map(x -> x.updateBy(product));
        }
        SaveToFile();
        return product.getId();
    }


    @Override
    public boolean ReadFromFile() {
        ObjectMapper productsMapper = new ObjectMapper();
        try {
            _products = productsMapper.readValue(new File(productFilePath), _products.getClass());
        } catch (IOException e) {
            System.out.println("Error on reading the products from file.");
            return false;
        }
        return true;
    }

    @Override
    public boolean SaveToFile() {
        ObjectMapper productsMapper = new ObjectMapper();
        try {
            productsMapper.writeValue(new File(productFilePath), _products);
        } catch (IOException e) {
            System.out.println("Error on saving products to file.");
            return false;
        }
        return true;
    }

    @Override
    public void DeleteProduct(Product product) {
        this._products.removeIf(x -> x.getId() == product.getId());
        SaveToFile();
    }
}
