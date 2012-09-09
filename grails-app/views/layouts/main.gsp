<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja" lang="ja">
  <head>
    <title>
      <g:layoutTitle default="イベント通知" />
    </title>
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}" />
    <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <g:layoutHead/>
  </head>
  <body onload="${pageProperty(name:'body.onload')};">
    <div id="spinner" class="spinner" style="display:none;">
      <img src="${createLinkTo(dir:'images',file:'spinner.gif')}" alt="Spinner" />
    </div>
    <div class="nav">
      <% root = '' %>
      <g:if env="development"><!-- 本番は(CloudBees環境)「/eventNotify」が必要ない -->
        <% root='/eventNotify' %>            
      </g:if>
      <span class="menuButton">
        <a href="${root}/bookmark">イベント検索</a>
      </span>
      <span class="menuButton">
        <a href="${root}/account">アカウント</a>
      </span>
    </div>
    <p/>
    <div>
      <g:layoutBody/>
    </div>
  </body>
</html>
