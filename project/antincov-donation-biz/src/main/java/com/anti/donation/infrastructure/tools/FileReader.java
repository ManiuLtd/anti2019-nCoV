package com.anti.donation.infrastructure.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * @author ：nelsonsunxin@didichuxing.com
 * @date ：Created in 2020-01-26 13:56
 * @description：TODO
 * @modified By：
 * @version:
 */
public abstract class FileReader {
    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new java.io.FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
}
