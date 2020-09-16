package com.dubbo.config;

import com.alibaba.dubbo.config.spring.ServiceBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.util.ObjectUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zero
 * @date 2020/9/3-20:19
 */
public class ServiceBeanUtil {

    public static AbstractBeanDefinition build(Service service, String beanName, Class<?> interfaces) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(ServiceBean.class);
        beanDefinitionBuilder.addConstructorArgValue(service);
        beanDefinitionBuilder.addPropertyReference("ref", beanName);
        beanDefinitionBuilder.addPropertyValue("interfaceClass", interfaces);
        if (StringUtils.hasText(service.provider())) {
            beanDefinitionBuilder.addPropertyReference("provider", service.provider());
        }
        if (StringUtils.hasText(service.monitor())) {
            beanDefinitionBuilder.addPropertyReference("monitor", service.monitor());
        }
        if (StringUtils.hasText(service.application())) {
            beanDefinitionBuilder.addPropertyReference("application", service.application());
        }
        if (StringUtils.hasText(service.module())) {
            beanDefinitionBuilder.addPropertyReference("module", service.module());
        }
        if (service.registry().length > 0) {
            beanDefinitionBuilder.addPropertyValue("registries", toRuntimeBeanReferences(service.registry()));
        }
        if (service.protocol().length > 0) {
            beanDefinitionBuilder.addPropertyValue("protocols", toRuntimeBeanReferences(service.protocol()));
        }
        if (service.weight() > 0) {
            beanDefinitionBuilder.addPropertyValue("weight", service.weight());
        }
        if (service.delay() > 0) {
            beanDefinitionBuilder.addPropertyValue("delay", service.delay());
        }
        if (service.timeout() > 0) {
            beanDefinitionBuilder.addPropertyValue("timeout", service.timeout());
        }
        if (service.connections() > 0) {
            beanDefinitionBuilder.addPropertyValue("connections", service.connections());
        }
        if (service.callbacks() > 0) {
            beanDefinitionBuilder.addPropertyValue("callbacks", service.callbacks());
        }
        if (service.executes() > 0) {
            beanDefinitionBuilder.addPropertyValue("executes", service.executes());
        }
        if (service.retries() > 0) {
            beanDefinitionBuilder.addPropertyValue("retries", service.retries());
        }
        if (service.actives() > 0) {
            beanDefinitionBuilder.addPropertyValue("actives", service.actives());
        }
        if (StringUtils.hasText(service.version())) {
            beanDefinitionBuilder.addPropertyValue("version", service.version());
        }
        if (StringUtils.hasText(service.group())) {
            beanDefinitionBuilder.addPropertyValue("group", service.group());
        }
        if (StringUtils.hasText(service.path())) {
            beanDefinitionBuilder.addPropertyValue("path", service.path());
        }
        if (StringUtils.hasText(service.token())) {
            beanDefinitionBuilder.addPropertyValue("token", service.token());
        }
        if (StringUtils.hasText(service.path())) {
            beanDefinitionBuilder.addPropertyValue("path", service.path());
        }
        if (StringUtils.hasText(service.document())) {
            beanDefinitionBuilder.addPropertyValue("document", service.document());
        }
        if (StringUtils.hasText(service.accesslog())) {
            beanDefinitionBuilder.addPropertyValue("accesslog", service.accesslog());
        }
        if (StringUtils.hasText(service.stub())) {
            beanDefinitionBuilder.addPropertyValue("stub", service.stub());
        }
        if (StringUtils.hasText(service.cluster())) {
            beanDefinitionBuilder.addPropertyValue("cluster", service.cluster());
        }
        if (StringUtils.hasText(service.proxy())) {
            beanDefinitionBuilder.addPropertyValue("proxy", service.proxy());
        }
        if (StringUtils.hasText(service.ondisconnect())) {
            beanDefinitionBuilder.addPropertyValue("ondisconnect", service.ondisconnect());
        }
        if (StringUtils.hasText(service.onconnect())) {
            beanDefinitionBuilder.addPropertyValue("onconnect", service.onconnect());
        }
        if (StringUtils.hasText(service.owner())) {
            beanDefinitionBuilder.addPropertyValue("owner", service.owner());
        }
        if (StringUtils.hasText(service.layer())) {
            beanDefinitionBuilder.addPropertyValue("layer", service.layer());
        }
        if (StringUtils.hasText(service.loadbalance())) {
            beanDefinitionBuilder.addPropertyValue("loadbalance", service.loadbalance());
        }
        if (StringUtils.hasText(service.mock())) {
            beanDefinitionBuilder.addPropertyValue("mock", service.mock());
        }
        if (StringUtils.hasText(service.validation())) {
            beanDefinitionBuilder.addPropertyValue("validation", service.validation());
        }
        if (StringUtils.hasText(service.cache())) {
            beanDefinitionBuilder.addPropertyValue("cache", service.cache());
        }
        if (service.filter().length > 0) {
            beanDefinitionBuilder.addPropertyValue("filter", toStr(service.filter()));
        }
        if (service.listener().length > 0) {
            beanDefinitionBuilder.addPropertyValue("listener", toStr(service.listener()));
        }
        if (service.parameters().length > 0) {
            beanDefinitionBuilder.addPropertyValue("listener", toMap(service.parameters()));
        }
        beanDefinitionBuilder.setLazyInit(false);
        beanDefinitionBuilder.setScope(BeanDefinition.SCOPE_SINGLETON);
        return beanDefinitionBuilder.getBeanDefinition();
    }

    private static ManagedList<RuntimeBeanReference> toRuntimeBeanReferences(String... beanNames) {
        ManagedList<RuntimeBeanReference> runtimeBeanReferences = new ManagedList<RuntimeBeanReference>();
        if (!ObjectUtils.isEmpty(beanNames)) {
            for (String beanName : beanNames) {
                runtimeBeanReferences.add(new RuntimeBeanReference(beanName));
            }
        }
        return runtimeBeanReferences;
    }

    private static Map<String, String> toMap(String[] strs) {
        Map<String, String> relust = new HashMap<>(strs.length);
        for (String string : strs) {
            int index = string.indexOf("=");
            if (index == -1) {
                relust.put(string, null);
            } else {
                relust.put(string.substring(0, index), string.substring(index + 1));
            }
        }
        return relust;
    }

    private static String toStr(String[] strs) {
        String str = null;
        for (String string : strs) {
            if (str == null) {
                str = string;
            } else {
                str += "," + string;
            }
        }
        return str;
    }
}
