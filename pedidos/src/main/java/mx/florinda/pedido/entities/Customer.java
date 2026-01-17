package mx.florinda.pedido.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Customer {

    @Column(name = "nameCustomer")
    public String name;

    @Column(name = "cpfCustomer")
    public String cpf;

    @Column(name = "phoneNumberCustomer")
    public String phoneNumber;

    @Column(name = "addressCustomer")
    public String address;

}
