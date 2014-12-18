/**
 * 
 */
package com.sudosmith.cenmesser.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.cenmesser.model.SupportedDevice;
import com.sudosmith.cenmesser.pagination.Page;

/**
 * @author Vishal Joshi
 *
 */
public interface SupportedDeviceService {

	
	public SupportedDevice addDevice(SupportedDevice device) throws Exception;
	
	public SupportedDevice editDevice(SupportedDevice device) throws Exception;
	
	public void deleteDevice(int deviceId) throws Exception;
	
	public List<SupportedDevice> findAllDevices() throws Exception;
	
	public List<SupportedDevice> findAllDevices(Page page);
	
	public SupportedDevice findDeviceById(int deviceId) throws Exception;
	
	public List<SupportedDevice> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();
	
}
