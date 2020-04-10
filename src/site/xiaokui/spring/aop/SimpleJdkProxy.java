package site.xiaokui.spring.aop;

import site.xiaokui.spring.core.util.LogUtil;

/**
 * @author HK
 * @date 2019-09-01 15:09
 */
public class SimpleJdkProxy extends JdkProxy {

    private LogUtil log = LogUtil.getLogger(this.getClass());

    @Override
    public IProxy newProxy() {
        return new SimpleJdkProxy();
    }

    @Override
    public void preRequest() {
        log.debug("代理对象方法调用前");
    }

    @Override
    public void postRequest() {
        log.debug("代理对象方法调用后");
    }
}
