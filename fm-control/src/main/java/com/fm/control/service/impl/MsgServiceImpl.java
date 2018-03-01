package com.fm.control.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.control.cache.dao.AccountCacheDao;
import com.fm.control.model.MsgBean;
import com.fm.control.persist.dao.MsgDao;
import com.fm.control.service.MsgService;
import com.fm.control.service.exception.ServiceException;

@Service
public class MsgServiceImpl implements MsgService {

	Logger logger = Logger.getLogger(MsgServiceImpl.class);

	@Autowired
	AccountCacheDao accountCacheImpl;

	@Autowired
	MsgDao msgImpl;

	@Override
	public boolean handleMsg(Object msg) throws ServiceException {
		boolean flag = true;
		MsgBean msgBean = new MsgBean();
		String temp = (String) msg;

		// SN:00000001;pm2p5:0000.0,co2:000000,tvoc:00.000,humidity:000.00,temperature:000.00,pm10:0000.0
		if (temp.indexOf(";") > 0) {
			String sn = temp.substring(0, temp.indexOf(";"));

			if (sn.contains(":")) {
				String[] keyValue = sn.split(":");
				if (keyValue[0].equals("SN")) {
					msgBean.setSn(keyValue[1]);
				}
			}

			String oo = temp.substring(temp.indexOf(";") + 1, temp.length());
			if (oo.contains(",")) {
				String[] strs = oo.split(",");
				for (String str : strs) {
					if (str.contains(":")) {
						String[] keyValue = str.split(":");
						if (keyValue[0].equals("pm2p5")) {
							msgBean.setPm2p5(keyValue[1]);
						} else if (keyValue[0].equals("co2")) {
							msgBean.setCo2(keyValue[1]);
						} else if (keyValue[0].equals("tvoc")) {
							msgBean.setTvoc(keyValue[1]);
						} else if (keyValue[0].equals("humidity")) {
							msgBean.setHumidity(keyValue[1]);
						} else if (keyValue[0].equals("temperature")) {
							msgBean.setTemperature(keyValue[1]);
						} else if (keyValue[0].equals("pm10")) {
							msgBean.setPm10(keyValue[1]);
						}
					}
				}
			}
			msgImpl.insert(msgBean);
		}

		return flag;
	}

}
