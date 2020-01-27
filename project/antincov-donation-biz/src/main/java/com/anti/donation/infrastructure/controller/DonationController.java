package com.anti.donation.infrastructure.controller;

import com.anti.donation.domain.model.CityInfo;
import com.anti.donation.domain.model.HospitalInfo;
import com.anti.donation.domain.service.DonationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    List<HospitalInfo> getDonationList(@RequestParam Long id) {
        return donationInfoService.getDonationInfoList(id);
    }

    @GetMapping("cityList")
    List<CityInfo> getCityList() {
        return donationInfoService.getCityList();
    }

}
