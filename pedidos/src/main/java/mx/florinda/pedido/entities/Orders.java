package mx.florinda.pedido.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import mx.florinda.pedido.entities.types.StatusOrder;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Orders extends PanacheEntity {

  public LocalDateTime createdAt;

  @Enumerated(EnumType.STRING)
  public StatusOrder status;

  @Embedded
  public Customer customer;

  @OneToMany(mappedBy = "order")
  public List<OrderItem> orderItems;

  @Override
  public String toString() {
    return "Pedido{" +
            "id=" + id +
            ", status=" + status +
            '}';
  }
}
