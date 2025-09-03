package com.nullifidianz.auth_course.Mapper;

import org.springframework.stereotype.Component;

import com.nullifidianz.auth_course.DTO.ProductRequest;
import com.nullifidianz.auth_course.DTO.ProductResponse;
import com.nullifidianz.auth_course.model.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setValue(request.value());
        product.setQuantity(request.quantity());
        product.setObservation(request.observation());

        return product;
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getQuantity(), product.getValue(),
                product.getObservation());
    }
}
