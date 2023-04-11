import Enums.*;
import Models.*;
import DataAccess.*;
import Views.AddWaiter;
import Views.Login;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup();
//
//        EmployeesDAO employeesDAO = new EmployeesDAO();
//        Employee employee = new Employee("vasi", "cristea", EmployeeRole.Manager);
//        employeesDAO.SaveEmployee(employee);
//
//        PaymentsDAO paymentsDAO = new PaymentsDAO();
//        Payment payment = new Payment(300, PaymentTypes.Cash);
//        paymentsDAO.SavePayment(payment);
//
//        ProductsDAO productsDAO = new ProductsDAO();
//        productsDAO.SaveProduct(new Product("Steak vita", 250, 50, UnitOfMeasurment.g, ProductCategory.Steak));
//
//        LocalDAO localDao = new LocalDAO();
//        Local local = new Local(LocalTypes.Bar, "Vasi's", "Giani Orlando SRL", "Micsunelelor 8");
//        localDao.SaveLocal(local);
//
//        TablesDAO tablesDAO = new TablesDAO();
//        Table table = new Table(TableStatus.Free, 1);
//        tablesDAO.SaveTable(table);
//
//        OrdersDAO ordersDAO = new OrdersDAO();
//        Order order = new Order(OrderStatus.Closed, employee, table);
//        ordersDAO.SaveOrder(order);
//
//        ReceiptsDAO receiptsDAO = new ReceiptsDAO();
//        Receipt receipt = new Receipt(order, local, payment);
//        receiptsDAO.SaveReceipt(receipt);


        new AddWaiter();
        new Login();

    }
}