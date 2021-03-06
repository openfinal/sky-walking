package org.skywalking.apm.api.plugin;

import org.skywalking.apm.api.plugin.interceptor.EnhancedClassInstanceContext;
import org.skywalking.apm.api.plugin.interceptor.enhance.*;

public class MockPluginInterceptor implements InstanceMethodsAroundInterceptor, StaticMethodsAroundInterceptor, InstanceConstructorInterceptor {
    @Override
    public void beforeMethod(StaticMethodInvokeContext interceptorContext, MethodInterceptResult result) {
    }

    @Override
    public Object afterMethod(StaticMethodInvokeContext interceptorContext, Object ret) {
        return ret + "_STATIC";
    }

    @Override
    public void handleMethodException(Throwable t, MethodInvokeContext interceptorContext) {
    }

    @Override
    public void beforeMethod(EnhancedClassInstanceContext context, InstanceMethodInvokeContext interceptorContext,
                             MethodInterceptResult result) {
    }

    @Override
    public Object afterMethod(EnhancedClassInstanceContext context, InstanceMethodInvokeContext interceptorContext,
                              Object ret) {
        return ret + String.valueOf(context.get("VALUE"));
    }

    @Override
    public void handleMethodException(Throwable t, EnhancedClassInstanceContext context,
                                      InstanceMethodInvokeContext interceptorContext) {
    }

    @Override
    public void onConstruct(EnhancedClassInstanceContext context, ConstructorInvokeContext interceptorContext) {
        context.set("VALUE", interceptorContext.allArguments()[0]);
    }
}
