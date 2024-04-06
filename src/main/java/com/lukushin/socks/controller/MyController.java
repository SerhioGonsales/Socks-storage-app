package com.lukushin.socks.controller;

import com.lukushin.socks.entity.Socks;
import com.lukushin.socks.exception_handling.InvalidRequestParameterException;
import com.lukushin.socks.service.SocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    SocksService service;

    @PostMapping("/socks/income")
    public void addOrUpdateSocks(@RequestBody Socks socks){
        if(socks.getValid()){
            service.saveOrUpdate(socks);
        } else {
            throw new InvalidRequestParameterException("Введены неверные параметры " +
                    "запроса на добавление");
        }
    }

    @PostMapping("/socks/outcome")
    public void deleteSocks(@RequestBody Socks socks){
        if(socks.getValid()){
            service.delete(socks);
        } else {
            throw new InvalidRequestParameterException("Введены неверные параметры " +
                    "запроса на удаление");
        }
    }

    @GetMapping("/socks")
    public int getCountOfSocksByParam(@RequestParam("color") String color,
                              @RequestParam("operation") String operation,
                              @RequestParam("cottonPart") int cottonPart){
         return service.getCountOfSocksByParam(color, operation, cottonPart);
    }
}
