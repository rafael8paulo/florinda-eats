package mx.florinda.pagamento.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import mx.florinda.pagamento.entities.types.PaymentStatus;

import java.math.BigDecimal;

@Entity
public class Payment extends PanacheEntity {

    public BigDecimal value;

    @Enumerated(EnumType.STRING)
    public PaymentStatus status;

    public Long orderId;

    @Override
    public String toString() {
        return "Payment{" +
                "value=" + value +
                ", status=" + status +
                ", orderId=" + orderId +
                '}';
    }
}
