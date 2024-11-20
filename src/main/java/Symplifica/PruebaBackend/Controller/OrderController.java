package Symplifica.PruebaBackend.Controller;

import Symplifica.PruebaBackend.Services.OrderService;
import Symplifica.PruebaBackend.Services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getOrders());
        model.addAttribute("products", productService.getAllProducts()); // Carga los productos para el formulario
        return "orders";
    }

    @PostMapping("/generate")
    public String generateOrder(@RequestParam(required = false) Integer productId, Model model) {
        if (productId == null) {
            model.addAttribute("errorMessage", "Product ID is required to generate an order.");
            model.addAttribute("orders", orderService.getOrders());
            model.addAttribute("products", productService.getAllProducts());
            return "orders";
        }
        orderService.generateOrder(productId);
        return "redirect:/orders";
    }
}
