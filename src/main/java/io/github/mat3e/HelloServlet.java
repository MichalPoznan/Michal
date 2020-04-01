package io.github.mat3e;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "HelloServletName", urlPatterns = {"/api/*"})
public class HelloServlet extends HttpServlet {
    private static final String PARAM_NAME = "name";
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        logger.info("Got request with parameters " + req.getParameterMap());
        var name = Optional.ofNullable(req.getParameter(PARAM_NAME)).orElse("world");
        resp.getWriter().write("Hello " + name + "!");
    }
}

