package lang_market.backend.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Integer createNewOrder(Order order) {
        return orderRepository.createNewOrder(order.getTotal_price(), order.getCreate_time(), order.getDelivery_address(), order.getId_buyer());
    }

    public List<Order> getAllOrderOfBuyer(Integer id_buyer) {
        return orderRepository.getAllOrderOfBuyer(id_buyer);
    }

    public List<OrderDetail> getDetailOfOrder(Integer id_order) {
        return orderRepository.getDetailOfOrder(id_order);
    }

    public Order getStatusOfOrder(Integer id_order) {
        return orderRepository.getStatusOfOrder(id_order);
    }

    public Order updateStatusOfOrder(Order order) {
        return orderRepository.updateStatusOfOrder(order.getId_order(), order.getStatus_order());
    }
}
