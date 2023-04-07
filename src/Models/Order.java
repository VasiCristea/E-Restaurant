package Models;

import Enums.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID Id;
    private OrderStatus Status;
    private UUID EmployeeId;
    private Employee Employee;
    private UUID TableId;
    private Table Table;
    private List<Product> ProductsList = new ArrayList<>();

    public Order(OrderStatus status, Employee employee, Table table) {
        Status = status;
        Employee = employee;
        EmployeeId = employee.getId();
        Table = table;
        TableId = table.getId();
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public OrderStatus getStatus() {
        return Status;
    }
    public void setStatus(OrderStatus status) {
        Status = status;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee employee) {
        Employee = employee;
        EmployeeId = employee.getId();
    }

    public UUID getEmployeeId() {
        return EmployeeId;
    }

    public Table getTable() {
        return Table;
    }

    public void setTable(Table table) {
        Table = table;
        TableId = table.getId();
    }

    public UUID getTableId() {
        return TableId;
    }

    public void AddProduct(Product product) {
        this.ProductsList.add(product);
    }

    public void RemoveProduct(Product product) {
        this.ProductsList.remove(product);
    }

    public Order updateBy(Order order) {
        this.Id = order.Id;
        return this;
    }

    public void prepareForSaving() {
        this.Employee = null;
        this.Table = null;
    }

}
