package com.elegant.codes.common.exception;

/**
 * 1xx：信息响应类，表示接收到请求并且继续处理
 * 2xx：处理成功响应类，表示动作被成功接收、理解和接受
 * 3xx：重定向响应类，为了完成指定的动作，必须接受进一步处理
 * 4xx：客户端错误，客户请求包含语法错误或者是不能正确执行
 * 5xx：服务端错误，服务器不能正确执行一个正确的请求
 *
 * 100——客户必须继续发出请求
 * 101——客户要求服务器根据请求转换HTTP协议版本
 *
 * 200——交易成功
 * 201——提示知道新文件的URL
 * 202——接受和处理、但处理未完成
 * 203——返回信息不确定或不完整
 * 204——请求收到，但返回信息为空
 * 205——服务器完成了请求，用户代理必须复位当前已经浏览过的文件
 * 206——服务器已经完成了部分用户的GET请求
 *
 * 300——请求的资源可在多处得到
 * 301——删除请求数据
 * 302——在其他地址发现了请求数据
 * 303——建议客户访问其他URL或访问方式
 * 304——客户端已经执行了GET，但文件未变化
 * 305——请求的资源必须从服务器指定的地址得到
 * 306——前一版本HTTP中使用的代码，现行版本中不再使用
 * 307——申明请求的资源临时性删除
 *
 * 400——错误请求，如语法错误
 * 401——请求授权失败
 * 402——保留有效ChargeTo头响应
 * 403——请求不允许
 * 404——没有发现文件、查询或URl
 * 405——用户在Request-Line字段定义的方法不允许
 * 406——根据用户发送的Accept拖，请求资源不可访问
 * 407——类似401，用户必须首先在代理服务器上得到授权
 * 408——客户端没有在用户指定的饿时间内完成请求
 * 409——对当前资源状态，请求不能完成
 * 410——服务器上不再有此资源且无进一步的参考地址
 * 411——服务器拒绝用户定义的Content-Length属性请求
 * 412——一个或多个请求头字段在当前请求中错误
 * 413——请求的资源大于服务器允许的大小
 * 414——请求的资源URL长于服务器允许的长度
 * 415——请求资源不支持请求项目格式
 * 416——请求中包含Range请求头字段，在当前请求资源范围内没有range指示值，请求也不包含If-Range请求头字段
 * 417——服务器不满足请求Expect头字段指定的期望值，如果是代理服务器，可能是下一级服务器不能满足请求
 *
 * 500——服务器产生内部错误
 * 501——服务器不支持请求的函数
 * 502——服务器暂时不可用，有时是为了防止发生系统过载
 * 503——服务器过载或暂停维修
 * 504——关口过载，服务器使用另一个关口或服务来响应用户，等待时间设定值较长
 * 505——服务器不支持或拒绝支请求头中指定的HTTP版本
 */
public interface ClientErrorCode extends ErrorInfo{
    enum Code implements ClientErrorCode {
        /**
         * 参数错误(可以笼统的将所有参数错误都包含在内,并重新定义错误描述,一般用于框架参数自定义错误验证)
         */
        PARAMS_ERROR("400100", "参数错误");

        Code(String errorCode, String errorDesc) {
            this.errorCode = errorCode;
            this.errorDesc = errorDesc;
        }

        /**
         * 错误码.
         */
        public String errorCode;
        /**
         * 错误码对应的外部描述信息,该信息是通过错误码自动获取,并且直接返回给调用方.
         */
        public String errorDesc;

        @Override
        public String getErrorCode() {
            return errorCode;
        }

        @Override
        public String getErrorDesc() {
            return errorDesc;
        }
    }

    /**
     * 快速构建一个自定义错误描述错误信息对象.
     * 一般用于相同的错误码,但是不同的错误描述信息(类似).
     * 比如常见的参数错误,但是可以使用参数错误的通用错误码在描述中提示调用者更具体的错误描述.
     * @return 使用自定义描述替换原有描述的信息对象副本
     */
    default ClientErrorCode as(String desc) {
        ErrorInfo errorInfo = this;
        return new ClientErrorCode() {
            @Override
            public String getErrorCode() {
                return errorInfo.getErrorCode();
            }

            @Override
            public String getErrorDesc() {
                return desc;
            }
        };
    }
}
