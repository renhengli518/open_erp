package org.rhl.open_erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.rhl.open_erp.domain.Technology;
import org.rhl.open_erp.domain.TechnologyExample;

public interface TechnologyMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);

	List<Technology> searchTechnologyByTechnologyId(String technologyId);

	List<Technology> searchTechnologyByTechnologyName(String technologyName);
	
	//逆向工程生成的mapper接口
    int countByExample(TechnologyExample example);

    int deleteByExample(TechnologyExample example);

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(String technologyId);

    int updateByExampleSelective(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByExample(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);
}