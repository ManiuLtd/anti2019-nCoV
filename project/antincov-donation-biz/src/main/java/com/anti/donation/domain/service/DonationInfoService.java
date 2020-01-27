package com.anti.donation.domain.service;

import com.anti.donation.adapter.CityInfoAdapter;
import com.anti.donation.adapter.DonationInfoAdapter;
import com.anti.donation.domain.model.CityInfo;
import com.anti.donation.domain.model.HospitalInfo;
import com.anti.donation.infrastructure.tools.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：nelsonsunxin@didichuxing.com
 * @date ：Created in 2020-01-26 13:59
 * @description：TODO
 * @modified By：
 * @version:
 */
@Service
public class DonationInfoService {
    @Autowired
    DonationInfoAdapter donationInfoAdapter;

    @Autowired
    CityInfoAdapter cityInfoAdapter;

    public List<HospitalInfo> getDonationInfoList(Long id) {
        return donationInfoAdapter.getHospitalInfo(id);
    }

    public List<CityInfo> getCityList() {
       return cityInfoAdapter.getCityList();
    }

}
