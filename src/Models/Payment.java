package Models;

import Enums.Constants;
import Enums.PaymentTypes;
import Utils.Utils;

import java.util.UUID;

public class Payment {
    private UUID Id;
    private double Total;
    private PaymentTypes Type;

    public Payment() {
    }

    public Payment(double total, PaymentTypes type) {
        Total = total;
        Type = type;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public double getTotalVAT() {
        return Utils.totalWithTVA(Total);
    }

    public PaymentTypes getType() {
        return Type;
    }

    public void setType(PaymentTypes type) {
        Type = type;
    }

    public Payment updateBy(Payment payment) {
        this.Id = payment.Id;
        return this;
    }
}
