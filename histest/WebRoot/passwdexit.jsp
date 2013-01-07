<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>修改密码 </title>
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
<left>
<form id="form1" name="form1" method="post" action="">
<table width="60%" border="1">
<tr bgcolor="#353c44">
                <td height="20" colspan="3" valign="bottom"><div align="left"><img src="images/tb.gif" width="14" height="30" /><span class="STYLE1"><font size="+1">修改密码</font></span></div></td>
      </tr>
  <tr>
    <td width="383" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用户名</span></div></td>
    <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19">
      <input name="username" type="text" id="username" size="30"></span></div>
   </td>
  </tr>
  <tr>
    <td width="383" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">旧密码</span></div></td>
    <td height="20" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19">
      <input name="password" type="text" id="password" size="30"></span></div>
    </td>
  </tr>
  <tr>
    <td width="383" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">新密码</span></div></td>
    <td height="20" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19">
      <input name="password2" type="text" id="password2" size="30"></span></div>
    </td>
  </tr>
  <tr>
    <td height="20" colspan="2" bgcolor="d3eaef" class="STYLE6"><input type="submit" name="submit" id="submit" value="提交" />
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" name="reset" id="reset" value="重置" /></td>
    </tr>
</table>
</form>
</left>
</body>
</html>
