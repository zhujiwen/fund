package com.fund.basic.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Utils {

    public List<String> getAtoZ(){
        List<String> aToZ = new ArrayList<>();
        char value = 'A';
        for (int i = 0; i < 26; i++) {
            aToZ.add(String.valueOf(value++));
        }
        return aToZ;
    }
}
