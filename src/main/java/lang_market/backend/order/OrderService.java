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

    public Order createNewOrder(OrderFull orderFull) {
        return orderRepository.createNewOrder(orderFull.getOrder(), orderFull.getOrderDetailList());
    }

    public List<Order> getAllOrderOfBuyer(Integer id_buyer) {
        return orderRepository.getAllOrderOfBuyer(id_buyer);
    }

    public List<Order> getAllOrderOfSeller(Integer id_seller) {
        return orderRepository.getAllOrderOfSeller(id_seller);
    }

    public List<OrderDetail> getDetailOfOrder(Integer id_order) {
        return orderRepository.getDetailOfOrder(id_order);
    }

    public Order getInformationOfOrder(Integer id_order) {
        return orderRepository.getInformationOfOrder(id_order);
    }

    public Order updateStatusOfOrder(Order order) {
        return orderRepository.updateStatusOfOrder(order.getId_order(), order.getStatus_order());
    }

    public Order updateDeliveryTimeOfOrder(Order order) {
        return orderRepository.updateDeliveryTimeOfOrder(order.getId_order(), order.getDelivery_time());
    }
}
