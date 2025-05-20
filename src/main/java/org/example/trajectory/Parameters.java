package org.example.trajectory;

import java.util.HashMap;

public interface Parameters {
    HashMap<String,Integer> paramMap = new HashMap<>();
    default void addParameter(String k, int v){
        paramMap.put(k,v);
    }
    default int getParameter(String k){
        return paramMap.get(k);
    }

}
