package ru.javamentor.ecommerce.models.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
}
