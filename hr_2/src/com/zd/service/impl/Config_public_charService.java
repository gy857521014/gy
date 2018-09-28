package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_public_charDao;
import com.zd.entity.Config_public_char;
import com.zd.service.IConfig_public_charService;
@Service
public class Config_public_charService implements IConfig_public_charService{
	@Autowired
	private IConfig_public_charDao icpcdao;
	//Ìí¼Ó
	public void addcpc(Config_public_char config_public_char) {
		icpcdao.addcpc(config_public_char);
	}
	//²éÑ¯
	public List<Config_public_char> selcpc() {
		return icpcdao.selcpc();
	}
	//É¾³ý
	public void deletecpc(int pbc_id) {
		icpcdao.deletecpc(pbc_id);
	}

}
