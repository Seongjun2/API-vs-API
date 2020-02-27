package com.gigamachim.APIvsAPIBack.Controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Test {
    String name;
    String pw;

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
