package com.example.demo.common.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

/**
 * Objectをjson文字列にシリアライズする機能を提供するクラス.
 */
@Component
public class SerializerJson {

  /**
   * JacksonのObjectMapper.
   */
  private static final ObjectMapper objectMapper = new ObjectMapper();

  /**
   * 引数に指定されたObjectをjson文字列にシリアライズして返却する.
   * @param outputDataDto json形式にシリアライズするObject
   * @return json文字列
   */
  public static String serializeJson(Object outputDataDto) {
    try {
      return objectMapper.writeValueAsString(outputDataDto);
    } catch (Exception e) {
      e.fillInStackTrace();
    }
    return "";
  }
}