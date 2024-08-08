package com.claire.tlclabs.controllers;

import com.claire.tlclabs.entities.Order;
import com.claire.tlclabs.entities.OrderBook;
import com.claire.tlclabs.entities.ProductData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/claire")
@CrossOrigin
public class ClaireController {

    private RestTemplate restTemplate;
    private final String exchange1 = "https://exchange.matraining.com";
    private final String privateApiKey = "f6189ff6-5633-414f-9c67-1befbab8e6fd";

    public ClaireController() {
        restTemplate = new RestTemplate();
    }

    @GetMapping("/getProductData")
    public List<ProductData> getProductData() {
        ResponseEntity<ProductData[]> response = restTemplate
                .getForEntity(exchange1 + "/pd",
                        ProductData[].class);

        List<ProductData> result = Arrays.asList(response.getBody());

        System.out.println("!!!! Got product data !!!!!");
        System.out.println(result);

        return result;
    }

    @GetMapping("/getOrderBook/{ticker}")
    public void getOrderBook(@PathVariable String ticker) {
        ResponseEntity<OrderBook[]> response = restTemplate
                .getForEntity(exchange1 + "/orderbook/" + ticker.toUpperCase(),
                        OrderBook[].class);

        List<OrderBook> result = Arrays.asList(response.getBody());

        System.out.println("!!!! Data from exchange!!!!!");
        System.out.println(result);

        //alternative way of sending..
        /*var responseTwo = restTemplate.exchange(exchange1 + "/orderbook/" + ticker.toUpperCase(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderBook>>() {});

        List<OrderBook> resultTwo = responseTwo.getBody();*/
    }

    @PostMapping("/sendOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendOrder(@RequestBody Order order) {
        String urlToPostTo = exchange1 + "/" + privateApiKey + "/order";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Order> request = new HttpEntity<>(order, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                urlToPostTo,
                HttpMethod.POST,
                request,
                String.class);

        System.out.println("!! sent order to exchange - got response!!");
        System.out.println("Order id:" + response.getBody());

        //String response2 = restTemplate.postForObject(urlToPostTo, request, String.class);
    }

}
