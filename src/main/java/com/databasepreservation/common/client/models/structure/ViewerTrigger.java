/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE file at the root of the source
 * tree and available online at
 *
 * https://github.com/keeps/dbptk-ui
 */
package com.databasepreservation.common.client.models.structure;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Bruno Ferreira <bferreira@keep.pt>
 */
public class ViewerTrigger implements Serializable {
  @Serial
  private static final long serialVersionUID = -3192399748468823391L;
  private String name;
  private String actionTime;
  private String triggerEvent;
  private String aliasList;
  private String triggeredAction;
  private String description;

  public ViewerTrigger() {
  }

  public String getActionTime() {
    return actionTime;
  }

  public void setActionTime(String actionTime) {
    this.actionTime = actionTime;
  }

  public String getAliasList() {
    return aliasList;
  }

  public void setAliasList(String aliasList) {
    this.aliasList = aliasList;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTriggeredAction() {
    return triggeredAction;
  }

  public void setTriggeredAction(String triggeredAction) {
    this.triggeredAction = triggeredAction;
  }

  public String getTriggerEvent() {
    return triggerEvent;
  }

  public void setTriggerEvent(String triggerEvent) {
    this.triggerEvent = triggerEvent;
  }
}
