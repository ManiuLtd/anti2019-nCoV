package com.anti.donation.adapter;

import com.alibaba.fastjson.JSONObject;
import com.anti.donation.domain.model.HospitalInfo;
import com.anti.donation.infrastructure.tools.FileReader;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：nelsonsunxin@didichuxing.com
 * @date ：Created in 2020-01-27 17:35
 * @description：TODO
 * @modified By：
 * @version:
 */
@Service
public class DonationInfoAdapter {
    static final String fileName = "../jsondata/data.json";

   public List<HospitalInfo> getHospitalInfo(Long id) {

        String jsonresult = FileReader.readFileContent(fileName);
        List rawHospitalInfoList = JSONObject.parseObject(jsonresult, List.class);
        List<HospitalInfo> hospitalInfoList = new LinkedList<>();
        for(int i=0;i<rawHospitalInfoList.size();i++) {
             HospitalInfo info =JSONObject.parseObject(JSONObject.toJSONString(rawHospitalInfoList.get(i)),HospitalInfo.class);
            if(0 == id || info.getAreaNo().equals(id)) {
                hospitalInfoList.add(info);
            }
        }

        return hospitalInfoList;
    }
}
