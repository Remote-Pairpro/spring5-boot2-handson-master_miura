package com.example.web.controller;

import com.example.persistence.entity.Customer;
import com.example.service.CustomerService;
import com.example.web.form.CustomerForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    /** 必要があれば、デバッグ時のログ出力に使ってください */
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    /**
     * 社員一覧画面に遷移するコントローラーメソッド。
     */
    @GetMapping("/")
    public String index(Model model) {
        Iterable<Customer> customers =  service.findAll();
        model.addAttribute("customers" , customers);
        //  src/main/resources/templates/index.htmlに遷移する
        return "index";
    }

    /**
     * 社員追加画面に遷移するコントローラーメソッド。
     */
    @GetMapping("/insertMain")
    public String insertMain(Model model) {
        // フィールドが全てnullのフォームインスタンスを追加する
        model.addAttribute(CustomerForm.createEmptyForm());
        // src/main/resources/templates/insertMain.htmlに遷移している
        return "insertMain";
    }

    /**
     * 社員の追加を行うコントローラーメソッド。
     */
    @PostMapping("/insertComplete")
    public String insertComplete(
               @Validated CustomerForm customerForm,
               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "insertMain";
        // フォームをエンティティに変換
        Customer customer = customerForm.convertToEntity();
        // 顧客をDBに追加する
        service.save(customer);
        // 「/」にリダイレクト
        return "redirect:/";
    }
}
