package com.anti.donation.service;

import com.anti.donation.infrastructure.tools.FileReader;
import org.springframework.stereotype.Service;

/**
 * @author ：nelsonsunxin@didichuxing.com
 * @date ：Created in 2020-01-26 13:59
 * @description：TODO
 * @modified By：
 * @version:
 */
@Service
public class DonationInfoService {
    static final String fileName = "../jsondata/data.json";
    public String getDonationInfoList() {
        return FileReader.readFileContent(fileName);
    }
}
