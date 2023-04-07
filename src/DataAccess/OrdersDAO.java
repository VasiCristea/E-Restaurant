package DataAccess;

import Models.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrdersDAO implements IOrdersDAO {
    private final String ordersFilePath = "orders.json";
    private ArrayList<Order> _orders;
    public OrdersDAO() {
        _orders = new ArrayList();
        ReadFromFile();
    }

    public List<Order> get_orders() {
        return _orders;
    }

    @Override
    public Optional<Order> GetOrderById(UUID orderId) {
        return this._orders.stream().filter(x -> x.getId() == orderId).findFirst();
    }

    @Override
    public UUID SaveOrder(Order order) {
        order.prepareForSaving();
      if(null == order.getId()) {
        order.setId(UUID.randomUUID());
        this._orders.add(order);
      }else {
          this._orders.stream().filter(x -> x.getId().equals(order.getId())).findAny().map(x -> x.updateBy(order));
      }
      SaveToFile();
      return order.getId();
    }


    @Override
    public boolean ReadFromFile() {
        ObjectMapper ordersMapper = new ObjectMapper();
        try {
            _orders = ordersMapper.readValue(new File(ordersFilePath), _orders.getClass());
        } catch (IOException e) {
            System.out.println("Error on reading the orders from file.");
            return false;
        }
        return true;
    }

    @Override
    public boolean SaveToFile() {
        ObjectMapper ordersMapper = new ObjectMapper();
        try {
            ordersMapper.writeValue(new File(ordersFilePath), _orders);
        } catch (IOException e) {
            System.out.println("Error on saving orders to file.");
            return false;
        }
        return true;
    }

    @Override
    public void DeleteOrder(Order order) {
        this._orders.removeIf(x -> x.getId() == order.getId());
        SaveToFile();
    }
}
