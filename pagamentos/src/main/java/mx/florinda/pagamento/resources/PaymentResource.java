package mx.florinda.pagamento.resources;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import mx.florinda.pagamento.entities.Payment;
import mx.florinda.pagamento.entities.types.PaymentStatus;
import mx.florinda.pagamento.events.PaymentConfirmedEvent;
import mx.florinda.pagamento.producers.PaymentConfirmedProducer;

import java.util.List;

@Path("/payments")
public class PaymentResource {

    @Inject
    PaymentConfirmedProducer paymentConfirmedProducer;

    @GET
    public Uni<List<Payment>> list() {
        return Payment.listAll();
    }

    @GET
    @Path("/{id}")
    public Uni<Payment> byId(Long id) {
        return Payment.findById(id);
    }

    @PUT
    @Path("/{id}")
    public Uni<Payment> confirm(Long id) {
        return Panache.withTransaction(() ->
                Payment.<Payment>findById(id)
                        .onItem().ifNotNull().invoke(payment -> {
                            payment.status = PaymentStatus.CONFIRMADO;
                            PaymentConfirmedEvent event = new PaymentConfirmedEvent(payment.id, payment.orderId, payment.value);
                            paymentConfirmedProducer.sendMessage(event);
                        }));
    }

}
