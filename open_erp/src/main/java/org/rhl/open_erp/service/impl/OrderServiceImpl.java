package org.rhl.open_erp.service.impl;

import java.util.List;

import org.rhl.open_erp.domain.COrder;
import org.rhl.open_erp.domain.COrderExample;
import org.rhl.open_erp.domain.customize.CustomResult;
import org.rhl.open_erp.domain.customize.EUDataGridResult;
import org.rhl.open_erp.domain.vo.COrderVO;
import org.rhl.open_erp.mapper.COrderMapper;
import org.rhl.open_erp.service.CustomService;
import org.rhl.open_erp.service.OrderService;
import org.rhl.open_erp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	COrderMapper cOrderMapper;
	
	@Autowired
	CustomService customService;
	
	@Autowired
	ProductService productService;
	
	@Override
	public List<COrder> find() throws Exception{
		COrderExample example = new COrderExample();
		return cOrderMapper.selectByExample(example);
	}
	
	@Override
	public EUDataGridResult getList(int page, int rows, COrderVO cOrder) throws Exception{
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<COrderVO> list = cOrderMapper.find(cOrder);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<COrderVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public COrder get(String id) throws Exception{
		
		return cOrderMapper.selectByPrimaryKey(id);
	}

	@Override
	public CustomResult delete(String id) throws Exception{
		int i = cOrderMapper.deleteByPrimaryKey(id);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = cOrderMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(COrder cOrder) throws Exception{
		int i = cOrderMapper.insert(cOrder);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增订单失败");
		}
	}

	@Override
	public CustomResult update(COrder cOrder) throws Exception{
		int i = cOrderMapper.updateByPrimaryKeySelective(cOrder);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改订单失败");
		}
	}

	@Override
	public CustomResult updateAll(COrder cOrder) throws Exception{
		int i = cOrderMapper.updateByPrimaryKey(cOrder);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改订单失败");
		}
	}

	@Override
	public CustomResult updateNote(COrder cOrder) throws Exception{
		int i = cOrderMapper.updateNote(cOrder);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改订单要求失败");
		}
	}
	
	@Override
	public CustomResult changeStatus(String[] ids) throws Exception{
		int i = cOrderMapper.changeStatus(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	
	@Override
	public EUDataGridResult searchOrderByOrderId(int page, int rows, String orderId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<COrderVO> list = cOrderMapper.searchOrderByOrderId(orderId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<COrderVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public EUDataGridResult searchOrderByCustomName(int page, int rows, String custonName)
			throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<COrderVO> list = cOrderMapper.searchOrderByCustomName(custonName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<COrderVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchOrderByProductName(int page, int rows, String productName)
			throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<COrderVO> list = cOrderMapper.searchOrderByProductName(productName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<COrderVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}