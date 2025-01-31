/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE file at the root of the source
 * tree and available online at
 *
 * https://github.com/keeps/dbptk-ui
 */
package com.databasepreservation.server.client.main;

import java.util.List;
import java.util.Map;

import com.databasepreservation.common.api.v1.utils.StringResponse;
import com.databasepreservation.common.client.ClientConfigurationManager;
import com.databasepreservation.common.client.ClientLogger;
import com.databasepreservation.common.client.common.utils.ApplicationType;
import com.databasepreservation.common.client.services.ContextService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Bruno Ferreira <bferreira@keep.pt>
 */
public class Main implements EntryPoint {
  private ClientLogger logger = new ClientLogger(getClass().getName());

  private MainPanel mainPanel;
  private Footer footer;

  /**
   * Create a new main
   */
  public Main() {
    footer = new Footer();
  }

  /**
   * The entry point method, called automatically by loading a module that
   * declares an implementing class as an entry point.
   */
  @Override
  public void onModuleLoad() {
    ContextService.Util.call((StringResponse env) -> {
      GWT.log("Recived");
      ApplicationType.setType(env.getValue());
      // Set uncaught exception handler
      ClientLogger.setUncaughtExceptionHandler();

      ContextService.Util.call((Map<String, List<String>> sharedProperties) -> {
        ClientConfigurationManager.initialize(sharedProperties);

        // Remove loading image
        RootPanel.getBodyElement().removeChild(DOM.getElementById("loading"));

        mainPanel = new MainPanel();
        RootPanel.get().add(mainPanel);
        RootPanel.get().add(footer);
        RootPanel.get().addStyleName("roda");

        mainPanel.onHistoryChanged(History.getToken());
        History.addValueChangeHandler(event -> mainPanel.onHistoryChanged(event.getValue()));
      }).getSharedProperties(LocaleInfo.getCurrentLocale().getLocaleName());
    }).getEnvironment();
  }
}
