package Symplifica.PruebaBackend.Services.impl;

import Symplifica.PruebaBackend.Entity.DTO.OrderDto;
import Symplifica.PruebaBackend.Entity.Order;
import Symplifica.PruebaBackend.Entity.Product;
import Symplifica.PruebaBackend.Repository.OrderRepository;
import Symplifica.PruebaBackend.Repository.ProductRepository;
import Symplifica.PruebaBackend.Services.OrderService;
import Symplifica.PruebaBackend.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public void generateOrder(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        Order order = new Order();
        order.setProduct(product);
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}

