package com.elegant.codes.common.exception;


import org.apache.commons.lang3.StringUtils;

public class SystemException extends AbstractException{
    private ErrorInfo errorCode;
    /**
     * 本地错误描述信息,其优先级高于{@link ErrorInfo}中的errorDesc,即如果该值不为空,则以该值为准
     */
    private String errorDesc;

    /**
     * @param errorCode 枚举的错误码类型,其中包含了错误码和对应的错误码描述信息.
     */
    public SystemException(SystemErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode 枚举的错误码类型,其中包含了错误码和对应的错误码描述信息.
     * @param message   最好是自定义的详细描述信息,用于打日志,也可以和{@link ErrorInfo#getErrorDesc()}相同
     */
    public SystemException(SystemErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode 枚举的错误码类型,其中包含了错误码和对应的错误码描述信息.
     */
    public SystemException(SystemErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode 枚举的错误码类型,其中包含了错误码和对应的错误码描述信息.
     * @param message   最好是自定义的详细描述信息,用于打日志,也可以和{@link ErrorInfo#getErrorDesc()}相同
     */
    public SystemException(SystemErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorCode() {
        return errorCode.getErrorCode();
    }

    /**
     * 获取错误码对应的描述信息.
     * <p>
     *   如果本地对该描述信息进行设置,则本地的优先,否则自动从错误码系统获取错误码对应的描述信息.
     * </p>
     * @return 错误码对应的描述信息
     */
    @Override
    public String getErrorDesc() {
        if (!StringUtils.isEmpty(errorDesc)) {
            return errorDesc;
        }
        return errorCode.getErrorDesc();
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (StringUtils.isEmpty(message)) {
            message = this.getErrorDesc();
        }
        return message;
    }
}
