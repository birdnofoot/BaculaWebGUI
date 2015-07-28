<!doctype html>
<html lang="fr">

<head>
	<title>Create FileSet</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
</head>

<body>
	<div class="page">
	<div class="head">
		<h1>Create a FileSet</h1>
	</div>

	<div class="form_create_fileset">
	<form id="form_create_fileset" class="formulaire" action="createfilesetservlet.do" method="post" novalidate>
	<p>FileSet Information : </p>
				<input type="text" name="fileset_name" placeholder="fileset name" required/><br/><br/>
				<p>Backup folder path : </p>
				<input type="text" name="backup_folder_path" placeholder="Backup folder path" required/><br/><br/>
				<p>Exclude folder path : </p>
				<input type="text" name="exclude_folder_path" placeholder="Exclude folder path" required/><br/><br/>
				<p>Choose signature : </p>
				<select name="signature" required>
					<option>MD5</option>
					<option>SHA1</option>
				</select><br/><br/>
				<p>Choose compression type : </p>
				<select name="compression" required>
					<option>no compression</option>
					<option>GZIP</option>
					<option>LZO</option>
				</select><br/><br/>
				<p>Backup time : </p>
				<select class="time" name="Heures" required>
				<%
					for (Integer i=0; i<=23 ; i++){
						if (i.toString().length()==1){
							out.println("<option>0"+i+"</option>");
						}
						else {
							out.println("<option>"+i+"</option>");
						}
					}
				%>
				</select>:
				<select class="time" name="Minutes" required>
				<%
					for (Integer i=0;i<=59;i++){
						if (i.toString().length()==1){
							out.println("<option>0"+i+"</option>");
						}
						else {
							out.println("<option>"+i+"</option>");
						}
					}
				%>
				</select>
				<br/>
				<br/>
				<br/>
				<input type="checkbox" name="fileset_change" value="fileset change"/><label for="fileset change">Ignore FileSet Changes</label><br/>
				<br/>
				<br/>
				<br/>
				<input type="submit" id="submit" name="submit_fileset" value="Create" /> <br/> <br/>
			</form>
		</div>
	</div>
</body>
</html>