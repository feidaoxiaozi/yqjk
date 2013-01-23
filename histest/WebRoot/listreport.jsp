
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
  <title>悟空舆情监控系统</title>
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
<script type="text/javascript">

var  highlightcolor='#d5f4fe';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>


</head>

<body>
  <s:form action="addYqjk" method="post">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="30" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> <font size="+1">舆情监控管理系统信息列表</font></span></td>
              </tr>
            </table></td>

        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"  onmouseout="changeback()">
      <tr>
       
       
        <td width="10%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">标题</span></div></td>
        <td width="12%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">URL</span></div></td>  
        <td width="10%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">来源和时间</span></div></td>
         <!--
        <td width="10%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">发表时间</span></div></td>        
               
        <td width="10%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">搜素时间</span></div></td>
   
         <td width="5%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">类型</span></div></td>
        <td width="10%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">转载量</span></div></td>
        <td width="8%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">点击数</span></div></td>
        <td width="5%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">回复数</span></div></td>
         <td width="10%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">作者</span></div></td>
        <td width="10%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">引擎名称</span></div></td>
         -->   
      </tr>
      <s:iterator value="#request.list" id="report">
       
			 <tr>             
                   <s:hidden value="reportId"/>
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.title"/></div></td>
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.url"/></div></td>                   
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.resource"/></div></td>                   
                   <!--  
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.published_time"/></div></td>                  
                    
                    <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.seach_time"/></div></td>
                        <td><s:hidden value="report.reportId"/></td>
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.type"/></div></td>                    
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.reprinted_volume"/></div></td> 
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.click_number"/></div></td>                  
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.back_number"/></div></td>                     
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.author"/></div></td>                  
                                    
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#report.engineName"/></div></td>
                   <s:hidden value="#report.roleId"/>
                   -->     
              </tr>
              </s:iterator> 
      
    </table></td>
  </tr>
  
</table>
   
</s:form>
</body>
</html>
