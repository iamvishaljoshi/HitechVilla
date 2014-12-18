/**
 * 
 */
package com.sudosmith.cenmesser.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.cenmesser.dao.SupportedDeviceDAO;
import com.sudosmith.cenmesser.model.SupportedDevice;
import com.sudosmith.cenmesser.pagination.Page;
import com.sudosmith.cenmesser.service.SupportedDeviceService;

/**
 * @author Vishal Joshi
 *
 */
@Service("deviceService")
public class SupportedDeviceServiceImpl implements SupportedDeviceService {

	private Logger logger = Logger.getLogger(SupportedDeviceServiceImpl.class);

	@Autowired
	private SupportedDeviceDAO deviceDao;

	@Transactional
	public SupportedDevice addDevice(SupportedDevice device) throws Exception {
		logger.debug("in addDevice()");
		try {
			return deviceDao.create(device);
		} catch (Exception e) {
			logger.error("Error adding device details", e);
		}
		return null;
	}

	@Transactional
	public SupportedDevice editDevice(SupportedDevice device) throws Exception {

		logger.debug("In editDevice()");
		logger.info("device  Name - " + device.getDeviceName());
		try {
			return deviceDao.merge(device);
		} catch (Exception e) {
			logger.error("Error updaing device details", e);
		}
		return null;

	}

	@Transactional
	public void deleteDevice(int deviceId) throws Exception {
		logger.debug("In deleteDevice()");
		try {
			SupportedDevice supportedDevice = deviceDao.findById(deviceId);
			if (supportedDevice != null) {
				deviceDao.delete(supportedDevice);
			}
		} catch (Exception e) {
			logger.error("Error removing device by id - " + deviceId, e);
		}
	}

	@Transactional
	public List<SupportedDevice> findAllDevices() throws Exception {
		logger.debug("In findAllDevices()");
		try {
			return deviceDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting device list.", e);
		}
		return null;
	}

	@Transactional
	public SupportedDevice findDeviceById(int deviceId) throws Exception {
		logger.debug("In findDeviceById()");
		try {
			return deviceDao.findById(deviceId);
		} catch (Exception e) {
			logger.error("Error in finding device by id - " + deviceId, e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.crud.service.SupportedDeviceService#findByQueryParams(java.lang.String
	 * , java.util.Map)
	 */
	@Transactional
	public List<SupportedDevice> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<SupportedDevice> devices = new ArrayList<SupportedDevice>();
		try {
			List<?> deviceList = deviceDao.findByQueryParams("findSupportedDeviceByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = deviceList.iterator(); iterator
					.hasNext();) {
				SupportedDevice device = (SupportedDevice) iterator.next();
				devices.add(device);
			}
			return devices;
		} catch (Exception e) {
			logger.error("Error getting device list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<SupportedDevice> findAllDevices(Page page){
		

		logger.debug("In findAllDEvices(Page page)");
		try {
			return deviceDao.findAll(page, "findAllDevicesByPaging");
		} catch (Exception e) {
			logger.error("Error getting device list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return deviceDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

}
