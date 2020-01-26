package com.anti.donation.controller;

import com.anti.donation.service.DonationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ：nelsonsunxin@didichuxing.com
 * @date ：Created in 2020-01-25 10:52
 * @description：TODO
 * @modified By：
 * @version:
 */
@RestController
public class DonationController {

    @Autowired
    DonationInfoService donationInfoService;

    @GetMapping("donationList")
    String getDonationList() {
        return donationInfoService.getDonationInfoList();
    }

}
