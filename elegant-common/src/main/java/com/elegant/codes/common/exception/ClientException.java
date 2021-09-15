package com.elegant.codes.common.exception;

public class ClientException extends AbstractException{

    private ErrorInfo errorCode;
    /**
     * 本地错误描述信息,其优先级高于{@link ErrorInfo}中的errorDesc,即如果该值不为空,则以该值为准
     */
    private String errorDesc;

    /**
     * @param errorCode 枚举的错误码类型,其中包含了错误码和对应的错误码描述信息.
     */
    public ClientException(ClientErrorCode errorCode) {
        super(errorCode.getErrorDesc());
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode 枚举的错误码类型,其中包含了错误码和对应的错误码描述信息.
     * @param message   最好是自定义的详细描述信息,用于打日志,也可以和{@link ErrorInfo#getErrorDesc()}相同
     */
    public ClientException(ClientErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode 枚举的错误码类型,其中包含了错误码和对应的错误码描述信息.
     */
    public ClientException(ClientErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode 枚举的错误码类型,其中包含了错误码和对应的错误码描述信息.
     * @param message   最好是自定义的详细描述信息,用于打日志,也可以和{@link ErrorInfo#getErrorDesc()}相同
     */
    public ClientException(ClientErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorDesc() {
        return null;
    }
}
