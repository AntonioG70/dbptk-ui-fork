/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE file at the root of the source
 * tree and available online at
 *
 * https://github.com/keeps/dbptk-ui
 */
package com.databasepreservation.common.server;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.databasepreservation.common.server.index.factory.SolrClientFactory;


@SuppressWarnings("serial")
public class BrowserServiceImpl extends HttpServlet {
  private static final Logger LOGGER = LoggerFactory.getLogger(BrowserServiceImpl.class);

  @Override
  public void init() throws ServletException {
    super.init();
    new Thread(SolrClientFactory::get).start();
  }

  /**
   * Called by the servlet container to indicate to a servlet that the servlet is
   * being taken out of service.
   */
  @Override
  public void destroy() {
    super.destroy();

    try {
      SolrClientFactory.get().getSolrClient().close();
    } catch (IOException e) {
      LOGGER.error("Stopping SolrClient", e);
    }

    // TODO stop Quartz Scheduler

  }
}
