package com.sudosmith.cenmesser.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sudosmith.cenmesser.model.SupportedDevice;
import com.sudosmith.cenmesser.pagination.Page;
import com.sudosmith.cenmesser.service.SupportedDeviceService;
import com.sudosmith.cenmesser.util.PageUtils;

/**
 * @author Vishal Joshi
 *
 */
@Controller
@RequestMapping("/supportedDevices")
public class SupportedDeviceController {

	@Autowired
	private SupportedDeviceService deviceService;

	private Logger logger = Logger.getLogger(SupportedDeviceController.class);

	@RequestMapping(value="/")
	public ModelAndView doRedirect(Map<String, Object> map) {
		logger.debug("doRedirect()");
		return new ModelAndView(
				"redirect:/supportedDevices/listEntityAction.do");
	}

	@RequestMapping(value="/listEntityAction.do")
	public String doList(Map<String, Object> map) {
		logger.debug("doList()");
		SupportedDevice device = new SupportedDevice();
		List<SupportedDevice> deviceList = new ArrayList<SupportedDevice>();
		map.put("device", device);
		try {
			deviceList = deviceService.findAllDevices();
			map.put("deviceList", deviceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//device.getPage().setTotalNoOfRecord(deviceList.size());
		Page page = PageUtils.getPageIndexes(1, 4,
				deviceService.totalNoOfRecord());
		page.setTotalNoOfRecord(deviceService.totalNoOfRecord());
		System.out.println("End Index :: " + page.getEndIndexPerPage());
		map.put("page", page);
		return "supporteddevicelist";
	}

	@RequestMapping(value = "/addEntityAction.do", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView doAddForm(@ModelAttribute SupportedDevice device,
			BindingResult bindingResult,
			@RequestParam(required = false) String action,
			Map<String, Object> map) {
		logger.debug("doAddForm()");
		map.put("device", new SupportedDevice());
		map.put("action", "Add");
		return new ModelAndView("addsupporteddevice");
	}

	@RequestMapping(value = "/saveEntityAction.do", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView doSave(@ModelAttribute SupportedDevice device,
			BindingResult bindingResult,
			@RequestParam(required = false) String action,
			Map<String, Object> map) {
		logger.debug("doSave()");
		List<SupportedDevice> deviceList = new ArrayList<SupportedDevice>();
		try {
			deviceService.addDevice(device);
			deviceList = deviceService.findAllDevices();
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}

		map.put("device", new SupportedDevice());
		map.put("deviceList", deviceList);
		map.put("page",
				PageUtils.getPageIndexes(1, 4, deviceService.totalNoOfRecord()));
		return new ModelAndView(
				"redirect:/supportedDevices/listEntityAction.do");
	}

	@RequestMapping(value = "/editEntityAction.do", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView doEditForm(@ModelAttribute Page page,
			BindingResult bindingResult1,
			@ModelAttribute SupportedDevice device,
			BindingResult bindingResult,
			@RequestParam(required = false) String action,
			@RequestParam(required = false) String deviceId,
			Map<String, Object> map) {
		logger.debug("doEditForm()");
		try {
			map.put("device",
					deviceService.findDeviceById(Integer.parseInt(deviceId)));
		} catch (NumberFormatException e) {
			logger.error("Number Format Exception :: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		map.put("action", "Edit");
		return new ModelAndView("editsupporteddevice");
	}

	@RequestMapping(value = "/updateEntityAction.do", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView doUpdate(@ModelAttribute Page page,
			BindingResult bindingResult1,
			@ModelAttribute SupportedDevice device,
			BindingResult bindingResult,
			@RequestParam(required = false) String action,
			@RequestParam(required = false) String deviceId,
			Map<String, Object> map) {
		logger.debug("doUpdate()");

		List<SupportedDevice> deviceList = new ArrayList<SupportedDevice>();
		try {
			deviceService.editDevice(device);
			deviceList = deviceService.findAllDevices();
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}

		map.put("device", new SupportedDevice());
		map.put("deviceList", deviceList);
		map.put("page",
				PageUtils.getPageIndexes(1, 4, deviceService.totalNoOfRecord()));
		return new ModelAndView(
				"redirect:/supportedDevices/listEntityAction.do");

	}

	@RequestMapping(value = { "/viewEntityAction.do"}, method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView doView(@ModelAttribute Page page,
			BindingResult bindingResult1,
			@ModelAttribute SupportedDevice device,
			BindingResult bindingResult,
			@RequestParam(required = false) String action,
			@RequestParam(required = false) String deviceId,
			Map<String, Object> map) {
		logger.debug("doView()");

		try {
			map.put("device",
					deviceService.findDeviceById(Integer.parseInt(deviceId)));
		} catch (NumberFormatException e) {
			logger.error("Number Format Exception :: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		map.put("action", "Delete");
		map.put("action.do", "deleteEntityAction.do");
		return new ModelAndView("viewsupporteddevice");

	}

	@RequestMapping(value = "/deleteEntityAction.do", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView doDelete(@ModelAttribute Page page,
			BindingResult bindingResult1,
			@ModelAttribute SupportedDevice device,
			BindingResult bindingResult,
			@RequestParam(required = false) String action,
			@RequestParam(required = false) String deviceId,
			Map<String, Object> map) {
		logger.debug("doDelete()");
		List<SupportedDevice> deviceList = new ArrayList<SupportedDevice>();
		try {
			deviceService.deleteDevice(device.getId());
			deviceList = deviceService.findAllDevices();
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}

		map.put("device", new SupportedDevice());
		map.put("deviceList", deviceList);
		map.put("page",
				PageUtils.getPageIndexes(1, 4, deviceService.totalNoOfRecord()));
		return new ModelAndView(
				"redirect:/supportedDevices/listEntityAction.do");
	}

	@RequestMapping(value = "/searchEntityAction.do", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String doSearch(@ModelAttribute Page page,
			BindingResult bindingResult1, @RequestParam String action,
			@RequestParam String search, Map<String, Object> map) {
		logger.debug("doSearch()");
		List<SupportedDevice> deviceList = new ArrayList<SupportedDevice>();
		Map<String, Object> queryParameter = new HashMap<String, Object>();
		queryParameter.put("queryString", "%" + search + "%");
		deviceList = deviceService.findByQueryParams(queryParameter, page);
		map.put("device", new SupportedDevice());
		map.put("deviceList", deviceList);
		if (search != null && !search.equals("")) {
			map.put("page", PageUtils.getPageIndexes(1, 4, deviceList.size()));
		} else {
			map.put("page",
					PageUtils.getPageIndexes(1, 4,
							deviceService.totalNoOfRecord()));
		}
		return "supporteddevicelist";

	}

	@RequestMapping(value = "/pagingEntityAction.do", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String doPaging(@ModelAttribute Page page,
			BindingResult bindingResult, @RequestParam String action,
			Map<String, Object> map) {
		logger.debug("doPaging");
		Page currentPage = PageUtils.getPageIndexes(page.getCurrentPageNo(),
				page.getRecordPerPage(), page.getTotalNoOfRecord());
		List<SupportedDevice> deviceList = new ArrayList<SupportedDevice>();
		try {
			deviceList = deviceService.findAllDevices();
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		map.put("device", new SupportedDevice());
		map.put("deviceList", deviceList);
		map.put("page", currentPage);
		return "supporteddevicelist";

	}
}
