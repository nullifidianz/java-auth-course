package com.nullifidianz.auth_course.mapper;

import org.springframework.stereotype.Component;

import com.nullifidianz.auth_course.dto.ProductRequest;
import com.nullifidianz.auth_course.dto.ProductResponse;
import com.nullifidianz.auth_course.model.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setProductValue(request.productValue());
        product.setQuantity(request.quantity());
        product.setObservation(request.observation());

        return product;
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getQuantity(), product.getProductValue(),
                product.getObservation());
    }
}
