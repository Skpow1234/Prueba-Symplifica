package Symplifica.PruebaBackend.Controller;

import Symplifica.PruebaBackend.Services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getOrders());
        return "orders";
    }

    @PostMapping("/generate")
    public String generateOrder(@RequestParam Integer productId) {
        orderService.generateOrder(productId);
        return "redirect:/orders";
    }
}

