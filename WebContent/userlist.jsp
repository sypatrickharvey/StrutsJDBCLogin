<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<logic:notPresent name="USER">
    <logic:forward name="login"/>
</logic:notPresent>

<html>
<head>
    <title>
        <bean:message key="app.webTitle"/>
    </title>
</head>
<body>
<div align=center>

<table  width="950" border="0" cellspacing="0" cellpadding="0" bgcolor="#00FFFF" >
    <tr>
        <td align="right">
		        |&nbsp;
		    <html:link page="/BookList.do">
        		Home
			</html:link>
        		&nbsp|&nbsp
    		<html:link page="/PersonalEditView.do">
        	    Modify Account
			</html:link>
        	    &nbsp|&nbsp
    		<html:link page="/LoginView.do">
        	    Sign out
			</html:link>
	    	    &nbsp;|
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
<table width="100%"
       border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td colspan="7">&nbsp;</td>
    </tr>
    <tr bgcolor="white">
        <td colspan="7" height="68" width="48%">
            <div align="center">
                <img src="images/Banner.jpg"
                     width="700" height="100">
            </div>
        </td>
    </tr>
    <tr>
        <td colspan="7">&nbsp;</td>
    </tr>
</table>
<table>
    <tr>
        <td>
            <html:errors property="result"/>
        </td>
    </tr>
</table>


<logic:present name="searchForm" property="userList">

    <table width="650"
           border="1" cellspacing="0" cellpadding="0">
        <tr align="left">
            <th nowrap>
                <bean:message key="app.username"/>
            </th>
            <th nowrap>
                <bean:message key="app.name"/>
            </th>
            <th nowrap>
                <bean:message key="app.role"/>
            </th>
        </tr>
        <!-- iterate over the results of the query  -->
        <logic:iterate id="listItem" name="searchForm"
                       property="userList"
                       type="com.emerson.web.user.UserListItem">
            <tr align="left">
                <td nowrap>
                    <bean:write name="listItem" property="username"/>
                </td>
                <td nowrap>
                    <bean:write name="listItem" property="name"/>
                </td>
                <td nowrap>
                    <bean:write name="listItem" property="rolename"/>
                </td>
                <td nowrap>&nbsp;
                    <html:link page="/EditView.do" name="listItem" property="linkDataMap">
                        Edit
                    </html:link>
                    &nbsp;|&nbsp;
                    <html:link page="/Delete.do" name="listItem" property="linkDataMap">
                        Delete
                    </html:link>&nbsp;
                </td>
            </tr>
        </logic:iterate>

    </table>
</logic:present>
<br>
<font size="-1" face="arial">
   |&nbsp;
   <html:link page="/BookList.do">
        Book List
    </html:link>
   &nbsp; |&nbsp;
   <html:link page="/RegisterView.do">
        Add New User
    </html:link>

    &nbsp|&nbsp
    <html:link page="/LoginView.do">
        Sign out
	</html:link>
    &nbsp;|


</font>
</div>
</body>
</html>