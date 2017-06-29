package org.rhl.open_erp.service.impl;

import java.util.List;

import org.rhl.open_erp.domain.MaterialConsume;
import org.rhl.open_erp.domain.MaterialConsumeExample;
import org.rhl.open_erp.domain.customize.CustomResult;
import org.rhl.open_erp.domain.customize.EUDataGridResult;
import org.rhl.open_erp.domain.vo.MaterialConsumeVO;
import org.rhl.open_erp.mapper.MaterialConsumeMapper;
import org.rhl.open_erp.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

	@Autowired
	MaterialConsumeMapper materialConsumeMapper;
	
	@Override
	public List<MaterialConsume> find() throws Exception{
		// TODO Auto-generated method stub
		MaterialConsumeExample example = new MaterialConsumeExample();
		return materialConsumeMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, MaterialConsumeVO materialConsume)
			throws Exception{
		// TODO Auto-generated method stub
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.find(materialConsume);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public MaterialConsume get(String id) throws Exception{
		// TODO Auto-generated method stub
		return materialConsumeMapper.selectByPrimaryKey(id);
	}

	@Override
	public CustomResult delete(String id) throws Exception{
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.deleteByPrimaryKey(id);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(MaterialConsume materialConsume) throws Exception{
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.insert(materialConsume);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增物料消耗信息失败");
		}
	}

	@Override
	public CustomResult update(MaterialConsume materialConsume) throws Exception{
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.updateByPrimaryKeySelective(materialConsume);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料消耗信息失败");
		}
	}

	@Override
	public CustomResult updateAll(MaterialConsume materialConsume) throws Exception{
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.updateByPrimaryKey(materialConsume);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料消耗信息失败");
		}
	}

	@Override
	public CustomResult updateNote(MaterialConsume materialConsume) throws Exception{
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.updateNote(materialConsume);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料消耗备注失败");
		}
	}

	@Override
	public EUDataGridResult searchMaterialConsumeByConsumeId(int page, int rows, String consumeId)
			throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.searchMaterialConsumeByConsumeId(consumeId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public EUDataGridResult searchMaterialConsumeByMaterialId(int page, int rows, String materialId)
			throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.searchMaterialConsumeByMaterialId(materialId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchMaterialConsumeByWorkId(int page, int rows, String workId)
			throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.searchMaterialConsumeByWorkId(workId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
