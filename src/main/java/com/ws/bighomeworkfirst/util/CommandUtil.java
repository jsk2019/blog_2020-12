package com.ws.bighomeworkfirst.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandUtil {
    public static String execCmd(String command){
        String result = null;
        try {
            String[] cmd = new String[]{"/bin/sh", "-c", command};
            Process ps = Runtime.getRuntime().exec(cmd);

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                //执行结果加上回车
                sb.append(line).append("\n");
            }
            result = sb.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }
}
