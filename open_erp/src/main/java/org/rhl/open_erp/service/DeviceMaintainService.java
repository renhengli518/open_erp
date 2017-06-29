package org.rhl.open_erp.service;

import org.rhl.open_erp.domain.DeviceMaintain;
import org.rhl.open_erp.domain.customize.CustomResult;
import org.rhl.open_erp.domain.customize.EUDataGridResult;

public interface DeviceMaintainService {

	EUDataGridResult getList(int page, int rows, DeviceMaintain deviceMaintain) throws Exception;
	
	DeviceMaintain get(String string) throws Exception;
	
	CustomResult insert(DeviceMaintain deviceMaintain) throws Exception;
	
	CustomResult delete(String deviceMaintainId) throws Exception;
	
	CustomResult deleteBatch(String[] deviceMaintainIds) throws Exception;

    CustomResult update(DeviceMaintain deviceMaintain) throws Exception;

	CustomResult updateNote(DeviceMaintain deviceMaintain) throws Exception;

	EUDataGridResult searchDeviceMaintainByDeviceMaintainId(Integer page,
			Integer rows, String deviceMaintainId) throws Exception;

	EUDataGridResult searchDeviceMaintainByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId) throws Exception;
}
