package site.xiaokui.spring.web;

import site.xiaokui.spring.core.PatternMatchUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author HK
 * @date 2020-04-01 19:18
 */
public class MappingHandler {

    private String[] parentUrl, sonUrl;

    private Object controllerObj;

    private Method invokeMethod;

    public MappingHandler(String[] parentUrl, String[] sonUrl, Object controllerObj, Method invokeMethod){
        this.parentUrl = parentUrl;
        this.sonUrl = sonUrl;
        this.controllerObj = controllerObj;
        this.invokeMethod = invokeMethod;
    }

    public boolean matchUrl(String url) {
        for (String p : parentUrl) {
            for (String s : sonUrl) {
                System.out.println(p + s + "-" + url + PatternMatchUtils.simpleMatch(p  + s, url));
                return PatternMatchUtils.simpleMatch(p  + s, url);
            }
        }
        return false;
    }

    /**
     * TODO 暂时支持空方法
     */
    public Object invokeRequestMethod() {
        try {
            invokeMethod.setAccessible(true);
            return invokeMethod.invoke(controllerObj, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
