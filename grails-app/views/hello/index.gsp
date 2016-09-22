<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="mainwithnavigation"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
		Hello World...
		<table>
			<thead>
				<tr>
				
					<g:sortableColumn property="name" title="${message(code: 'user.name.label', default: 'Name')}" />
				
					<g:sortableColumn property="email" title="${message(code: 'user.email.label', default: 'Email')}" />
				
					<g:sortableColumn property="webpage" title="${message(code: 'user.webpage.label', default: 'Webpage')}" />
				
				</tr>
			</thead>
			<tbody>
				<g:each in="${userList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" controller="user" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: userInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: userInstance, field: "webpage")}</td>
					
					</tr>
				</g:each>
			</tbody>
		</table>
		
		${count}
		
	</body>
</html>