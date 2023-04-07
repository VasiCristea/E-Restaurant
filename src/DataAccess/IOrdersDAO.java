package DataAccess;

import Models.Order;

import java.util.Optional;
import java.util.UUID;

public interface IOrdersDAO {
    public Optional<Order> GetOrderById(UUID orderId);
    public UUID SaveOrder(Order order);
    public boolean ReadFromFile();
    public boolean SaveToFile();
    public void DeleteOrder(Order order);
}
