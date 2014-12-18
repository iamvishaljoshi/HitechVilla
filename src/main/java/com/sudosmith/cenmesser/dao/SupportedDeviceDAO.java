/**
 * 
 */
package com.sudosmith.cenmesser.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.cenmesser.model.SupportedDevice;

/**
 * @author Vishal Joshi
 *
 */
@Component("deviceDao")
public interface SupportedDeviceDAO extends GenericDAO<SupportedDevice, Serializable> {

}
