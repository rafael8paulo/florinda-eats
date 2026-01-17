package mx.florinda.notafiscal.services;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import mx.florinda.notafiscal.dtos.OrderDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.math.BigDecimal;

@Path("/orders")
@RegisterRestClient
public interface OrderService {

    @GET
    @Path("/{id}")
    Uni<OrderDto> getById(@PathParam("id") Long orderId);

    default Uni<String> invoice(Long orderId, BigDecimal value) {
        return getById(orderId).onItem().transform(pedido -> """
                <xml>
                  <valor>%s</valor>
                  <cliente>
                    <nome>%s</nome>
                    <cpf>%s</cpf>
                    <celular>%s</celular>
                    <endereco>%s</endereco>
                  </cliente>
                </xml>
                """.formatted(value, pedido.customer.name, pedido.customer.cpf, pedido.customer.phoneNumber, pedido.customer.address));
    }
}
