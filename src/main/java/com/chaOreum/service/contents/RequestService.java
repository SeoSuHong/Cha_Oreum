package com.chaOreum.service.contents;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {
	public String getClientIpAddress(HttpServletRequest request);
}
