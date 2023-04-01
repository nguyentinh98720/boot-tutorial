/**
 * 
 */
package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

/**
 * @created Mar 26, 2023
 *
 */
@Data
public class CarDto {

    @JsonProperty(access = Access.READ_ONLY)
    private Long id;

    private String name;

    private String description;

    private double price;

}
