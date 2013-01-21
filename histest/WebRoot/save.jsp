<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>新增任务</title>
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
<s:form method="post" action="addYqjk.action" theme="simple">

<table width="80%" border="1" align="left" cellpadding="0" cellspacing="0">
<tr bgcolor="#353c44">
                <td height="30" colspan="3" valign="bottom"><div align="left"><img src="images/tb.gif" width="14" height="30" /><span class="STYLE1"><font size="+1">新增任务</font></span></div></td>
      </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">任务名称</span></div></td>
     <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
     <s:textfield name="yqjkxx.roleName"/>
    </span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19"><font color="#FF0000">*</font> &nbsp;&nbsp; 如：拆迁事件</span></div></td>
  </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">信息来源</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
  <s:iterator value="newslist"></s:iterator>
   <s:checkboxlist name="yqjkxx.newsResource" list="{'新闻','论坛','微博','贴吧','网页'}">
   <s:property value="news" /> 
   <s:property value="bbs" />
   <s:property value="weibo" />
   <s:property value="tieba" />
   <s:property value="netPage" />
   </s:checkboxlist>
 
   </span></div></td>

    <td rowspan="2" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19"></span></div>
  <div align="center"><span class="STYLE19">&nbsp;</span></div>
  </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">搜索方式</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">       
      <s:select name="yqjkxx.findStyle" list="{'标题&时间搜索','正文&相关度搜索'}"/>
      
      采集时段 
      <s:select name="yqjkxx.collectDate" list="{'当天','三天内','一周内','半个月内','三个月内','半年内'}"/>
    </span></div></td>
    </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">搜索条件</span></div></td>
   <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
      <s:textarea name="yqjkxx.collectCondition" />
    </span></div></td>
  <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19"><font color="#FF0000">*</font>  &nbsp;&nbsp; 如：广西 强拆
      其中&quot;广西 强拆&quot;表示搜索同时包含着两个词的文章。</span></div></td>
  </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">正文匹配词(可选)</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
      <s:textfield name="yqjkxx.contentMate" />
    </span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE19"><font color="#FF0000">*</font> &nbsp;&nbsp; 只支持单个词，建议匹配地名或机构名。</span></div></td>
  </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">定点网站采集(可选)</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
      &nbsp;&nbsp;&nbsp;<s:checkboxlist name="yqjkxx.Site_collection" list="{'启用'}"/>   
      <s:a href="www.baidu.com">点击维护定点网址库</s:a>
      
      
      </span></div></td>
    <td rowspan="3" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19"></span></div>
    <div align="center"><span class="STYLE19">&nbsp;</span></div>      <div align="center"><span class="STYLE19">&nbsp;</span></div>
  </tr>
  <tr>
    <td width="183" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">任务状态</span></div>      
      </td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19"><s:radio name="yqjkxx.roleState" list="{'启用','停用'}" value="启用" />
      </span></div></td>
    </tr>
  <tr>
   <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">&nbsp;</span></div></td>
    <td height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">
      <input type="submit" name="20" id="20" value="提交" />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="23" id="23" value="重置" />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="32" id="32" value="取消" />
    </span></div></td> 
     </tr>
</table>
</s:form>
</center>
</body>
</html>
