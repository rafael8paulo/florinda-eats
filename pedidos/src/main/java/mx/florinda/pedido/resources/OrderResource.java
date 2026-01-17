package mx.florinda.pedido.resources;

import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import mx.florinda.pedido.entities.Orders;

import java.util.List;

@Path("/orders")
public class OrderResource {

    @GET
    public Uni<List<Orders>> list() {
        return Orders.find("SELECT DISTINCT o FROM Orders o LEFT JOIN FETCH o.orderItems").list();
    }

    @GET
    @Path("/{id}")
    public Uni<Orders> byId(Long id) {
        return Orders.find("FROM Orders o LEFT JOIN FETCH o.orderItems WHERE o.id = :id", Parameters.with("id", id))
                .firstResult();
    }

}
