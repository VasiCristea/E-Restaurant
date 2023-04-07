package Models;

import java.util.UUID;

public class Receipt {
    private UUID Id;
    private UUID OrderId;
    private Order Order;
    private UUID LocalId;
    private Local Local;
    private  UUID PaymentId;
    private Payment Payment;

    public Receipt() {
    }

    public Receipt(Order order, Local local, Payment payment) {
        Order = order;
        OrderId = order.getId();
        Local = local;
        LocalId = local.getId();
        Payment = payment;
        PaymentId = payment.getId();
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public Order getOrder() {
        return Order;
    }

    public void setOrder(Order order) {
        Order = order;
        OrderId = order.getId();
    }

    public Local getLocal() {
        return Local;
    }

    public void setLocal(Local local) {
        Local = local;
        LocalId = local.getId();
    }

    public Payment getPayment() {
        return Payment;
    }

    public void setPayment(Payment payment) {
        Payment = payment;
        PaymentId = payment.getId();
    }

    public Receipt updateBy(Receipt receipt) {
        this.setId(receipt.getId());
        return this;
    }

    public UUID getOrderId() {
        return OrderId;
    }

    public UUID getLocalId() {
        return LocalId;
    }

    public UUID getPaymentId() {
        return PaymentId;
    }

    public void prepareForSaving() {
        this.Order = null;
        this.Payment = null;
        this.Local = null;
    }

}
