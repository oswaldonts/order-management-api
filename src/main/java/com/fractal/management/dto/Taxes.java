package com.fractal.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taxes {
    private Double cityTax;
    private Double countyTax;
    private Double stateTax;
    private Double federalTax;

    @JsonIgnore
    public Double getTotalTaxes() {
        return this.cityTax + this.countyTax + this.stateTax + this.federalTax;
    }
}
