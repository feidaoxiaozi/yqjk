<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户信息修改</title>

<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
-->
</style>
</head>

<body>
<s:form method="post" action="updateUser.action" theme="simple">
<table width="920" height="156" border="1">
<tr bgcolor="#353c44">
                <td height="30" colspan="3" valign="bottom"><div align="left"><img src="images/tb.gif" width="14" height="30" /><span class="STYLE1"><font size="+1">用户信息修改</font></span></div></td>
      </tr>
      <tr>               
           <td><s:hidden name="user.userId" value="%{user.userId}"></s:hidden></td>
      </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用&nbsp;户&nbsp;名</span></div></td>    
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
    <s:textfield name="user.username" value="%{user.username}"/></span></div></td>    
  </tr>
   <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">电子邮件</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
      <s:textfield name="user.email" value="%{user.email}"/></span></div>
   </td>
    
  </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
      <s:textfield name="user.age" value="%{user.age}"/></span></div>
    </td>    
  </tr> 
  <tr>
    <td height="30" colspan="3" bgcolor="d3eaef" class="STYLE6" align="center"><s:submit value="修改"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
     <s:reset id="reset" value="重置" /></td>
    </tr>
</table>
</s:form>
</body>
</html>
