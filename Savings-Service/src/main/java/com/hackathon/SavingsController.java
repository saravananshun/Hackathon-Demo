package com.hackathon;

import com.hackathon.domain.Account;
import com.hackathon.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SavingsController {

	@Autowired
    AccountRepository accountRepository;


    @RequestMapping(value="/savings",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Account> accountsList(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        return (List<Account>)accountRepository.findAll();
    }

}
