package mx.florinda.notafiscal.dtos;

import java.time.LocalDateTime;

public class OrderDto {

    public Long id;

    public LocalDateTime dateTime;

    public String status;

    public CustomerDto customer;

}
