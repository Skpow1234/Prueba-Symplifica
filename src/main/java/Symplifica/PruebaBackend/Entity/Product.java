package Symplifica.PruebaBackend.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String price;
    private Integer currentStock;


}
