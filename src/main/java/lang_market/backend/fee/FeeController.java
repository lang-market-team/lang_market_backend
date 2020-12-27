package lang_market.backend.fee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/fee")
public class FeeController {
    private final FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    @RequestMapping("paid")
    @GetMapping
    public List<Fee> getAllPaidFee() {
        return feeService.getAllPaidFee();
    }

    @RequestMapping("unpaid")
    @GetMapping
    public List<Fee> getAllUnpaidFee() {
        return feeService.getAllUnpaidFee();
    }

    @RequestMapping("paid/id_seller={id_seller}")
    @GetMapping
    public  List<Fee> getAllPaidFeeOfSeller(@PathVariable("id_seller") Integer id_seller) {
        return feeService.getAllPaidFeeOfSeller(id_seller);
    }

    @RequestMapping("unpaid/id_seller={id_seller}")
    @GetMapping
    public  List<Fee> getAllUnpaidFeeOfSeller(@PathVariable("id_seller") Integer id_seller) {
        return feeService.getAllUnpaidFeeOfSeller(id_seller);
    }

    @RequestMapping("create")
    @PostMapping
    public Integer createNewFee(@RequestBody Fee fee) {
        return feeService.createNewFee(fee);
    }

    @RequestMapping("pay")
    @PostMapping
    public Integer payFeeForMonth(@RequestBody Fee fee) {
        return feeService.payFeeForMonth(fee);
    }
}
