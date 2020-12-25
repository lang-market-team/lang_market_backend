package lang_market.backend.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @RequestMapping(path = "create")
//    @PostMapping
//    public Integer createNewOrder(@RequestBody Order order) {
//        return orderService.createNewOrder(order);
//    }

    @RequestMapping(path = "id_buyer={id_buyer}")
    @GetMapping
    public List<Order> getAllOrderOfBuyer(@PathVariable("id_buyer")Integer id_buyer) {
        return orderService.getAllOrderOfBuyer(id_buyer);
    }

    @RequestMapping(path = "id_order={id_order}")
    @GetMapping
    public List<OrderDetail> getDetailOfOrder(@PathVariable("id_order")Integer id_order) {
        return orderService.getDetailOfOrder(id_order);
    }

    @RequestMapping(path = "get_status_of_order/id_order={id_order}")
    @GetMapping
    public Order getStatusOfOrder(@PathVariable("id_order")Integer id_order) {
        return orderService.getStatusOfOrder(id_order);
    }

    @RequestMapping(path = "update_status_of_order")
    @PostMapping
    public Order getStatusOfOrder(@RequestBody Order order) {
        return orderService.updateStatusOfOrder(order);
    }
}
