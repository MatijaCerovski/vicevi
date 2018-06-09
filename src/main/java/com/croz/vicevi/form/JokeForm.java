package com.croz.vicevi.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JokeForm {

    @NotNull
    @NotEmpty
    @Size(max = 5000)
    private String content;

    @NotNull
    private Integer categoryId;
}
