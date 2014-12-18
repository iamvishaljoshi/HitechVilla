/**
 * 
 */
package com.sudosmith.cenmesser.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.cenmesser.dao.SupportedDeviceDAO;
import com.sudosmith.cenmesser.model.SupportedDevice;

/**
 * @author Vishal Joshi
 *
 */
@Repository("deviceDao")
public class SupportedDAOImpl extends GenericDAOImpl<SupportedDevice, Long>
		implements SupportedDeviceDAO {

	public SupportedDAOImpl(){
		super(SupportedDevice.class);
	}
}
