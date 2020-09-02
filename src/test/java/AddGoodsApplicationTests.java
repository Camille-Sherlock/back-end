import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Order;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import repository.GoodsRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest()
class AddGoodsApplicationTests {
    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addGood() throws Exception {
        Order order = new Order();
        order.builder().name("可乐").number(1).price(1).status("add").unit(6);
        String request = objectMapper.writeValueAsString(order);

        mockMvc.perform(post("/addorder").content(request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        List<Order> orders = goodsRepository.findAll();
        assertEquals(1,orders.size());

    }

}
