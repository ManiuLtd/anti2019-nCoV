package com.anti.donation.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：nelsonsunxin@didichuxing.com
 * @date ：Created in 2020-01-27 18:44
 * @description：TODO
 * @modified By：
 * @version:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityInfo {
    Long id;

    String cityName;
}
