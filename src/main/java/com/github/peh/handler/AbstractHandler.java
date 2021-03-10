package com.github.peh.handler;

import com.github.peh.context.ExecutorContextHolder;
import com.github.peh.context.ParamContextHolder;
import com.github.peh.context.ProcessorContextHolder;
import com.github.peh.executor.IExecutor;

/**
 * @author: <a href=mailto:keycasiter@qq.com>guanjian</a>
 * @date: 2021/02/26 15:55
 * @description: 处理器抽象类
 */
public abstract class AbstractHandler implements IHandler {

    /**
     * 执行体名称
     */
    private String handlerName = "default handler";

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    //context variable method

    public static void setVariable(Object key, Object value) {
        ParamContextHolder.put(key, value);
    }

    public static Object getVariable(Object key) {
        return ParamContextHolder.get(key);
    }

    public static <C> C getVariable(Object key, Class<C> clazz) {
        return ParamContextHolder.get(key, clazz);
    }

    //context executor method

    public static boolean executorAvailable(IExecutor executor) {
        return ExecutorContextHolder.available(executor);
    }

    public static void enableExecutor(IExecutor executor, String executorName) {
        ExecutorContextHolder.enable(executor, executorName);
    }

    public static void enableExecutor(IExecutor executor) {
        enableExecutor(executor, "");
    }

    public static void unableExecutor(IExecutor executor, String executorName) {
        ExecutorContextHolder.unable(executor, executorName);
    }

    public static void unableExecutor(IExecutor executor) {
        unableExecutor(executor, "");
    }

    //context process method

    public static boolean processorAvailable() {
        return ProcessorContextHolder.available();
    }

    public static void unableProcessor(String handlerNode) {
        ProcessorContextHolder.unable(handlerNode);
    }

    public static void unableProcessor() {
        unableProcessor("");
    }

    public static void enableProcessor(String handlerNode) {
        ProcessorContextHolder.enable(handlerNode);
    }

    public static void enableProcessor() {
        enableProcessor("");
    }
}
