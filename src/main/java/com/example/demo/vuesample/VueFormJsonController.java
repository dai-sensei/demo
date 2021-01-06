package com.example.demo.vuesample;

import com.example.demo.common.json.SerializerJson;
import com.example.demo.vuesample.form.FormJsonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Vue.jsでのForm内容の検証用コントローラ.
 */
@Controller
public class VueFormJsonController {

  /**
   * Getリクエストを受け取る.
   * @param model Model
   * @return thymeleafのhtmlパス指定
   */
  @GetMapping("/vue/formjson")
  public String getNewPage(Model model) {
    // 初回アクセス時のFormの内容を作成
    FormJsonValue formJsonValue =
        new FormJsonValue("UserName",20,"テストメッセージ");

    // 画面埋め込み用のJSON文字列の作成およびModelへ設定
    model.addAttribute("formJson",
        SerializerJson.serializeJson(formJsonValue));

    return "vue/VueFormJson";
  }

  /**
   * POSTリクエストを受け取る.
   * @param formJsonValue 値を受け取るフォームオブジェクト
   * @param bindingResult マッピング結果
   * @param model Model
   * @return thymeleafのhtmlパス指定
   */
  @PostMapping("/vue/formjson/send")
  public String postPage(@ModelAttribute FormJsonValue formJsonValue,
                         BindingResult bindingResult, Model model) {
    // マッピングの結果をコンソール出力
    System.out.println("自動マッピング成功可否:" + bindingResult.hasErrors());

    // 画面埋め込み用のJSON文字列の作成およびModelへ設定
    model.addAttribute("formJson",
        SerializerJson.serializeJson(formJsonValue));

    return "vue/VueFormJson";
  }
}
