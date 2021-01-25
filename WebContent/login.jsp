<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!-- added in master1 -->
<!-- Test commit -->
<html>
<head>
    <title>
        <bean:message key="app.webTitle"/> 
    </title>
    <script type="text/javascript">
        function resetForm() {
            window.location.href = "<%=request.getContextPath()%>/LoginView.do";
        }
    </script>
</head>
<body>

<div align=center>
<table  width="950" border="0" cellspacing="0" cellpadding="0" bgcolor="#00FFFF" >
    <tr>
        <td>
            &nbsp;
        </td>
    </tr>
    <tr>
        <td align="Center" bgcolor="#1E90FF" >
            <font color = "#FFFFFF" >
                <b><bean:message key="app.webTitle"/></b>
            </font>
        </td>
    </tr>

</table>
 <br>
<table width="700" border="0" cellspacing="0" cellpadding="0" background="images/background.jpg" >

<br>
<br>
<tr>
 <td   align=center>
 <br>
<br>
<table width="500" border="0" cellspacing="0" cellpadding="0" bgcolor="#696969" >


    <tr bgcolor="#36566E">
        <td height="68" width="48%">
            <div align="left">
                <img src="images/Banner.jpg"
                     width="500"
                     height="100">
            </div>
        </td>
    </tr>

</table>
<table>
    <tr>
        <td>
            <html:errors property="result"/>
        </td>
    </tr>
</table>
<br>

 <html:form action="Login.do" focus="username">
    <table border="2" bgcolor="#696969" >
        <tr>

            <tr>
            <td colspan=3 align= center>
             <font color= "FFFFFF">
             <bean:message key="app.login"/>
             </font>
            </td>
            </tr>


            <td>
                <font color= "FFFFFF">
                <bean:message key="app.username"/>
                :
                </font>
            </td>
            <td>
                <html:text property="username"/>

            </td>
            <td>

                <html:errors property="username"/>

            </td>
        </tr>
        <tr>
            <td>
                <font color= "FFFFFF">
                <bean:message key="app.password"/>
                :
                </font>
            </td>
            <td>

                <html:password property="password"/>

            </td>
            <td>
                <html:errors property="password"/>
            </td>
        </tr>
        <tr>

            <td colspan="2" align="center">
                <input type="submit" value="Login"> &nbsp;
                <input type="button" value="Reset" onclick="resetForm()">
            </td>
        </tr>
    </table>
    </html:form>
    <br>
<br>
   </td>
  </tr>
 </table>

<div>

</body>
</html>
