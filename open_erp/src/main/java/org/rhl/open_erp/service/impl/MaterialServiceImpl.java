package org.rhl.open_erp.service.impl;

import java.util.List;

import org.rhl.open_erp.domain.Material;
import org.rhl.open_erp.domain.MaterialExample;
import org.rhl.open_erp.domain.customize.CustomResult;
import org.rhl.open_erp.domain.customize.EUDataGridResult;
import org.rhl.open_erp.mapper.MaterialMapper;
import org.rhl.open_erp.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialMapper materialMapper;
	
	@Override
	public List<Material> find() throws Exception{
		MaterialExample example = new MaterialExample();
		return materialMapper.selectByExample(example);	
	}

	@Override
	public EUDataGridResult getList(int page, int rows, Material material) throws Exception{
		//查询列表
		MaterialExample example = new MaterialExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Material> list = materialMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Material> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;		
	}

	@Override
	public Material get(String string) throws Exception{
		return materialMapper.selectByPrimaryKey(string);
		
	}

	@Override
	public CustomResult delete(String string) throws Exception{
		int i = materialMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = materialMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Material material) throws Exception{
		int i = materialMapper.insert(material);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增物料信息失败");
		}
	}

	@Override
	public CustomResult update(Material material) throws Exception{
		int i = materialMapper.updateByPrimaryKeySelective(material);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料信息失败");
		}
		
	}

	@Override
	public CustomResult updateAll(Material material) throws Exception{
		int i = materialMapper.updateByPrimaryKey(material);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料信息失败");
		}
	}

	@Override
	public CustomResult updateNote(Material material) throws Exception{
		int i = materialMapper.updateNote(material);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料备注失败");
		}
	}
	
	@Override
	public EUDataGridResult searchMaterialByMaterialId(int page, int rows, String materialId)
			throws Exception{
        //分页处理
		PageHelper.startPage(page, rows);
		List<Material> list = materialMapper.searchMaterialByMaterialId(materialId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Material> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchMaterialByMaterialType(Integer page,
			Integer rows, String materialType) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Material> list = materialMapper.searchMaterialByMaterialType(materialType);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Material> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
