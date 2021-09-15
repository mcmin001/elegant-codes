package com.elegant.codes.common.exception;

public interface ErrorInfo {
    /**
     * 获取异常对应的错误码.
     *
     * @return 错误码系统定义的错误码
     */
    String getErrorCode();

    /**
     * 获取错误码对应的描述信息.
     * <p>
     *   如果本地对该描述信息进行设置,则本地的优先,否则自动从错误码系统获取错误码对应的描述信息.
     * </p>
     * @return 错误码对应的描述信息
     */
    String getErrorDesc();

}
