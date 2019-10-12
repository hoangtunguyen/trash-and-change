package com.example.trashandchange.controller;

import com.example.trashandchange.convert.StoreConvert;
import com.example.trashandchange.response.StoreResponse;
import com.example.trashandchange.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    GeneralService generalService;

    @RequestMapping(value = "/")
    public String home(Model model){
        List<StoreResponse> list = generalService.getAllStores().stream().map(StoreConvert::convert).collect(Collectors.toList());
        model.addAttribute("listStores",list);
        return "main/home";
    }

    @RequestMapping(value = "/detailStore")
    public String getOne(@RequestParam(value="id", required=true) int id, Model model){
        StoreResponse storeResponse = new StoreResponse();
        storeResponse = StoreConvert.convert(generalService.getStoreById(id));
        model.addAttribute("store",storeResponse);
        return "main/detailStore";
    }
    @RequestMapping(value = "/user")
    public String getUser(@RequestParam(value="id", required=true) int id){
        return "main/userInfor";

    }
    @RequestMapping(value = "/searchAll")
    public String findStore(@RequestParam(value="search", required=true) String search, Model model){
        List<StoreResponse> list = generalService.searchStores(search).stream().map(StoreConvert::convert).collect(Collectors.toList());
        model.addAttribute("listStores",list);

        return "main/home";
    }




    @RequestMapping("/products")
    public String products() {
        return "products";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
