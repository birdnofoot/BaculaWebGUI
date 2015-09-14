package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constant;
import utils.FileIO;

@WebServlet("/wizardservlet")
public class WizardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WizardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String option = request.getParameter("option");
		String host_name = request.getParameter("host_name");
		String host_ip = request.getParameter("host_ip");
		String backup_path = request.getParameter("backup_path");
		String exclude_path = request.getParameter("exclude_path");
		String schedule = request.getParameter("schedule");
		
		if(type.equals("option")){
			if(option.equals("default")){
		    	request.setAttribute("status", "default");
		    	request.getRequestDispatcher("Wizard.jsp").forward(request, response);
			}
			if(option.equals("advanced")){
		    	request.setAttribute("status", "advanced");
		    	request.getRequestDispatcher("Wizard.jsp").forward(request, response);
			}
		}
		if(type.equals("advanced_form")){
			
			/* Create Device config */
			
			String label_media = "yes" ;
			String archive_device = Constant.getDefault_backup_path()+host_name ;
			FileIO.createDeviceToConfig(host_name, label_media, archive_device);
			
			/* Create Storage config */
			
			FileIO.createStorageToConfig(host_name,host_name,Constant.getLocalhost_ip());
			
			/* Create Pool config */
			
			String pool_name = host_name ;
			FileIO.createPoolToConfig(pool_name, "Backup", "yes", "yes", "60 days", "50G", "2", "1", pool_name+"-Full");
			FileIO.createPoolToConfig(pool_name, "Backup", "yes", "yes", "30 days", "50G", "4", "1", pool_name+"-Incremental");
			
			/* Create FileSet config */
			
			String fileset_name ;
			fileset_name = host_name ;
			String signature = "MD5" ;
			String compression = "GZIP";
			FileIO.createFilesetToConfig(fileset_name, backup_path, exclude_path, signature, compression);

			/* Create Client config */
			String client_name = host_name+"-fd";
			FileIO.createClientToConfig(client_name, host_ip, "MyCatalog", "", "yes");
			
			/* Create JobDef config */
			FileIO.createJobDefsToConfig(host_name,"Backup","",client_name,fileset_name,schedule,host_name,pool_name+"-Full",
					pool_name+"-Full",pool_name+"-Incremental","");
			
			/* Create Job config */
			String job_name = host_name + "_backup" ;
			FileIO.createJobToConfig(job_name,host_name,"","","","","","");
			
	    	request.setAttribute("status", "finish");
	    	request.getRequestDispatcher("Wizard.jsp").forward(request, response);
		}
		if(type.equals("form")){
			
			/* Create Device config */
			
			String label_media = "yes" ;
			String archive_device = Constant.getDefault_backup_path()+host_name ;
			FileIO.createDeviceToConfig(host_name, label_media, archive_device);
			
			/* Create Storage config */
			
			FileIO.createStorageToConfig(host_name,host_name,Constant.getLocalhost_ip());
			
			/* Create Pool config */
			
			String pool_name = host_name ;
			FileIO.createPoolToConfig(pool_name, "Backup", "yes", "yes", "60 days", "50G", "2", "1", pool_name+"-Full");
			FileIO.createPoolToConfig(pool_name, "Backup", "yes", "yes", "30 days", "50G", "4", "1", pool_name+"-Incremental");
			
			/* Create FileSet config */
			String fileset_name ;
			if(backup_path.length() == 0 && exclude_path.length() == 0){
				fileset_name = "default" ;
			}
			else{
				if(backup_path.length() == 0){
					backup_path = "/home,/etc,/usr/local";
				}
				else{
					backup_path = "/home,/etc,/usr/local," + backup_path;
				}
				
				if(exclude_path.length() == 0){
					exclude_path = "/usr/local/apache*/logs,/home/apachelogs,/home/*/tomcat/logs,/home/OLD";
				}
				else{
					exclude_path = "/usr/local/apache*/logs,/home/apachelogs,/home/*/tomcat/logs,/home/OLD," + exclude_path;
				}
				fileset_name = host_name ;
				String signature = "MD5" ;
				String compression = "GZIP";
				FileIO.createFilesetToConfig(fileset_name, backup_path, exclude_path, signature, compression);
			}

			/* Create Client config */
			String client_name = host_name+"-fd";
			FileIO.createClientToConfig(client_name, host_ip, "MyCatalog", "", "yes");
			
			/* Create JobDef config */
			FileIO.createJobDefsToConfig(host_name,"Backup","",client_name,fileset_name,schedule,host_name,pool_name+"-Full",
					pool_name+"-Full",pool_name+"-Incremental","");
			
			/* Create Job config */
			String job_name = host_name + "_backup" ;
			FileIO.createJobToConfig(job_name,host_name,"","","","","","");
			
	    	request.setAttribute("status", "finish");
	    	request.getRequestDispatcher("Wizard.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}