<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Dashboard</title>
</head>
<body class="main page" cz-shortcut-listen="true">
    <div id="content">
      <div class="panel panel-default">
        <div class="panel-heading">
          <i class="fa fa-beer fa fa-large"></i>
          Hierapolis Rocks!
          <div class="panel-tools">
            <div class="btn-group">
              <a class="btn" href="http://lab2023.github.io/hierapolis/dashboard.html#">
                <i class="fa fa-refresh"></i>
                Refresh statics
              </a>
              <a class="btn" data-toggle="toolbar-tooltip" href="http://lab2023.github.io/hierapolis/dashboard.html#" title="" data-original-title="Toggle">
                <i class="fa fa-chevron-down"></i>
              </a>
            </div>
          </div>
        </div>
        <div class="panel-body">
          <div class="page-header">
            <h4>System usage</h4>
          </div>
          <div class="progress">
            <div class="progress-bar progress-bar-success" style="width: 35%"></div>
            <div class="progress-bar progress-bar-warning" style="width: 20%"></div>
            <div class="progress-bar progress-bar-danger" style="width: 10%"></div>
          </div>
          <div class="page-header">
            <h4>User statics</h4>
          </div>
          <div class="row text-center">
            <div class="col-md-3">
              <div style="display:inline;width:140px;height:140px;">
                <canvas width="140" height="140px"></canvas>
                <input class="knob second" data-bgcolor="#d4ecfd" data-fgcolor="#30a1ec" data-height="140" data-inputcolor="#333" data-thickness=".3" data-width="140" type="text" value="50" style="width: 74px; height: 46px; position: absolute; vertical-align: middle; margin-top: 46px; margin-left: -107px; border: 0px; font-weight: bold; font-style: normal; font-variant: normal; font-stretch: normal; font-size: 28px; line-height: normal; font-family: Arial; text-align: center; color: rgb(51, 51, 51); padding: 0px; -webkit-appearance: none; background: none;"></div>
            </div>
            <div class="col-md-3">
              <div style="display:inline;width:140px;height:140px;">
                <canvas width="140" height="140px"></canvas>
                <input class="knob second" data-bgcolor="#c4e9aa" data-fgcolor="#8ac368" data-height="140" data-inputcolor="#333" data-thickness=".3" data-width="140" type="text" value="75" style="width: 74px; height: 46px; position: absolute; vertical-align: middle; margin-top: 46px; margin-left: -107px; border: 0px; font-weight: bold; font-style: normal; font-variant: normal; font-stretch: normal; font-size: 28px; line-height: normal; font-family: Arial; text-align: center; color: rgb(51, 51, 51); padding: 0px; -webkit-appearance: none; background: none;"></div>
            </div>
            <div class="col-md-3">
              <div style="display:inline;width:140px;height:140px;">
                <canvas width="140" height="140px"></canvas>
                <input class="knob second" data-bgcolor="#cef3f5" data-fgcolor="#5ba0a3" data-height="140" data-inputcolor="#333" data-thickness=".3" data-width="140" type="text" value="35" style="width: 74px; height: 46px; position: absolute; vertical-align: middle; margin-top: 46px; margin-left: -107px; border: 0px; font-weight: bold; font-style: normal; font-variant: normal; font-stretch: normal; font-size: 28px; line-height: normal; font-family: Arial; text-align: center; color: rgb(51, 51, 51); padding: 0px; -webkit-appearance: none; background: none;"></div>
            </div>
            <div class="col-md-3">
              <div style="display:inline;width:140px;height:140px;">
                <canvas width="140" height="140px"></canvas>
                <input class="knob second" data-bgcolor="#f8d2e0" data-fgcolor="#b85e80" data-height="140" data-inputcolor="#333" data-thickness=".3" data-width="140" type="text" value="85" style="width: 74px; height: 46px; position: absolute; vertical-align: middle; margin-top: 46px; margin-left: -107px; border: 0px; font-weight: bold; font-style: normal; font-variant: normal; font-stretch: normal; font-size: 28px; line-height: normal; font-family: Arial; text-align: center; color: rgb(51, 51, 51); padding: 0px; -webkit-appearance: none; background: none;"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
</body>