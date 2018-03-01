package com.fm.control.service;

import com.fm.control.service.exception.ServiceException;

public interface MsgService {

	boolean handleMsg(Object msg) throws ServiceException;

}
