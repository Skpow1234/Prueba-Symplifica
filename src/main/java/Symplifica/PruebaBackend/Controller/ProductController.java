package Symplifica.PruebaBackend.Controller;

import Symplifica.PruebaBackend.Entity.DTO.ProductDto;
import Symplifica.PruebaBackend.Services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/add")
    public String addProductPage() {
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductDto productDto) {
        productService.addProduct(productDto);
        return "redirect:/products";
    }

    @PostMapping("/remove/{id}")
    public String removeProduct(@PathVariable Integer id) {
        productService.removeProduct(id);
        return "redirect:/products";
    }
}
