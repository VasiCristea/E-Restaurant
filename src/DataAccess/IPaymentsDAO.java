package DataAccess;

import Models.Payment;

import java.util.Optional;
import java.util.UUID;

public interface IPaymentsDAO {
    Optional<Payment> GetPaymentById(UUID paymentId);
    UUID SavePayment(Payment payment);
    public boolean ReadFromFile();
    public boolean SaveToFile();
    void DeletePayment(Payment payment);
}
