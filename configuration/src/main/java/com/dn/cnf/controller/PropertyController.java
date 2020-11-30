package com.dn.cnf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dn.cnf.service.PropertiesService;
import com.dn.cnf.util.PropertyUtil;

/**
 * properties测试控制器
 * 
 * @author allen
 *
 */
@Controller
@RequestMapping("/prop")
public class PropertyController {
	@Autowired
	private PropertiesService ps;

	@RequestMapping(value = "/way/first", method = RequestMethod.GET)
	@ResponseBody
	public String getPropertyByFirstWay() {
		return ps.getProperyByFirstWay();
	}

	@RequestMapping(value = "/way/second", method = RequestMethod.GET)
	@ResponseBody
	public String getPropertyBySecondWay() {
		return ps.getProperyBySecondWay();
	}

	@RequestMapping(value = "/way/third", method = RequestMethod.GET)
	@ResponseBody
	public String getPropertyByThirdWay() {
		return ps.getProperyByThirdWay();
	}

	@RequestMapping(value = "/way/fourth/{key}", method = RequestMethod.GET)
	@ResponseBody
	public String getPropertyByFourthWay(@PathVariable("key") String key) {
		return ps.getProperyByFourthWay(key, "defaultValue");
	}

	@RequestMapping(value = "/way/fifth/{key}", method = RequestMethod.GET)
	@ResponseBody
	public String getPropertyByFifthWay(@PathVariable("key") String key) {
		return PropertyUtil.getProperty(key, "defaultValue");
	}
}
