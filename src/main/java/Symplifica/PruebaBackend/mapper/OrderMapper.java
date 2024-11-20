package Symplifica.PruebaBackend.mapper;

import Symplifica.PruebaBackend.Entity.DTO.OrderDto;
import Symplifica.PruebaBackend.Entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDto toDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setProductId(order.getProduct().getId());
        dto.setProductName(order.getProduct().getName());
        dto.setProductPrice(order.getProduct().getPrice());
        return dto;
    }
}

