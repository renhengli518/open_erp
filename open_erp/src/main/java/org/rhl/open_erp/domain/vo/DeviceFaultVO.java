package org.rhl.open_erp.domain.vo;

import org.rhl.open_erp.domain.DeviceFault;

public class DeviceFaultVO extends DeviceFault{
	
	private String deviceName;
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
}