package com.example.demo.validation;

import com.example.demo.common.json.SerializerJson;
import com.example.demo.common.validation.ValidationErrorUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ValidationSampleController {

  @GetMapping("/validation")
  public String newPage(Model model) {
    model.addAttribute("form", new Form());
    return "validation/ValidationSample";
  }

  @PostMapping("/validation")
  public String validationCheck(@Validated @ModelAttribute Form form,
                                BindingResult result, Model model) {
    model.addAttribute("form", form);

    // バリデーションのエラーチェック
    if (result.hasErrors()) {
      System.out.println("バリデーションでエラーとなったため元のフォームに戻る");
      // validationチェックに弾かれた場合、元のページに返す
      return "validation/ValidationSample";
    }

    return "forward:/CheckOk";
  }

  @PostMapping("/CheckOK")
  public String checkO(@ModelAttribute Form form, BindingResult result, Model model) {
    model.addAttribute("formObject", form);
    return "validation/CheckOk";
  }

  @PostMapping("/validation/check")
  @ResponseBody
  public String formCheck(@Validated @RequestBody Form form, BindingResult bindingResult) {
    String message = "";

    if (bindingResult.hasErrors()) {
      message = SerializerJson.serializeJson(
          ValidationErrorUtil.createValidationErrorMessageMap(bindingResult));
    }
    return message;
  }
}
