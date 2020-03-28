package com.example.demo.model.request;

import com.example.demo.entity.CartDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCartReq {
    private int totalMoney;
    private List<CartDetail> cartDetails;
}
