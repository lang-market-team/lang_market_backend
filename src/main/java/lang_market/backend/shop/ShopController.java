package lang_market.backend.shop;

import lang_market.backend.user.User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/shop")
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(path = "get/id_user={id_user}")
    @GetMapping
    public Shop getShopByIdUser(@PathVariable("id_user") Integer id_user) {
        return shopService.getShopByIdUser(id_user);
    }

    @RequestMapping(path = "get/id_product={id_product}")
    @GetMapping
    public Shop getShopByIdProduct(@PathVariable("id_product") Integer id_product) {
        return shopService.getShopByIdProduct(id_product);
    }

    @RequestMapping("update")
    @PostMapping
    public Shop updateShop(@RequestBody User user) {
        return  shopService.updateShop(user);
    }
}
