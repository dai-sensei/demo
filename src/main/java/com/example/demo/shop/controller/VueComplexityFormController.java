package com.example.demo.shop.controller;

import com.example.demo.common.json.SerializerJson;
import com.example.demo.shop.dto.DataDto;
import com.example.demo.shop.dto.Item;
import com.example.demo.shop.dto.ItemDetail;
import com.example.demo.shop.dto.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
public class VueComplexityFormController {

  @GetMapping("/shop")
  public String homePage(Model model) {
    // 確認用のDTO作成
    DataDto dataDto = new DataDto();
    dataDto.setShop(new Shop("検証用の店名"));
    dataDto.setItemList(
        Arrays.asList(
            new Item(1,"商品名1",
                new ItemDetail(100,10),true),
            new Item(2,"商品名2",
                new ItemDetail(200,20),true),
            new Item(3,"商品名3",
                new ItemDetail(300,30),true),
            new Item(4,"商品名4",
                new ItemDetail(400,40),true),
            new Item(5,"商品名5",
                new ItemDetail(500,50),true)
        )
    );
    model.addAttribute("shopData",
        SerializerJson.serializeJson(dataDto));
    return "shop/FormView";
  }

  @PostMapping("/shop/add")
  public String itemAdd(@ModelAttribute DataDto dataDto, BindingResult result, Model model) {
    System.out.println("マッピングError検証："+result.hasErrors());
    model.addAttribute("shopData",
        SerializerJson.serializeJson(dataDto));
    return "shop/FormView";
  }
}
