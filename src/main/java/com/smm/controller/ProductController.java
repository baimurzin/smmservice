package com.smm.controller;

import com.smm.model.ServiceGroup;
import com.smm.repository.ServiceGroupRepository;
import com.smm.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {


    private final ProductService productService;

    private final ServiceGroupRepository serviceGroupRepository;

    @GetMapping("dev/products/pull")
    public ResponseEntity pullProducts(){
        productService.updateProducts();
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<ServiceGroup> serviceGroups = serviceGroupRepository.getAllNamesAndId();
        model.addAttribute("groups", serviceGroups);
        return "index";
    }
}
