package com.nullifidianz.auth_course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nullifidianz.auth_course.DTO.ProductRequest;
import com.nullifidianz.auth_course.DTO.ProductResponse;
import com.nullifidianz.auth_course.Mapper.ProductMapper;
import com.nullifidianz.auth_course.model.Product;
import com.nullifidianz.auth_course.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequest request) {
        Product product = productMapper.toEntity(request);
        productRepository.save(product);
        return productMapper.toResponse(product);
    }

    public List<ProductResponse> listAll() {
        return productRepository.findAll().stream().map(productMapper::toResponse).toList();
    }

}
