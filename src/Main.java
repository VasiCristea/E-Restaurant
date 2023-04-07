import Enums.*;
import Models.*;
import DataAccess.*;
import Views.Login;
import com.formdev.flatlaf.FlatDarkLaf;

public class Main {
    public static void main(String[] args) {
        FlatDarkLaf.setup();

        OrdersDAO ordersDAO = new OrdersDAO();
        Order order = new Order();
        ordersDAO.SaveOrder(order);

        EmployeesDAO employeesDAO = new EmployeesDAO();
        employeesDAO.SaveEmployee(new Employee("vasi", "cristea", EmployeeRole.Manager));

        PaymentsDAO paymentsDAO = new PaymentsDAO();
        Payment payment = new Payment(300, PaymentTypes.Cash);
        paymentsDAO.SavePayment(payment);

        ProductsDAO productsDAO = new ProductsDAO();
        productsDAO.SaveProduct(new Product("Steak vita", 250, 50, UnitOfMeasurment.g, ProductCategory.Steak));

        LocalDAO localDao = new LocalDAO();
        Local local = new Local(LocalTypes.Bar, "Vasi's", "Giani Orlando SRL", "Micsunelelor 8");
        localDao.SaveLocal(local);

        TablesDAO tablesDAO = new TablesDAO();
        tablesDAO.SaveTable(new Table(TableStatus.Free, 1));

        ReceiptsDAO receiptsDAO = new ReceiptsDAO();
        Receipt receipt = new Receipt(order, local, payment);
        receiptsDAO.SaveReceipt(receipt);

        new Login();

    }
}