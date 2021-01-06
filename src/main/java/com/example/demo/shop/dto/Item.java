package com.example.demo.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
  private int itemNumber;
  private String itemName;
  private ItemDetail itemDetail;
  private boolean availability;
}
