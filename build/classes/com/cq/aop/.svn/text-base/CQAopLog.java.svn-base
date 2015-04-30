package com.cq.aop;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.cq.annotation.CQAnnotationOperlog;
import com.cq.service.OperlogService;
import com.cq.table.TblOperlog;
import com.cq.util.tools;

@Aspect
public class CQAopLog {
	@Resource OperlogService operlogService;

	@Pointcut("execution(* com.cq.action.Tbl*.sava*(..))")
	public void saveTableCall() {
	}

	@Pointcut("execution(* com.cq.action.Tbl*.outDelete*(..))")
	public void deleteTableCall() {
	}

	@Pointcut("execution(* com.cq.action.Tbl*.update*(..))")
	public void updateTableCall() {
	}
	
	@AfterReturning(value = "saveTableCall()")
	public void saveTableCalls(JoinPoint jp) throws Exception {
		tableOperationLog(jp, "添加");
	}

	@AfterReturning(value = "deleteTableCall()")
	public void deleteTableCalls(JoinPoint jp) throws Exception {
		tableOperationLog(jp, "删除");
	}

	@AfterReturning(value = "updateTableCall()")
	public void updateTableCalls(JoinPoint jp) throws Exception {
		tableOperationLog(jp, "修改");
	}
	
	private void tableOperationLog(JoinPoint jp, String opMode) throws Exception {
		String targetName = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		Class<?> targetClass = Class.forName(targetName);
		Method method = targetClass.getDeclaredMethod(methodName, new Class[] {});

		if (method != null) {
			CQAnnotationOperlog olog = (CQAnnotationOperlog) targetClass.getAnnotation(CQAnnotationOperlog.class);
			String tn = olog.tableName();
			String dn = olog.dataName();

			Field field = targetClass.getDeclaredField(dn);
			if (field != null) {
				field.setAccessible(true);
				Object to = getFieldValueByName(dn, jp.getTarget());
				String data = JSONObject.fromObject(to, tools.getJsonConfig()).toString();
				
				TblOperlog operlog = new TblOperlog();
				operlog.setName(tools.getLoginUser());
				operlog.setOpDate(System.currentTimeMillis());
				operlog.setOpMode(opMode);
				operlog.setLog(data);
				operlog.setTableName(tn);

				operlogService.logTableOperation(operlog);
			}
		}
	}

	private Object getFieldValueByName(String fieldName, Object o)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Object value = null;

		String fn = fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);
		Method m = o.getClass().getDeclaredMethod("get" + fn, new Class[] {});
		value = m.invoke(o, new Object[] {});

		return value;
	}

	public void setOperlogService(OperlogService operlogService) {
		this.operlogService = operlogService;
	}
}
