package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
//@BusinessType(value = "acg", prefix = "3")
//@SQLDelete(sql = "UPDATE acg_order SET deleted = true WHERE id = ? AND version = ?")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int price;
    private int number;
    private int unit;
    private String status;
}
