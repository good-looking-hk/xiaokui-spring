package site.xiaokui.spring.web.server;

/**
 * 简单实现
 * @author HK
 * @date 2020-04-01 16:16
 */
public class HttpResponse {

    private String msg;

    public HttpResponse() {
    }

    public HttpResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
