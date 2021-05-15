package cn.edu.jxnu.rj.lrf.dao;

import cn.edu.jxnu.rj.lrf.entity.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityMapper {
    int deleteByPrimaryKey(String city);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(String city);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}