package com.maven01.web.security;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import com.maven01.web.util.util;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

	public ShiroFormAuthenticationFilter() {
        System.out.println("New MyFormAuthenticationFilter()");
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return super.onAccessDenied(request, response);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token,
                                     Subject subject,
                                     ServletRequest request,
                                     ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (!util.useAjax(httpServletRequest)) { //如果是正常的登陆成功
            issueSuccessRedirect(request, response);
        } else {
            // 使用 AJAX 登录成功返回的信息
            httpServletResponse.setCharacterEncoding("UTF-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.println("{success:true, message:'登录成功'}");
            out.flush();
            out.close();
        }

        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token,
                                     AuthenticationException e,
                                     ServletRequest request,
                                     ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (!util.useAjax(httpServletRequest)) {
            //login failed, let request continue back to the login page:
            setFailureAttribute(request, e);
            request.setAttribute("error", e.getMessage());
            return true;
        } else {
            try {
                // 使用 AJAX 登录失败返回的信息
                httpServletResponse.setCharacterEncoding("UTF-8");
                PrintWriter out =  httpServletResponse.getWriter();
                out.println("{success:false, message:'登录失败'}");
                out.flush();
                out.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            return false;
        }
    }

    // 身份认证：登录
    @Override
    protected boolean executeLogin(ServletRequest request,
                                   ServletResponse response) throws Exception {
        UsernamePasswordToken token = (UsernamePasswordToken) createToken(request, response);

        try {
            //doCaptchaValidate( (HttpServletRequest)request,token );

            Subject subject = getSubject(request, response);
            subject.login(token);

            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }

        // 可以提供更细节的登录失败信息
        // throw new LockedAccountException("Locked account"); //帐号锁定
    }
}
