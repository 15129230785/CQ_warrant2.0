package com.cq.jbpm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;

public class JbpmFactoryLocator implements BeanFactoryLocator,
		BeanFactoryAware, BeanNameAware {
	static Logger logger = Logger.getLogger(JbpmFactoryLocator.class);

	// default factory name (for nested classes)
	private String factoryName = JbpmFactoryLocator.class.getName();
	// alias/bean name to BeanFactory
	protected static final Map<String, BeanFactory> beanFactories = new HashMap<String, BeanFactory>();
	// beanfactory to alias/bean name map
	protected static final Map<BeanFactory, List<String>> beanFactoriesNames = new HashMap<BeanFactory, List<String>>();
	protected static final Map<BeanFactory, Integer> referenceCounter = new HashMap<BeanFactory, Integer>();
	protected static boolean canUseDefaultBeanFactory = true;
	protected static BeanFactory defaultFactory = null;

	@Override
	public void setBeanName(String name) {
		factoryName = name;
	}

	@Override
	public void setBeanFactory(final BeanFactory beanFactory)
			throws BeansException {
		synchronized (JbpmFactoryLocator.class) {
			if (canUseDefaultBeanFactory) {
				if (defaultFactory == null) {
					defaultFactory = beanFactory;
					if (logger.isDebugEnabled())
						logger.debug("default beanFactoryReference="
								+ defaultFactory);
				} else {
					if (logger.isDebugEnabled())
						logger.debug("more then one beanFactory - default not possible to determine");
					canUseDefaultBeanFactory = false;
					defaultFactory = null;
				}
			}
		}
		// add name
		addToMap(factoryName, beanFactory);
		Integer counter = (Integer) referenceCounter.get(beanFactory);
		if (counter == null)
			referenceCounter.put(beanFactory, new Integer(0));
		// add aliases
		String[] aliases = beanFactory.getAliases(factoryName);
		List<String> names = new ArrayList<String>(1 + aliases.length);
		names.add(factoryName);
		for (int i = 0; i < aliases.length; i++) {
			addToMap(aliases[i], beanFactory);
			names.add(aliases[i]);
		}
		// append previous found names
		List<String> previousNames = (List<String>) beanFactoriesNames
				.get(beanFactory);
		if (previousNames != null)
			names.addAll(previousNames);

		beanFactoriesNames.put(beanFactory, names);

	}

	protected void addToMap(String fName, BeanFactory factory) {
		if (logger.isDebugEnabled())
			logger.debug("adding key=" + fName + " w/ reference=" + factory);

		synchronized (beanFactories) {
			// override check
			if (beanFactories.containsKey(fName))
				throw new IllegalArgumentException(
						"a beanFactoryReference already exists for key "
								+ factoryName);
			beanFactories.put(fName, factory);
		}
	}

	protected void removeReference(BeanFactory factory) {
		synchronized (referenceCounter) {
			Integer count = (Integer) referenceCounter.get(factory);
			// decrement counter
			int counter = count.intValue();
			counter--;
			if (counter == 0) {
				if (logger.isDebugEnabled())
					logger.debug("removing factory references under key "
							+ factoryName);
				referenceCounter.remove(factory);

				// reset also default beanFactory
				if (referenceCounter.isEmpty()) {
					canUseDefaultBeanFactory = true;
					defaultFactory = null;
				}
				List<String> names = (List<String>) beanFactoriesNames
						.get(factory);
				beanFactoriesNames.remove(factory);

				synchronized (beanFactories) {
					for (Iterator iter = names.iterator(); iter.hasNext();) {
						beanFactories.remove(iter.next());
					}
				}
			}
			else {
				referenceCounter.put(factory, new Integer(counter));
			}
		}
	}

	@Override
	public BeanFactoryReference useBeanFactory(String factoryKey)
			throws BeansException {
		// see if there is a default FactoryBean
		BeanFactory factory;

		if (factoryKey == null) {
			if (!canUseDefaultBeanFactory) {
				throw new IllegalArgumentException(
						"a non-null factoryKey needs to be specified as there are more then one factoryKeys available ");
			}
			factory = defaultFactory;
		} else {
			factory = (BeanFactory) beanFactories.get(factoryKey);
			if (factory == null) {
				throw new IllegalArgumentException(
						"there is no beanFactory under key " + factoryKey);
			}
		}

		// increment counter
		synchronized (referenceCounter) {
			Integer counter = (Integer) referenceCounter.get(factory);
			referenceCounter.put(factory, new Integer(counter.intValue() + 1));
		}

		final BeanFactory finalFactory = factory;

		// simple implementation
		return new BeanFactoryReference() {
			private BeanFactory fact = finalFactory;

			public BeanFactory getFactory() {
				if (this.fact == null)
					throw new IllegalArgumentException(
							"beanFactory already released");
				return this.fact;
			}

			public void release() throws FatalBeanException {
				if (fact != null) {
					removeReference(fact);
					// remove the factory reference
					this.fact = null;
				}
			}
		};
	}
}
