package Symplifica.PruebaBackend.Services.impl;

import Symplifica.PruebaBackend.Entity.DTO.ProductDto;
import Symplifica.PruebaBackend.Entity.Product;
import Symplifica.PruebaBackend.Repository.ProductRepository;
import Symplifica.PruebaBackend.Services.ProductService;
import Symplifica.PruebaBackend.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);
    }

    @Override
    public void removeProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
