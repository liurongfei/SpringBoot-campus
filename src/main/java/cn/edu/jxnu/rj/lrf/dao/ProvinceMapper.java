package cn.edu.jxnu.rj.lrf.dao;

import cn.edu.jxnu.rj.lrf.entity.City;
import cn.edu.jxnu.rj.lrf.entity.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);

    List<City> selectByPid(int pid);
}