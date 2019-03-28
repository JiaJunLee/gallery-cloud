package com.oocl.ita.gallery.common.log.model;

import java.util.Date;

public class RuntimeInformation {

  private String tag;
  private String applicationName;
  private String className;
  private String method;
  private String requestUrl;
  private String requestMethod;
  private String cookies;
  private Date begin;
  private Date end;
  private Long cost;
  private String exceptionMessage;
  private String exceptionStack;

  public RuntimeInformation() {
    this.begin = new Date();
  }

  public void complete() {
    this.end = new Date();
    this.cost = this.end.getTime() - this.begin.getTime();
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getRequestUrl() {
    return requestUrl;
  }

  public void setRequestUrl(String requestUrl) {
    this.requestUrl = requestUrl;
  }

  public String getRequestMethod() {
    return requestMethod;
  }

  public void setRequestMethod(String requestMethod) {
    this.requestMethod = requestMethod;
  }

  public String getCookies() {
    return cookies;
  }

  public void setCookies(String cookies) {
    this.cookies = cookies;
  }

  public Date getBegin() {
    return begin;
  }

  public void setBegin(Date begin) {
    this.begin = begin;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public Long getCost() {
    return cost;
  }

  public void setCost(Long cost) {
    this.cost = cost;
  }

  public String getExceptionMessage() {
    return exceptionMessage;
  }

  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  public String getExceptionStack() {
    return exceptionStack;
  }

  public void setExceptionStack(String exceptionStack) {
    this.exceptionStack = exceptionStack;
  }
}
