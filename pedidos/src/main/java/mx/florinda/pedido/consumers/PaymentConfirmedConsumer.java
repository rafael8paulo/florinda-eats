package mx.florinda.pedido.consumers;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import mx.florinda.pedido.entities.Orders;
import mx.florinda.pedido.entities.types.StatusOrder;
import mx.florinda.pedido.events.PaymentConfirmedEvent;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PaymentConfirmedConsumer {

    @Incoming(Topics.CONFIRMED_PAYMENTS)
    public Uni<Void> consume(PaymentConfirmedEvent event) {
        return Panache.withTransaction(() ->
                        Orders.<Orders>findById(event.orderId).onItem().ifNotNull()
                                .invoke(order -> order.status = StatusOrder.PAGO))
                .replaceWithVoid();
    }

}
