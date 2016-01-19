<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<!-- saved from url=(0050)http://lab2023.github.io/hierapolis/dashboard.html -->
<html class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths" lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
  <title>Dashboard</title>
  <link href="${BASE}/asset/lib/application/application.css" rel="stylesheet" type="text/css">
  <link href="${BASE}/asset/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body class="main page" cz-shortcut-listen="true">
  <!-- Navbar -->
  <div class="navbar navbar-default" id="navbar">
    <a class="navbar-brand" href="http://lab2023.github.io/hierapolis/dashboard.html#"> <i class="fa fa-beer"></i>
      Hierapolis
    </a>
    <ul class="nav navbar-nav pull-right">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="http://lab2023.github.io/hierapolis/dashboard.html#"> <i class="fa fa-envelope"></i>
          Messages
          <span class="badge">5</span> <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li>
            <a href="http://lab2023.github.io/hierapolis/dashboard.html#">New message</a>
          </li>
          <li>
            <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Inbox</a>
          </li>
          <li>
            <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Out box</a>
          </li>
          <li>
            <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Trash</a>
          </li>
        </ul>
      </li>
      <li>
        <a href="http://lab2023.github.io/hierapolis/dashboard.html#">
          <i class="fa fa-cog"></i>
          Settings
        </a>
      </li>
      <li class="dropdown user">
        <a class="dropdown-toggle" data-toggle="dropdown" href="http://lab2023.github.io/hierapolis/dashboard.html#">
          <i class="fa fa-user"></i> <strong>John DOE</strong>
          <img class="img-rounded" src="./asset/777"> <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li>
            <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Edit Profile</a>
          </li>
          <li class="divider"></li>
          <li>
            <a href="http://lab2023.github.io/">Sign out</a>
          </li>
        </ul>
      </li>
    </ul>
  </div>
  <div id="wrapper">
    <!-- Sidebar -->
    <section id="sidebar">
      <i class="fa fa-align-justify fa fa-large" id="toggle"></i>
      <ul id="dock">
        <li class="active launcher">
          <i class="fa fa-tachometer"></i>
          <a href="./asset/Dashboard.html">Dashboard</a>
        </li>
        <li class="launcher">
          <i class="fa fa-file-text-alt"></i>
          <a href="http://lab2023.github.io/hierapolis/forms.html">Forms</a>
        </li>
        <li class="launcher">
          <i class="fa fa-table"></i>
          <a href="http://lab2023.github.io/hierapolis/tables.html">Tables</a>
        </li>
        <li class="launcher dropdown hover">
          <i class="fa fa-flag"></i>
          <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Reports</a>
          <ul class="dropdown-menu">
            <li class="dropdown-header">Launcher description</li>
            <li>
              <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Action</a>
            </li>
            <li>
              <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Another action</a>
            </li>
            <li>
              <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Something else here</a>
            </li>
          </ul>
        </li>
        <li class="launcher">
          <i class="fa fa-bookmark"></i>
          <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Bookmarks</a>
        </li>
        <li class="launcher">
          <i class="fa fa-cloud"></i>
          <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Backup</a>
        </li>
        <li class="launcher">
          <i class="fa fa-bug"></i>
          <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Feedback</a>
        </li>
      </ul>
      <div data-toggle="tooltip" id="beaker" title="" data-original-title="Made by lab2023"></div>
    </section>
    <!-- Tools -->
    <section id="tools">
      <ul class="breadcrumb" id="breadcrumb">
        <li class="title">Dashboard</li>
        <li>
          <a href="http://lab2023.github.io/hierapolis/dashboard.html#">Lorem</a>
        </li>
        <li class="active">
          <a href="http://lab2023.github.io/hierapolis/dashboard.html#">ipsum</a>
        </li>
      </ul>
      <div id="toolbar">
        <div class="btn-group">
          <a class="btn" data-toggle="toolbar-tooltip" href="http://lab2023.github.io/hierapolis/dashboard.html#" title="" data-original-title="Building">
            <i class="fa fa-building"></i>
          </a>
          <a class="btn" data-toggle="toolbar-tooltip" href="http://lab2023.github.io/hierapolis/dashboard.html#" title="" data-original-title="Laptop">
            <i class="fa fa-laptop"></i>
          </a>
          <a class="btn" data-toggle="toolbar-tooltip" href="http://lab2023.github.io/hierapolis/dashboard.html#" title="" data-original-title="Calendar">
            <i class="fa fa-calendar"></i>
            <span class="badge">3</span>
          </a>
          <a class="btn" data-toggle="toolbar-tooltip" href="http://lab2023.github.io/hierapolis/dashboard.html#" title="" data-original-title="Lemon">
            <i class="fa fa-lemon"></i>
          </a>
        </div>
        <div class="label label-danger">Danger</div>
        <div class="label label-info">Info</div>
      </div>
    </section>
    <!-- Content -->

  </div>
  <!-- Footer -->
  <!-- Javascripts -->
  <script src="${BASE}/asset/lib/jquery/jquery-1.12.0.js" type="text/javascript"></script>
  <script src="${BASE}/asset/lib/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
  <script src="${BASE}/asset/lib/modernizr/modernizr.min.js" type="text/javascript"></script>
  <script src="${BASE}/asset/lib/application/application.js" type="text/javascript"></script>
</body>
</html>