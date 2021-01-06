package com.example.demo.vuesample;

import com.example.demo.common.json.SerializerJson;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VueJsController {

  /**
   * Vue.jsの基本構文確認用.
   * @param model Model
   * @return 遷移先ページ
   */
  @GetMapping("/vue")
  public String first(Model model) {
    model.addAttribute("title","Vue.jsを使おう(基礎構文)");
    return "vue/vue";
  }

  /**
   * ListをModelに設定してThymeleafで表示する.
   * @param model Model
   * @return 遷移先ページ
   */
  @GetMapping("/vue/listview")
  public String viewList(Model model) {
    List<String> wordList = Arrays.asList("パンパース","サラダ記念日","復活","ゲームウォッチ","飛び地");
    model.addAttribute("wordList",wordList);
    return "vue/VueBind";
  }

  /**
   * リクエストでJSON文字列を返すAPI.
   * @return JSON文字列
   */
  @GetMapping("/vue/getViewList")
  @ResponseBody
  public String getViewList() {
    List<String> wordList = Arrays.asList("パンパース","サラダ記念日","復活","ゲームウォッチ","飛び地");
    return SerializerJson.serializeJson(wordList);
  }

  /**
   * リクエストでJSON文字列を返すAPI.
   * メソッドの戻り値を任意の型で返すとSpring Bootが自動でJSON形式に変換してくれる
   * (@ResponseBodyのアノテーションが必要)
   * @return JSON文字列
   */
  @GetMapping("/vue/getAutoJsonViewList")
  @ResponseBody
  public List<String> getAutoJsonViewList() {
    return Arrays.asList("パンパース","サラダ記念日","復活","ゲームウォッチ","飛び地");
  }
}
