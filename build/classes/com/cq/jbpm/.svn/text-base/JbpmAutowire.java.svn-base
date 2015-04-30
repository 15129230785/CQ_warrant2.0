package com.cq.jbpm;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

public class JbpmAutowire {
	// arg1:向哪个类进行属性注入
	// arg2:按照那种方式注入：按类型、或者名称....此处按照类型
	// arg2:是否检查依赖关系，一般情况下为true要检查依赖关系。
	public JbpmAutowire() {
		((AutowireCapableBeanFactory) retrieveBeanFactory())
				.autowireBeanProperties(this,
						AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
	}

	protected BeanFactory retrieveBeanFactory() {
		BeanFactoryLocator factoryLocator = new JbpmFactoryLocator();
		BeanFactoryReference factory = factoryLocator.useBeanFactory(null);
		if (factory == null)
			throw new IllegalArgumentException(
					"no beanFactory found under key=" + null);

		try {
			return factory.getFactory();
		} finally {
			factory.release();
		}
	}
}
