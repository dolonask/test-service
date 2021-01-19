package kg.easyit.testservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomURLFilter implements Filter {


    private String operationId;



    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }




    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String operId = request.getHeader("operationId");

        if (operId == null || !operId.equals(operationId)){
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, "The token is not valid.");
        }
        //call next filter in the filter chain
        filterChain.doFilter(request, response);
    }

}
