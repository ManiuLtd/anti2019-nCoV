package com.anti.donation.adapter;

import com.anti.donation.domain.constants.CitiesEnum;
import com.anti.donation.domain.model.CityInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：nelsonsunxin@didichuxing.com
 * @date ：Created in 2020-01-27 18:44
 * @description：TODO
 * @modified By：
 * @version:
 */
@Service
public class CityInfoAdapter {

    public List<CityInfo> getCityList() {
        List<CityInfo> cityInfos = new ArrayList<>();
        for(CitiesEnum city : CitiesEnum.values()) {
            cityInfos.add(CityInfo.builder().id(city.getId()).cityName(city.getName()).build());
        }
        return cityInfos;
    }
}
