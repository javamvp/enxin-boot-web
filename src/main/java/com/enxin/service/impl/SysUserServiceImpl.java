package com.enxin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enxin.domain.TSysUser;
import com.enxin.mapper.TSysUserMapper;
import com.enxin.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	TSysUserMapper tSysUserMapper;

	public List<TSysUser> getUserList(Map<String, Object> params) {
		List<TSysUser> list = tSysUserMapper.getUserList(null);
		System.out.println("list=========="+list.size());
		return null;
	}

}
