package com.nullifidianz.auth_course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nullifidianz.auth_course.dto.ProductRequest;
import com.nullifidianz.auth_course.dto.ProductResponse;
import com.nullifidianz.auth_course.mapper.ProductMapper;
import com.nullifidianz.auth_course.model.Product;
import com.nullifidianz.auth_course.model.exception.ResourceNotFoundException;
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

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return productMapper.toResponse(product);

    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        if (request.name() != null && !request.name().isBlank()) {
            product.setName(request.name());
        }

        if (request.quantity() != null) {
            product.setQuantity(request.quantity());
        }

        if (request.value() != null) {
            product.setProductValue(request.value());
        }

        if (request.observation() != null && !request.observation().isBlank()) {
            product.setObservation(request.observation());
        }

        productRepository.save(product);
        return productMapper.toResponse(product);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(product);
    }

}
