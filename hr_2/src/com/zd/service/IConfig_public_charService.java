package com.zd.service;

import java.util.List;

import com.zd.entity.Config_public_char;

public interface IConfig_public_charService {
	//查询
	public List<Config_public_char> selcpc();
	//添加
	public void addcpc(Config_public_char config_public_char);
	// 删除用户
	public void deletecpc(int pbc_id);
}
