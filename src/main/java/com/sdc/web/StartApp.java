/**
 * Main.java
 */
package com.sdc.web;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import com.sdc.web.ws.Test;

/**
 * @author simone.decristofaro
 *         May 22, 2017
 */
public class StartApp {

    private static final Logger LOG = Logger.getLogger(StartApp.class);
    
    public static void main(String[] args){
        
        Server server = new Server(8080);

        ServletContextHandler ctx = 
                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
                
        ctx.setContextPath("/");
        server.setHandler(ctx);

        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/mdf/rest/*");
        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.classnames", 
                Test.class.getCanonicalName());

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            LOG.fatal("Error waiting for requests", ex);
        } finally {

            server.destroy();
        }
    }
}
