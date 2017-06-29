package org.rhl.open_erp.service;

import java.util.List;

import org.rhl.open_erp.domain.authority.SysRolePermission;
import org.rhl.open_erp.domain.customize.CustomResult;
import org.rhl.open_erp.domain.customize.EUDataGridResult;

public interface PermissionService {
	
	List<SysRolePermission> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, SysRolePermission sysRolePermission) throws Exception;
	
	SysRolePermission get(String string) throws Exception;
	
	SysRolePermission getByRoleId(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult insert(SysRolePermission sysRolePermission) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(SysRolePermission sysRolePermission) throws Exception;
    
    //根据角色id更新角色权限表
    CustomResult updateByRoleId(String roleId, String permission) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(SysRolePermission sysRolePermission) throws Exception;
}
