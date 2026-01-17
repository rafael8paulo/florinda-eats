package mx.florinda.pagamento.producers;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mx.florinda.pagamento.events.PaymentConfirmedEvent;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class IssueInvoiceProducer {

    @Inject
    @Channel(Topics.ISSUE_INVOICE)
    Emitter<PaymentConfirmedEvent> emitter;

    public void sendMessage(PaymentConfirmedEvent event) {
        Log.info("Sending message issue invoice paymentId: " + event.paymentId);
        emitter.send(event);
    }
}
