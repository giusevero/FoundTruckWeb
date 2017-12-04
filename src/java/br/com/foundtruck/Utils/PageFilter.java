/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foundtruck.Utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author giusevero
 */
public class PageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession sess = ((HttpServletRequest) request).getSession(true);

        String newCurrentPage = ((HttpServletRequest) request).getServletPath();

        if (sess.getAttribute("currentPage") == null) {
            sess.setAttribute("lastPage", newCurrentPage);
            sess.setAttribute("currentPage", newCurrentPage);
        } else {

            String oldCurrentPage = sess.getAttribute("currentPage").toString();
            if (!oldCurrentPage.equals(newCurrentPage)) {
                sess.setAttribute("lastPage", oldCurrentPage);
                sess.setAttribute("currentPage", newCurrentPage);
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }

}
