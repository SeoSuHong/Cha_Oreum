package com.chaOreum.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class RoleAspect {

	@Around("@annotation(RoleCheck)")
	public Object roleCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		// 권한 확인
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = servletRequestAttribute.getRequest().getSession(true);
		boolean role = false;
		if(session.getAttribute("admin") != null)
			role = (boolean) session.getAttribute("admin");
		if(!role) return "/admin/notAdmin";
		
		Object ret = joinPoint.proceed();
		
		return ret;
	}
}
