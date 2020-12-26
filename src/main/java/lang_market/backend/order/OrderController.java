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

    @RequestMapping(path = "create")
    @PostMapping
    public Order createNewOrder(@RequestBody OrderFull orderFull) {
        return orderService.createNewOrder(orderFull);
    }

    @RequestMapping(path = "id_buyer={id_buyer}")
    @GetMapping
    public List<Order> getAllOrderOfBuyer(@PathVariable("id_buyer")Integer id_buyer) {
        return orderService.getAllOrderOfBuyer(id_buyer);
    }

    @RequestMapping(path = "id_seller={id_seller}")
    @GetMapping
    public List<Order> getAllOrderOfSeller(@PathVariable("id_seller")Integer id_seller) {
        return orderService.getAllOrderOfSeller(id_seller);
    }

    @RequestMapping(path = "id_order={id_order}")
    @GetMapping
    public List<OrderDetail> getDetailOfOrder(@PathVariable("id_order")Integer id_order) {
        return orderService.getDetailOfOrder(id_order);
    }

    @RequestMapping(path = "get_information_of_order/id_order={id_order}")
    @GetMapping
    public Order getInformationOfOrder(@PathVariable("id_order")Integer id_order) {
        return orderService.getInformationOfOrder(id_order);
    }

    @RequestMapping(path = "update_status_of_order")
    @PostMapping
    public Order updateStatusOfOrder(@RequestBody Order order) {
        return orderService.updateStatusOfOrder(order);
    }

    @RequestMapping(path = "update_delivery_time_of_order")
    @PostMapping
    public Order updateDeliveryTimeOfOrder(@RequestBody Order order) {
        return orderService.updateDeliveryTimeOfOrder(order);
    }
}
