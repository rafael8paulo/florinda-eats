-- tabela Orders
CREATE TABLE Orders (
    id BIGINT PRIMARY KEY,
    createdAt DATETIME NOT NULL,
    status ENUM('REALIZADO', 'PAGO', 'CONFIRMADO', 'PRONTO', 'SAIU_PRA_ENTREGA', 'ENTREGUE') NOT NULL,
    nameCustomer VARCHAR(100) NOT NULL,
    cpfCustomer VARCHAR(14) NOT NULL,
    phoneNumberCustomer VARCHAR(16) NOT NULL,
    addressCustomer VARCHAR(300) NOT NULL
);

CREATE TABLE Orders_SEQ (
    next_val BIGINT
);

-- tabela OrderItem
CREATE TABLE OrderItem (
    id BIGINT PRIMARY KEY,
    quantity BIGINT NOT NULL,
    unitPrice DECIMAL(9, 2) NOT NULL,
    observation VARCHAR(300),
    order_id BIGINT NOT NULL,
    menuitem_id BIGINT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders(id),
    FOREIGN KEY (menuitem_id) REFERENCES MenuItem(id)
);

CREATE TABLE OrderItem_SEQ (
    next_val BIGINT
);
