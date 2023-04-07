package DataAccess;

import Models.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PaymentsDAO implements IPaymentsDAO {
    private final String paymentFilePath = "payments.json";
    private ArrayList<Payment> _payments;
    public PaymentsDAO() {
        _payments = new ArrayList();
        ReadFromFile();
    }

    public List<Payment> get_payments() {
        return _payments;
    }

    @Override
    public Optional<Payment> GetPaymentById(UUID paymentId) {
        return this._payments.stream().filter(x -> x.getId() == paymentId).findFirst();
    }

    @Override
    public UUID SavePayment(Payment payment) {
        if(null == payment.getId()) {
            payment.setId(UUID.randomUUID());
            this._payments.add(payment);
        }else {
            this._payments.stream().filter(x -> x.getId().equals(payment.getId())).findAny().map(x -> x.updateBy(payment));
        }
        SaveToFile();
        return payment.getId();
    }


    @Override
    public boolean ReadFromFile() {
        ObjectMapper paymentsMapper = new ObjectMapper();
        try {
            _payments = paymentsMapper.readValue(new File(paymentFilePath), _payments.getClass());
        } catch (IOException e) {
            System.out.println("Error on reading the payments from file.");
            return false;
        }
        return true;
    }

    @Override
    public boolean SaveToFile() {
        ObjectMapper paymentsMapper = new ObjectMapper();
        try {
            paymentsMapper.writeValue(new File(paymentFilePath), _payments);
        } catch (IOException e) {
            System.out.println("Error on saving payments to file.");
            return false;
        }
        return true;
    }

    @Override
    public void DeletePayment(Payment payment) {
        this._payments.removeIf(x -> x.getId() == payment.getId());
        SaveToFile();
    }
}
