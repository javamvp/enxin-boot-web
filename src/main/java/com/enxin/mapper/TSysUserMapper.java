package com.enxin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.enxin.domain.TSysUser;


public interface TSysUserMapper {
	Long deleteByPrimaryKey(Long id);

    Long insert(TSysUser record);

    Long insertSelective(TSysUser record);

    TSysUser selectByPrimaryKey(Long id);

    Long updateByPrimaryKeySelective(TSysUser record);

    Long updateByPrimaryKey(TSysUser record);
    
    List<TSysUser> getUserList(Map<String, Object> params);

	TSysUser getUserByLoginName(@Param(value="loginUserName")String loginUserName);

	Integer checkHealth();
}