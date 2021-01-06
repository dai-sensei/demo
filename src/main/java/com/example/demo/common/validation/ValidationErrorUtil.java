package com.example.demo.common.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

/**
 * バリデーションエラー用の独自Utility.
 */
@Component
public class ValidationErrorUtil {

  /**
   * 画面出力用のバリデーションエラーメッセージのHashMapを作成する.
   * @param bindingResult バインド結果
   * @return エラーメッセージを格納したMap
   */
  public static Map<String, List<String>> createValidationErrorMessageMap(
      BindingResult bindingResult) {

    Map<String,List<String>> validationErrorMessageMap = new HashMap<>();

    for (FieldError fieldError : bindingResult.getFieldErrors()) {
      // Key(Validationチェックの発生個所名を格納)
      String key = fieldError.getField();

      // エラーメッセージを格納
      String message = fieldError.getDefaultMessage();

      if (!validationErrorMessageMap.containsKey(key)) {
        // KeyがMapに存在していない場合、空のListを作成
        validationErrorMessageMap.put(key,new ArrayList<>());
      }
      // Keyに紐づくListにメッセージ内容を追加
      validationErrorMessageMap.get(key).add(message);
    }
    return validationErrorMessageMap;
  }
}
