package com.example.demo.vuesample;

import com.example.demo.vuesample.form.FormValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VueFormController {

  @GetMapping("/vue/form")
  public String getNewPageView(Model model) {
    FormValue formValue = new FormValue();
    formValue.setMessageText("初期メッセージ");
    model.addAttribute("formValue",formValue);
    return "vue/VueForm";
  }

  @PostMapping("/vue/form")
  public String postPageView(@ModelAttribute FormValue formValue, BindingResult bindingResult) {
    return "vue/VueForm";
  }
}
