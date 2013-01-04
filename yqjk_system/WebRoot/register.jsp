<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<title>用户注册</title>
<script language="javascript">
       function checkReg(){
	   var usernameValue = document.getElementbyId("usernameId").value;
	   var password = document.getElementById("passwordId").value;  
	   var repassword = document.getElementById("repasswordId").value;	   
	   var email = document.getElementById("emailId").value;
	   var age = document.getElementById("ageId").value;
	  if(usernameValue==0) 
	  {
		 alert("用户名不能为空!");
		 return false;
	  }else if(usernameValue.length>12||usernameValue.length<6)
	  {
		 alert("用户名长度必须在6到12位之间!");
		 return false;
		  }
		  if(password==""||password==null){
			   alert("密码不能为空!");
			   return false;
			  }
			  else if(password.length>12||password.length<8){
			  alert("密码长度必须在6到12位之间!");
			   return false;
			  }
			  if(repassword==""||repassword==null){
			   alert("重复密码不能为空!");
			   return false;
			  }
			  else if(repassword.length>12||repassword.length<8){
			  alert("重复密码长度必须在6到12位之间!");
			   return false;
			  }
			  if(repassword != password){
				 alert("重复密码与密码必须一致!");
			   return false; 
				}  
			      if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))){ 
				     alert("不是一个有效的邮件地址.请重新输入");   
					 return false;  
					 	
					 }if(age>80|| age<16){
					   alert("年龄不合法!");
			           return false;
					  }			 				
				 return true;
		   }
</script>
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

<center>
<table border="0">
<tr>
  <td>
<span class="STYLE19"><font color="#FF0000"><s:fielderror cssStyle="color:red"></s:fielderror></font></span>
</td>
</tr>
</table>
<center>

<s:form method="post" action="addUser.action" theme="simple" validate="true">
<table width="920" height="156" border="1">
<tr bgcolor="#353c44">
                <td height="30" colspan="3" valign="bottom"><div align="left"><img src="images/tb.gif" width="14" height="30" /><span class="STYLE1"><font size="+1">用户注册</font></span></div></td>
      </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">用&nbsp;户&nbsp;名</span></div></td>    
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19"><s:textfield name="user.username"  id="usernameId" size="30"/></span></div></td>    
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19"><font color="#FF0000">*</font> &nbsp;&nbsp;  用户名不能少于6位，汉字、英文、数字均可，数字不能做开头。</span></div></td>
  </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
      <s:password name="user.password" id="passwordId" size="30"/></span></div>
    </td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19"><font color="#FF0000">*</font> &nbsp;&nbsp; 密码不能少于6位，必须同时包含英文、数字和特殊字符。</span></div></td>
  </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">重复密码</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
      <s:password name="user.repassword" id="repasswordId" size="30"/></span></div>
    </td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19"><font color="#FF0000">*</font>  &nbsp;&nbsp;必须和密码完全一致。</span></div></td>
  </tr>
  
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">电子邮件</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
      <s:textfield name="user.email" id="emailId" size="30"/></span></div>
   </td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19"><font color="#FF0000">*</font>  &nbsp;&nbsp;电子邮件必须有效、合法。</span></div></td>
  </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
      <s:textfield name="user.age" id="ageId" size="30"/></span></div>
    </td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19"><font color="#FF0000">*</font> &nbsp;&nbsp; 年龄介于16岁到80岁之间。</span></div></td>
  </tr>
  <tr>
    <td height="30" colspan="3" bgcolor="d3eaef" class="STYLE6" align="center"><s:submit value="提交"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
     <s:reset id="reset" value="重置" /></td>
    </tr>
</table>
</s:form>
</body>
</html>