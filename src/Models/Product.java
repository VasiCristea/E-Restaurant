package Models;

import Enums.ProductCategory;
import Enums.UnitOfMeasurment;

import java.util.UUID;

public class Product {
    private UUID Id;
    private String Name;
    private double Quantity;
    private double Price;
    private UnitOfMeasurment UOM;
    private ProductCategory Category;

    public Product() {
    }

    public Product(String name, double quantity, double price, UnitOfMeasurment UOM, ProductCategory category) {
        Name = name;
        Quantity = quantity;
        Price = price;
        this.UOM = UOM;
        Category = category;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public UnitOfMeasurment getUOM() {
        return UOM;
    }

    public void setUOM(UnitOfMeasurment UOM) {
        this.UOM = UOM;
    }

    public ProductCategory getCategory() {
        return Category;
    }

    public void setCategory(ProductCategory category) {
        Category = category;
    }

    public Product updateBy(Product product) {
        this.setId(product.getId());
        return this;
    }
}
