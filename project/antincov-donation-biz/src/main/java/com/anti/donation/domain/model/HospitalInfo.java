package com.anti.donation.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ：nelsonsunxin@didichuxing.com
 * @date ：Created in 2020-01-27 17:26
 * @description：TODO
 * @modified By：
 * @version:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalInfo {
    private Long no;

    private Long areaNo;

    private boolean showInfo = false;

    private String name ;

    private String address;

    private String contact;

    private String mobile;

    private List<Item> items;
}
