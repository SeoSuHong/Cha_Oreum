package com.chaOreum.service.util;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {
	public String getClientIpAddress(HttpServletRequest request);
}
