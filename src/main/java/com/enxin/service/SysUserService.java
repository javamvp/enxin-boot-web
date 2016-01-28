package com.enxin.service;

import java.util.List;
import java.util.Map;

import com.enxin.domain.TSysUser;

public interface SysUserService {
	List<TSysUser> getUserList(Map<String, Object> params);
}
