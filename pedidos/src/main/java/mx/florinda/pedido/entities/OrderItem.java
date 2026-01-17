package mx.florinda.pedido.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class OrderItem extends PanacheEntity {

  public Long quantity;
  public BigDecimal unitPrice;
  public String observation;

  @JsonIgnore
  @ManyToOne
  public Orders order;

  @ManyToOne
  public MenuItem menuItem;

}
