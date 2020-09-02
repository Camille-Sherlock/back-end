package domain;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
//@BusinessType(value = "acg", prefix = "3")
//@SQLDelete(sql = "UPDATE acg_order SET deleted = true WHERE id = ? AND version = ?")
public class goods {
private string name;
private int price;
private int number;
private string unit;
private string status;
}
