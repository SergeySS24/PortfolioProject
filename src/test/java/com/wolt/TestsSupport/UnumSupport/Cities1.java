package com.wolt.TestsSupport.UnumSupport;

import java.util.HashMap;

public class Cities1 {

    void statementFor() {

        //Получить список всех городов в цикле и записать в map. Из map можно сделать parametrized test и пройтись по всем городам

        HashMap cities = new HashMap<String, String>();
        cities.put("key1", "Ammochostos");
        cities.put("key2", "Larnaca");
        cities.put("key3", "Limassol");
        cities.put("key4", "Nicosia");
        cities.put("key5", "Paphos");


        String s = null;
        for (Object city : cities.values()) {
            s = (String) city;

        }
        System.out.println(s);
    }

}
