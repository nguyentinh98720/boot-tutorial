/**
 * 
 */
package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * @created Mar 26, 2023
 *
 */
public class CarDto {

    /*
     * TODO - Tìm hiểu về Jackson và cách sử dụng
     */
    @JsonProperty(access = Access.READ_ONLY)
    private Long id;

    private String name;

    private String description;

    private double price;

    /*
     * TODO - use lombok
     * Đang phải dùng setter, getter lặp lại nhiều lần
     * --> Tìm hiểu và áp dụng lombok
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
