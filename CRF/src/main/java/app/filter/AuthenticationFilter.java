package app.filter;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 52400 on 2017/6/20.
 */

@Component
public class AuthenticationFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response,
                                      Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
            throws Exception {
//        Subject subject = SecurityUtils.getSubject();
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        String uri = httpRequest.getRequestURI();
//        String curUrl = getRequestUrl(request);
//
//        if ((subject.getPrincipals() == null
//                || StringUtils.endsWithAny(curUrl, ".js", ".css", ".html", ".woff", ".ttf",
//                ".woff2")
//                || StringUtils.endsWithAny(curUrl, ".jpg", ".png", ".gif", ".jpeg"))) {
//            return true;
//        } else if (uri.contains("login") || uri.contains("logout") || subject.isAuthenticated()) {
//            return true;
//        } else {
//            httpResponse.getWriter()
//                    .write("{\"errorMessage\": \"user not login or session time out\"}");
//            httpResponse.setStatus(401);
//            httpResponse.setContentType("application/json");
//            return false;
//        }
        return true;
    }

    private String getRequestUrl(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        String queryString = req.getQueryString();
        queryString = StringUtils.isBlank(queryString) ? "" : "?" + queryString;
        return req.getRequestURI() + queryString;
    }
}
