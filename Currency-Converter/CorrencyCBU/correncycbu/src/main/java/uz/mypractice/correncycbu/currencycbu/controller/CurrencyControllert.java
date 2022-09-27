package uz.mypractice.correncycbu.currencycbu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.mypractice.correncycbu.currencycbu.service.CurrencyService;

/**
 * @project: CurrencyCBUI
 * @Date: 27.09.2022
 * @author: H_Urunov
 **/
@RestController
@RequestMapping("/cbu")
public class CurrencyControllert {
    //
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/")
    public void getInfo(){

    }
}
