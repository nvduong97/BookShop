package com.example.demo.model.request;

import com.example.demo.entity.Author;
import com.example.demo.entity.Publisher;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBookReq {

    @NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name is required")
    @ApiModelProperty(
            example="Game of thrones",
            notes="Book's name cannot be empty",
            required=true
    )
    private String name;

    private String image;

    @ApiModelProperty(
            example="20",
            notes="Amount cannot be empty",
            required=true
    )
    private int amount;

    @ApiModelProperty(
            example="50000",
            notes="Price cannot be empty",
            required=true
    )
    private int price;

    private String publisherId;
    private String authorId;
}
