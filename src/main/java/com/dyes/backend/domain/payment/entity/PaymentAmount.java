package com.dyes.backend.domain.payment.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PaymentAmount {
    private int total;
    private int tax_free;
    private int tax;
    private int point;
    private int discount;
}
