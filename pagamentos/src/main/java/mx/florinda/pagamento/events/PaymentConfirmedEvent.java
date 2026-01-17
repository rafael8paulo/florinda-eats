package mx.florinda.pagamento.events;

import java.math.BigDecimal;

public class PaymentConfirmedEvent {

    public Long paymentId;
    public Long orderId;
    public BigDecimal value;

    public PaymentConfirmedEvent(Long paymentId, Long orderId, BigDecimal value) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.value = value;
    }

    @Override
    public String toString() {
        return "PaymentConfirmedEvent{" +
                "paymentId=" + paymentId +
                ", orderId=" + orderId +
                ", value=" + value +
                '}';
    }
}
