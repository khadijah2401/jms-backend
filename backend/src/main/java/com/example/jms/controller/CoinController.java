package main.java.com.example.jms.controller;

import main.java.com.example.jms.model.CoinRequest;
import main.java.com.example.jms.model.CoinResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CoinController {

    private static final Logger logger = LoggerFactory.getLogger(CoinController.class);

    @PostMapping("/change")
    public ResponseEntity<?> calculateChange(@RequestBody CoinRequest request) {
        double target = request.getTargetAmount();
        List<Double> denominations = request.getDenominations();

        logger.info("Received request: targetAmount={}, denominations={}", target, denominations);

        // validate input
        if (target <= 0) {
            return ResponseEntity.badRequest().body("Target amount must be greater than 0.");
        }
        if (denominations == null || denominations.isEmpty()) {
            return ResponseEntity.badRequest().body("Denominations list cannot be empty.");
        }

        // sort denominations in descending order
        denominations.sort(Collections.reverseOrder());
        List<Double> result = new ArrayList<>();

        for (double coin : denominations) {
            while (Math.round(target * 100.0) >= Math.round(coin * 100.0)) {
                result.add(coin);
                target -= coin;
            }
        }

        // sort result in ascending order
        result.sort(Double::compare);
        return ResponseEntity.ok(new CoinResponse(result));
    }

    @GetMapping("/status")
    public String status() {
        return "API is up and running!!!";
    }
}
