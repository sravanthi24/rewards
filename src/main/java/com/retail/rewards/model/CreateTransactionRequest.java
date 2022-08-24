package com.retail.rewards.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTransactionRequest {

    private String phoneNumber;
    private String name;
    private Double billAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate transactionDate;
}
