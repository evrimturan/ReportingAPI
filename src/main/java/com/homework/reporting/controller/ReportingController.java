package com.homework.reporting.controller;

import com.homework.reporting.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class ReportingController {

    private ReportingService reportingService;

    @Autowired
    public ReportingController(ReportingService reportingService){
        this.reportingService = reportingService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"}, path = "/isEven")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    HashMap<String, String> isEvenController(@RequestParam("x") int x){
        return new HashMap<String, String >(){
            {
                super.put("result", String.valueOf(reportingService.isEven(x)));
            }
        };
    }

    /* @RequestMapping(method = RequestMethod.GET, produces = {"application/json"}, path = "/carts")
    public @ResponseBody
    Cart getCart(@RequestParam("cartId") long cartId){
        Cart cart = reportingService.getCart(cartId);
        System.out.println(cart);
        return cart;
    } */
}
