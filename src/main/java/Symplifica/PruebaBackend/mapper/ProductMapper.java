package Symplifica.PruebaBackend.mapper;

import Symplifica.PruebaBackend.Entity.DTO.ProductDto;
import Symplifica.PruebaBackend.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCurrentStock(product.getCurrentStock());
        return dto;
    }

    public Product toEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCurrentStock(dto.getCurrentStock());
        return product;
    }
}

