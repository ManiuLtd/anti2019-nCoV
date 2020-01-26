package com.anti.donation.infrastructure.persistence.mybatis.mapper;

import com.anti.donation.infrastructure.persistence.mybatis.entity.Test;
import com.anti.donation.infrastructure.persistence.mybatis.entity.TestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    int countByExample(TestExample example);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);
}