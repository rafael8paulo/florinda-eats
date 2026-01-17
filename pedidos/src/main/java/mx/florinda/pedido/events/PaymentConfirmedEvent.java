package mx.florinda.pedido.events;

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
