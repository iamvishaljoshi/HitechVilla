package com.sudosmith.cenmesser.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Vishal Joshi
 *
 */
@Controller
public class HomeController {

	private Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public ModelAndView doHomeController(Map<String, Object> map) {
		logger.debug("doHomeController()");
		System.out.println("doHomeController()");
		return new ModelAndView(
				"redirect:/supportedDevices/listEntityAction.do");
	}
}
