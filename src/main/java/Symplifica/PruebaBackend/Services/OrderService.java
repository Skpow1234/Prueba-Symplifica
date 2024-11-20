package Symplifica.PruebaBackend.Services;

import Symplifica.PruebaBackend.Entity.DTO.OrderDto;

import java.util.List;

public interface OrderService {
    void generateOrder(Integer productId);
    List<OrderDto> getOrders();
}

