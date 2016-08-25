package com.hackathon;

import com.hackathon.domain.Account;
import com.hackathon.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@RestController
public class PaymentsController {

	@Autowired
    AccountRepository accountRepository;


    @RequestMapping(value="/payments",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Account> accountsList(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        return (List<Account>)accountRepository.findAll();
    }

}
