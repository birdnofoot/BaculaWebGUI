package view;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import controller.*;
import utils.* ;
import model.*;

public class PrintJSP {
	
	private static StringBuilder sb ;
	
	public static String printNameJSP(String type){
		String jsp = null ;
		sb = new StringBuilder();
		String path = AppUtils.getConfigPathByType(type);
		File f = new File(path);
		ArrayList<String> name_list = new ArrayList<String>();
		name_list = BaculaParser.getName(f,"Name");
		int i = 0 ;
		for(i=0;i<name_list.size();i++){
			sb.append("<option>"+name_list.get(i)+"</option>");
		}
		jsp = sb.toString();
		return jsp ;
	}
	
	public static String printViewJob(){
		String jsp = null ;
		sb = new StringBuilder();
		HashMap<String,Status> statusMap = new HashMap<String,Status>();
		statusMap = AppUtils.getJobStatusLong();
		DatabaseController db_controller = new DatabaseController();
		try {
			db_controller.openConnection();
			String jobQuery = "SELECT * FROM Job ORDER BY SchedTime DESC LIMIT 2000 ; " ;
			Statement st = db_controller.getConnexion().createStatement();
			ResultSet job_rs = st.executeQuery(jobQuery);
			
			sb.append("<thead>");
			sb.append("<th> ID </th>");
			sb.append("<th> Job Name </th>");
			sb.append("<th> Level </th>");
			sb.append("<th> Status </th>");
			sb.append("<th> Client </th>");
			sb.append("<th> Size </th>");
			sb.append("<th> Scheduled Time </th>");
			sb.append("<th> Start Time </th>");
			sb.append("<th> End Time </th>");
			sb.append("</thead>");
			
			while(job_rs.next()){		
				sb.append("<tr>");
				sb.append("<th scope=\"row\">"+job_rs.getString("JobId"));
				sb.append("</td>");
				sb.append("<td><a style=\"color:#333\" href=\"searchservlet?JobId="+job_rs.getString("JobId")+"\">"+job_rs.getString("Name"));
				sb.append("</a></td>");
				sb.append("<td>"+job_rs.getString("Level"));
				sb.append("</td>");

			    sb.append("<td><span id=\"popoverOption\" data-content=\" "+statusMap.get(job_rs.getString("JobStatus")).getJobStatusLong()+
			    "\"rel=\"popover\" data-placement=\"top\">"+job_rs.getString("JobStatus")+"</span>");
				sb.append("</td>");
				sb.append("<td>"+db_controller.getClientNameById(job_rs.getString("ClientId")));
				sb.append("</td>");
				sb.append("<td>"+AppUtils.formatFileSize(job_rs.getString("JobBytes")));
				sb.append("</td>");
				sb.append("<td>"+AppUtils.formatDate(job_rs.getString("SchedTime")));
				sb.append("</td>");
				if(job_rs.getString("JobStatus").equals("C")){
					sb.append("<td> Not started yet </td>");
					sb.append("<td> Not started yet </td>");
				}
				else{
					sb.append("<td>"+AppUtils.formatDate(job_rs.getString("StartTime")));
					sb.append("</td>");
					if(!job_rs.getString("JobStatus").equals("R")){
						sb.append("<td>"+AppUtils.formatDate(job_rs.getString("EndTime")));
						sb.append("</td>");
					}
					else{
						sb.append("<td> running...");
						sb.append("</td>");
					}
				}
				sb.append("</tr>");
			}
			
			job_rs.close();
			st.close();
			db_controller.closeConnection();
			jsp = sb.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsp ;
	}
	
	public static String printViewClient(){
		String jsp = null ;
		sb = new StringBuilder();
		DatabaseController db_controller = new DatabaseController();
		try{
		db_controller.openConnection();	

		String failedJobQuery = "SELECT * FROM Client ; " ;
		Statement st = db_controller.getConnexion().createStatement();
		ResultSet client_rs = st.executeQuery(failedJobQuery);
		
		sb.append("<thead>");
		sb.append("<th> ID </th>");
		sb.append("<th> Name </th>");
		sb.append("<th> Agent version </th>");
		sb.append("<th> AutoPrune </th>");
		sb.append("<th> File Retention </th>");
		sb.append("<th> Job Retention</th>");
		sb.append("</thead>");
		
		while(client_rs.next()){
			sb.append("<tr>");
			sb.append("<th scope=\"row\">"+client_rs.getString("ClientId"));
			sb.append("</td>");
			sb.append("<td>"+client_rs.getString("Name"));
			sb.append("</td>");
			sb.append("<td>"+client_rs.getString("Uname"));
			sb.append("</td>");
			sb.append("<td>"+client_rs.getString("AutoPrune"));
			sb.append("</td>");
			sb.append("<td>"+AppUtils.formatTime(client_rs.getString("FileRetention")));
			sb.append("</td>");
			sb.append("<td>"+AppUtils.formatTime(client_rs.getString("JobRetention")));
			sb.append("</td>");
			sb.append("</tr>");
		}
		
		client_rs.close();
		st.close();
		db_controller.closeConnection();
		jsp = sb.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsp ;
	}
	
	
	public static String printViewFileset(){
		String jsp = null ;
		sb = new StringBuilder();
		DatabaseController db_controller = new DatabaseController();
		try{
		db_controller.openConnection();	
		String failedJobQuery = "SELECT * FROM FileSet ; " ;
		Statement st = db_controller.getConnexion().createStatement();
		ResultSet fileset_rs = st.executeQuery(failedJobQuery);
		
		sb.append("<thead>");
		sb.append("<th> ID </th>");
		sb.append("<th> Name </th>");
		sb.append("<th> Creation Time </th>");
		sb.append("</thead>");
		
		while(fileset_rs.next()){
			sb.append("<tr>");
			sb.append("<th scope=\"row\">"+fileset_rs.getString("FileSetId"));
			sb.append("</td>");
			sb.append("<td>"+fileset_rs.getString("FileSet"));
			sb.append("</td>");
			sb.append("<td>"+AppUtils.formatDate(fileset_rs.getString("CreateTime")));
			sb.append("</td>");
			sb.append("</tr>");
		}
		
		fileset_rs.close();
		st.close();
		db_controller.closeConnection();
		jsp = sb.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsp ;
	}
	
	
	public static String printViewPool(){
		String jsp = null ;
		sb = new StringBuilder();
		DatabaseController db_controller = new DatabaseController();
		try{
		db_controller.openConnection();	
		String failedJobQuery = "SELECT * FROM Pool ; " ;
		Statement st = db_controller.getConnexion().createStatement();
		ResultSet pool_rs = st.executeQuery(failedJobQuery);

		sb.append("<thead>");
		sb.append("<th> ID </th>");
		sb.append("<th> Name </th>");
		sb.append("<th> Type </th>");
		sb.append("<th> Volume Retention </th>");
		sb.append("<th> Maximum Volume Jobs </th>");
		sb.append("<th> Recycle </th>");
		sb.append("<th> AutoPrune </th>");
		sb.append("<th> Label Format </th>");
		sb.append("</thead>");
		
		while(pool_rs.next()){
			sb.append("<tr>");
			sb.append("<th scope=\"row\">"+pool_rs.getString("PoolId"));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("Name"));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("PoolType"));
			sb.append("</td>");
			sb.append("<td>"+AppUtils.formatTime(pool_rs.getString("VolRetention")));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("MaxVolJobs"));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("Recycle"));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("AutoPrune"));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("LabelFormat"));
			sb.append("</td>");
			sb.append("</tr>");
		}
		
		pool_rs.close();
		st.close();
		db_controller.closeConnection();
		jsp = sb.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsp ;
	}
		
		
	public static String printViewStorage(){
		String jsp = null ;
		sb = new StringBuilder();
		DatabaseController db_controller = new DatabaseController();
		try{
		db_controller.openConnection();	
		String failedJobQuery = "SELECT * FROM Pool ; " ;
		Statement st = db_controller.getConnexion().createStatement();
		ResultSet pool_rs = st.executeQuery(failedJobQuery);

		sb.append("<thead>");
		sb.append("<th> ID </th>");
		sb.append("<th> Name </th>");
		sb.append("<th> Type </th>");
		sb.append("<th> Volume Retention </th>");
		sb.append("<th> Use Once </th>");
		sb.append("<th> Recycle </th>");
		sb.append("<th> AutoPrune </th>");
		sb.append("<th> Label Format </th>");
		sb.append("</thead>");
		
		while(pool_rs.next()){
			sb.append("<tr>");
			sb.append("<th scope=\"row\">"+pool_rs.getString("PoolId"));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("Name"));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("PoolType"));
			sb.append("</td>");
			sb.append("<td>"+AppUtils.formatTime(pool_rs.getString("VolRetention")));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("UseOnce"));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("Recycle"));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("AutoPrune"));
			sb.append("</td>");
			sb.append("<td>"+pool_rs.getString("LabelFormat"));
			sb.append("</td>");
			sb.append("</tr>");
		}
		
		pool_rs.close();
		st.close();
		db_controller.closeConnection();
		jsp = sb.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsp ;
	}
	
	public static String printFieldInfo(String info){
		String jsp = null ;
		sb = new StringBuilder();
		sb.append("<span id=\"popoverOption\" data-content=\""+info+"\""+
		"rel=\"popover\" data-placement=\"top\">");
		sb.append("<span class=\"glyphicon glyphicon-info-sign\" aria-hidden=\"true\"></span></span>");
		jsp = sb.toString();
		return jsp ;
	}
	

	public static String printSelectOptionByTypeNameInDB(String type){
		StringBuilder sb = new StringBuilder();
		ArrayList<String> name_list = new ArrayList<String>();
    	String query = "SELECT Name FROM " + type + " ; " ;
    	try{
			DatabaseController db = new DatabaseController() ;
			db.openConnection();
	
			Statement statement = db.getConnexion().createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()){
				name_list.add(resultset.getString("Name"));
			};
			
			resultset.close();
			statement.close();
			db.closeConnection();
			int i ;
			for(i=0;i<name_list.size();i++){
				sb.append("<option>"+name_list.get(i)+"</option>");
			}
			return sb.toString() ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	public static String printSelectOptionByJobId(){
		StringBuilder sb = new StringBuilder();
		ArrayList<String> name_list = new ArrayList<String>();
    	String query = "SELECT JobId FROM Job ";
    	try{
			DatabaseController db = new DatabaseController() ;
			db.openConnection();
	
			Statement statement = db.getConnexion().createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()){
				name_list.add(resultset.getString("JobId"));
			};
			
			resultset.close();
			statement.close();
			db.closeConnection();
			int i ;
			for(i=0;i<name_list.size();i++){
				sb.append("<option>"+name_list.get(i)+"</option>");
			}
			return sb.toString() ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	
	
	public static String printSelectOptionByType(String type){
		StringBuilder sb = new StringBuilder();
		File f = new File(AppUtils.getConfigPathByType(type));
		ArrayList<String> name_list = new ArrayList<String>();
		name_list = BaculaParser.getName(f,"Name");
		int i = 0 ;
		for(i=0;i<name_list.size();i++){
			sb.append("<option>"+name_list.get(i)+"</option>");
		}
		return sb.toString() ;
	}
	
	public static String printWizardOption(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"container\">");
		sb.append("<div class=\"page-header\">");
		sb.append("<h1>Add new host</h1>");
		sb.append("</div>");
		sb.append("<form data-toggle=\"validator\" class=\"form-horizontal\" action=\"wizardservlet\" method=\"post\" novalidate>");
		sb.append("<div class=\"form-group\">");
		sb.append("<div class=\"col-md-3\">");
		sb.append("<h4> Wizard Option : </h4>");
		sb.append("<br/>");
		sb.append("<div class=\"col-lg-9\">");
		sb.append("<label class=\"radio\">");
		sb.append("<input type=\"hidden\" name=\"type\" value=\"option\">") ;
		sb.append("<input type=\"radio\" name=\"option\" id=\"option\" value=\"default\" checked>");
		sb.append("Default <small>(recommended)</small>");
		sb.append("</label>");
		sb.append("<label class=\"radio\">");
		sb.append("<input type=\"radio\" name=\"option\" id=\"option\" value=\"advanced\">");
		sb.append("Advanced");
		sb.append("</label>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<br/>");
		sb.append("<br/>");
		sb.append("<br/>");
		sb.append("<input class = \"btn btn-primary\" type=\"submit\" id=\"submit\" name=\"submit\" value=\"Start\" />");
		sb.append("</form>");
		sb.append("</div>");
		return sb.toString();
	}
	
	public static String printAdvancedWizardForm(){
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"container\">	");
		sb.append("<div class=\"page-header\">");
		sb.append("<h1>Add new host</h1>");
		sb.append("</div>");
		sb.append("<form data-toggle=\"validator\" class=\"form-horizontal\"");
		sb.append("action=\"wizardservlet\" method=\"post\" novalidate>");
		sb.append("<div class = \"form-group\">");
		sb.append("<div class=\"col-md-3\">");
		sb.append("<label for=\"device_name\">Host name <font color=\"red\">*</font> :</label>");
		sb.append("<input type=\"text\" class=\"form-control\" name=\"host_name\" required />");
		sb.append("<input type=\"hidden\" name=\"type\" value=\"advanced_form\">") ;
		sb.append("<span class=\"glyphicon form-control-feedback\" aria-hidden=\"true\"></span>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div class = \"form-group\">");
		sb.append("<div class=\"col-md-3\">");
		sb.append("<label for=\"device_name\">IP address <font color=\"red\">*</font> :</label>");
		sb.append("<input type=\"text\" class=\"form-control\" name=\"host_ip\" required />");
		sb.append("<span class=\"glyphicon form-control-feedback\" aria-hidden=\"true\"></span>");
		sb.append("</div>");
		sb.append("</div>");
		
		sb.append("<div class = \"form-group\">");
		sb.append("<div class=\"col-md-3\">");
		sb.append(PrintJSP.printFieldInfo(Manual.getFilesetBackupPath()));
		sb.append(" <label for=\"device_name\"> Path to backup <font color=\"red\">*</font> :</label>");
		sb.append(" <input type=\"text\" class=\"form-control\" name=\"backup_path\" required />");
		sb.append(" <span class=\"glyphicon form-control-feedback\" aria-hidden=\"true\"></span>");
		sb.append(" </div>");
		sb.append(" </div>");
		sb.append(" <div class = \"form-group\">");
		sb.append(" <div class=\"col-md-3\">");
		sb.append(PrintJSP.printFieldInfo(Manual.getFilesetExcludePath()));
		sb.append(" <label for=\"device_name\"> Path to exclude :</label>");
		sb.append(" <input type=\"text\" class=\"form-control\" name=\"exclude_path\" />");
		sb.append(" <span class=\"glyphicon form-control-feedback\" aria-hidden=\"true\"></span>");
		sb.append(" </div>");
		sb.append(" </div>");
		
		sb.append("<div class = \"form-group\">");
		sb.append("<div class=\"col-xs-3\">");
		sb.append("<label for=\"label_media\">Schedule <font color=\"red\">*</font> :</label>");
		sb.append("<select class=\"form-control\" name=\"schedule\" required>");
		sb.append("<option></option>");
		sb.append(PrintJSP.printNameJSP("Schedule"));
		sb.append("	</select>");
		sb.append("	</div>");
		sb.append("</div>");
		sb.append("<br/>");
		sb.append("	<input class = \"btn btn-primary\" type=\"submit\" id=\"submit\" name=\"submit\" value=\"Create all configuration files\" />");
		sb.append("	</form>");
		sb.append("</div>");
		return sb.toString();
	}
	
	public static String printDefaultWizardForm(){
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"container\">	");
		sb.append("<div class=\"page-header\">");
		sb.append("<h1>Add new host</h1>");
		sb.append("</div>");
		sb.append("<form data-toggle=\"validator\" class=\"form-horizontal\"");
		sb.append("action=\"wizardservlet\" method=\"post\" novalidate>");
		sb.append("<div class = \"form-group\">");
		sb.append("<div class=\"alert alert-info\" role=\"alert\">Note : /home, /etc and /usr/local will be backed up. /usr/local/apache*/logs,/home/apachelogs,/home/*/tomcat/logs,/home/OLD (if exist) will be excluded.</div>");
		sb.append("<div class=\"col-md-3\">");
		sb.append("<label for=\"device_name\">Host name <font color=\"red\">*</font> :</label>");
		sb.append("<input type=\"text\" class=\"form-control\" name=\"host_name\" required />");
		sb.append("<input type=\"hidden\" name=\"type\" value=\"form\">") ;
		sb.append("<span class=\"glyphicon form-control-feedback\" aria-hidden=\"true\"></span>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div class = \"form-group\">");
		sb.append("<div class=\"col-md-3\">");
		sb.append("<label for=\"device_name\">IP address <font color=\"red\">*</font> :</label>");
		sb.append("<input type=\"text\" class=\"form-control\" name=\"host_ip\" required />");
		sb.append("<span class=\"glyphicon form-control-feedback\" aria-hidden=\"true\"></span>");
		sb.append("</div>");
		sb.append("</div>");
		
		sb.append("<div class = \"form-group\">");
		sb.append("<div class=\"col-md-3\">");
		sb.append(PrintJSP.printFieldInfo(Manual.getWizardExtraBackupPathInfo()));
		sb.append(" <label for=\"device_name\"> Extra path to backup :</label>");
		sb.append(" <input type=\"text\" class=\"form-control\" name=\"backup_path\" />");
		sb.append(" <span class=\"glyphicon form-control-feedback\" aria-hidden=\"true\"></span>");
		sb.append(" </div>");
		sb.append(" </div>");
		
		sb.append("<div class = \"form-group\">");
		sb.append("<div class=\"col-md-3\">");
		sb.append(PrintJSP.printFieldInfo(Manual.getWizardExtraExcludePathInfo()));
		sb.append(" <label for=\"device_name\"> Extra path to exclude :</label>");
		sb.append(" <input type=\"text\" class=\"form-control\" name=\"exclude_path\" />");
		sb.append(" <span class=\"glyphicon form-control-feedback\" aria-hidden=\"true\"></span>");
		sb.append(" </div>");
		sb.append(" </div>");
		sb.append("<div class = \"form-group\">");
		sb.append("<div class=\"col-xs-3\">");
		sb.append("<label for=\"label_media\">Schedule <font color=\"red\">*</font> :</label>");
		sb.append("<select class=\"form-control\" name=\"schedule\" required>");
		sb.append("<option></option>");
		sb.append(PrintJSP.printNameJSP("Schedule"));
		sb.append("	</select>");
		sb.append("	</div>");
		sb.append("</div>");
		sb.append("<br/>");
		sb.append("	<input class = \"btn btn-primary\" type=\"submit\" id=\"submit\" name=\"submit\" value=\"Create all configuration files\" />");
		sb.append("	</form>");
		sb.append("</div>");
		return sb.toString();
	}
}
