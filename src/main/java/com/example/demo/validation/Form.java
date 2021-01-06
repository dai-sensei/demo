package com.example.demo.validation;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Form {
  /*
   各アノテーションについては下記のURLを参照するとわかりやすい
   https://terasolunaorg.github.io/guideline/public_review/ArchitectureInDetail/Validation.html#jsr-303
   */

  // @NotBlank：Null、空文字、空白のみでないことを検証する
  // アノテーションにmessageを記述すると記述内容がエラーメッセージとして出力可能
  @NotBlank(message = "名前を入力してください")
  String name;

  // @Min：値の下限、@Max：値の加減
  @Min(0)
  @Max(150)
  int age;

  // RFC2822に準拠したEmailアドレスか検証する
  @Email
  String mail;

  // @Patternで正規表現によるバリデーションも可能
  @NotBlank
  @Pattern(regexp = "^\\\\d{3}\\\\-\\\\d{4}$")
  String postAddress;
}
