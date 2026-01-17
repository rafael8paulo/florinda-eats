package mx.florinda.notafiscal.events;

public class PaymentConfirmedEvent {
    public Long paymentId;
    public Long orderId;

    @Override
    public String toString() {
        return "PaymentConfirmedEvent{" +
                "paymentId=" + paymentId +
                ", orderId=" + orderId +
                '}';
    }
}
