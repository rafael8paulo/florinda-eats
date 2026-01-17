package mx.florinda.notafiscal.consumers;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import mx.florinda.notafiscal.events.PaymentConfirmedEvent;
import mx.florinda.notafiscal.services.OrderService;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;

@ApplicationScoped
public class PaymentConfirmedConsumer {

    @RestClient
    OrderService orderService;

    @Incoming(Topics.ISSUE_INVOICE)
    public Uni<Void> consume(PaymentConfirmedEvent event) {
        Log.info("Incoming PaymentConfirmedEvent paymentId: " + event.paymentId);

        return orderService.invoice(event.orderId, new BigDecimal("9.99"))
                .invoke(invoice -> Log.info("Incoming PaymentConfirmedEvent invoice: " + invoice))
                .replaceWithVoid();
    }


}
