package com.testerhome.api;

import java.util.HashMap;

public class Env {
    public static HashMap<String, String> hosts=init();

    public static HashMap<String, String> init(){
        HashMap<String, String> hosts=new HashMap<String, String>();
        hosts.put("test", "");
        hosts.put("stage", "");
        hosts.put("prod", "");
        return  hosts;
    }
}
