<%@ page language="java" import="java.util.*" import="javax.servlet.http.HttpSession" import="Servlet.service" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xianshi.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
       <h1>显示信息</h1>
   <%
   List <String> user=new ArrayList();
  user=(ArrayList)session.getAttribute("userlist");
  %>
  <%
	int pagesize=5;
	int rowcount=12;
	int pagenow=1;
	int pagecount;
	String s_pageNow=request.getParameter("pageNow");
	if(s_pageNow!=null){
	//接收到了pageNow
	pagenow=Integer.parseInt(s_pageNow);
	}
	if(rowcount%pagesize==0){
	pagecount=rowcount/pagesize;
	}else{
	pagecount=rowcount/pagesize+1;
	}
  %>
  <%if(pagenow==1) {%>
  <tr>
  <%
  for(int i=0;i<pagesize;i++)
  {
  String b=user.get(i);
  System.out.println(b);
  out.println(b);
  out.println("<br>");
  }
   %>
  </tr>
<% }%>
<%if(pagenow==2) {%>
<tr>
  <%
  for(int i=5;i<(5+pagesize);i++)
  {
  String b=user.get(i);
  System.out.println(b);
  out.println(b);
  out.println("<br>");
  }
   %>
  </tr>
<% }%>
<%if(pagenow==3) {%>
<tr>
  <%
  for(int i=10;i<12;i++)
  {
  String b=user.get(i);
  System.out.println(b);
  out.println(b);
  out.println("<br>");
  }
   %>
  </tr>
<% }%>



<%
//上一页
if(pagenow!=1){
%>
<a href="xianshi.jsp?pageNow=<%=pagenow-1%>">上一页</a>
<%
}
//显示超链接
for(int i=1;i<=pagecount;i++){
out.println("<a href=xianshi.jsp?pageNow="+i+">["+i+"]</a>");
}
//下一页

if(pagenow!=pagecount){
out.println("<a href=xianshi.jsp?pageNow="+(pagenow+1)+">下一页</a>");
}
%>
  </body>
</html>
