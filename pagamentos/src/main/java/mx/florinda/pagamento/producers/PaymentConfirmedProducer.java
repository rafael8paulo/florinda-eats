package mx.florinda.pagamento.producers;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mx.florinda.pagamento.events.PaymentConfirmedEvent;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class PaymentConfirmedProducer {

    @Inject
    @Channel(Topics.CONFIRMED_PAYMENTS)
    Emitter<PaymentConfirmedEvent> emitter;

    public void sendMessage(PaymentConfirmedEvent event) {
        Log.info("Sending confirmed payment confirmed message paymentId: " + event.paymentId);
        emitter.send(event);
    }
}
