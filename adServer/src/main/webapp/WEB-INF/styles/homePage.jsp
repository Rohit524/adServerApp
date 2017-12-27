<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<body>
	<h1>Ad Server Request</h1>
 	<form:form method = "POST" action = "/adServer/ad">
	Partner ID: <input type ="text" name="partnerId"><br/>
	Duration: <input type ="number" name="durationInSeconds"><br/>
	Ad Content: <input type ="text" name="dispalyContent"><br/>
	<input type="submit" value ="Submit">
	</form:form>
</body>
</html>