package lang_market.backend.shop;

import lang_market.backend.user.User;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop getShopByIdUser(Integer id_user) {
        return shopRepository.getShopByIdUser(id_user);
    }

    public Shop getShopByIdProduct(Integer id_product) {
        return shopRepository.getShopByIdProduct(id_product);
    }

    public Shop updateShop(User user) {
        return shopRepository.updateShop(user.getId_user(), user.getShop_name(), user.getShop_describe());
    }
}
