package Symplifica.PruebaBackend.Services;

import Symplifica.PruebaBackend.Entity.DTO.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    void addProduct(ProductDto productDto);
    void removeProduct(Integer productId);
}

