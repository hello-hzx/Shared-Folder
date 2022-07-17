package com.jon;

/**
 * @author jmingemail@qq.com
 * @date 2022/7/16
 */
public class ActionConfig {
    private String className;
    private String methodName;

    public ActionConfig() {
    }

    public ActionConfig(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    public ActionConfig(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return "ActionConfig{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
