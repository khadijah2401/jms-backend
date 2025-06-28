package main.java.com.example.jms.controller;

import main.java.com.example.jms.model.CoinRequest;
import main.java.com.example.jms.model.CoinResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*") // OR use "http://localhost:3000"
@RestController
@RequestMapping("/api")
public class CoinController {

    @PostMapping("/change")
    public CoinResponse calculateChange(@RequestBody CoinRequest request) {
        double target = request.getTargetAmount();
        List<Double> denominations = request.getDenominations();

        // Sort in descending order to apply greedy
        denominations.sort(Collections.reverseOrder());
        List<Double> result = new ArrayList<>();

        for (double coin : denominations) {
            while (Math.round(target * 100.0) >= Math.round(coin * 100.0)) {
                result.add(coin);
                target -= coin;
            }
        }

        // Sort final result in ascending order
        result.sort(Double::compare);
        return new CoinResponse(result);
    }
}