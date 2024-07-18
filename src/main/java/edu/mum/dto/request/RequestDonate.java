package edu.mum.dto.request;


import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class RequestDonate {
    private Long amount;
    private String description;
    @Pattern(regexp = "^(VNPay|Paypal)$", message = "Invalid payment method. Allowed values are 'VNPay' or 'Paypal'")
    private String paymentMethod;
    private Long programId;
}
