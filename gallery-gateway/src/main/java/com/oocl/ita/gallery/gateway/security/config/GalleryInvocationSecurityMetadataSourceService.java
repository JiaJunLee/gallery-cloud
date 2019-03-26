package com.oocl.ita.gallery.gateway.security.config;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.oocl.ita.gallery.common.model.Role;
import com.oocl.ita.gallery.common.model.SimplePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.Permissions;
import java.util.*;

@Component
public class GalleryInvocationSecurityMetadataSourceService implements
        FilterInvocationSecurityMetadataSource {

    private HashMap<String, Collection<ConfigAttribute>> map = null;
    private HashMap<String, String> operationMap = new HashMap<>();
    private final String roleFileName = "roles.json";
    private List<Role> permissions = new ArrayList<>();


    public void init() {
        operationMap.put(HttpMethod.GET.name(), "read");
        operationMap.put(HttpMethod.POST.name(), "write");
        operationMap.put(HttpMethod.PUT.name(), "update");
        operationMap.put(HttpMethod.DELETE.name(), "delete");

        Type roleTokenType = new TypeToken<ArrayList<Role>>() {
        }.getType();
        InputStream roleInputStream = getClass().getClassLoader().getResourceAsStream(roleFileName);
        ArrayList<Role> roles = new GsonBuilder().create().fromJson(new InputStreamReader(roleInputStream, StandardCharsets.UTF_8), roleTokenType);
        for (Role role : roles) {
            permissions.add(role);
        }
    }


    public void loadResourceDefine() {
        init();
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        for (Role role : permissions) {
            array = new ArrayList<>();
            cfg = new org.springframework.security.access.SecurityConfig(role.getName());
            //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
            array.add(cfg);
            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
            for (SimplePermission simplePermission : role.getPermissions()) {
                for (String operation : simplePermission.getPrivileges().keySet()) {
                    map.put(simplePermission.getResource() + "-" + operation, array);
                }
            }
        }
    }

    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null) loadResourceDefine();
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
