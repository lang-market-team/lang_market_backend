package lang_market.backend.fee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {
    private final FeeRepository feeRepository;

    @Autowired
    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    public List<Fee> getAllPaidFee() {
        return feeRepository.getAllPaidFee();
    }

    public List<Fee> getAllUnpaidFee() {
        return feeRepository.getAllUnpaidFee();
    }

    public List<Fee> getAllPaidFeeOfSeller(Integer id_seller) {
        return feeRepository.getAllPaidFeeOfSeller(id_seller);
    }

    public List<Fee> getAllUnpaidFeeOfSeller(Integer id_seller) {
        return feeRepository.getAllUnpaidFeeOfSeller(id_seller);
    }

    public Integer createNewFee(Fee fee) {
        return feeRepository.createNewFee(fee.getMonth_fee(), fee.getFee(), fee.getId_order(), fee.getId_seller());
    }

    public Integer payFeeForMonth(Fee fee) {
        return feeRepository.payFeeForMonth(fee.getMonth_fee(), fee.getId_seller());
    }
}
