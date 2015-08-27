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
		if(type.equals("form")){
			
			/* Create Device config */
			
			String label_media = "yes" ;
			String archive_device = Constant.getDefault_backup_path()+host_name ;
			FileIO.createDeviceToConfig(host_name, label_media, archive_device);
			
			/* Create Storage config */
			
			FileIO.createStorageToConfig(host_name,host_name,Constant.getLocalhost_ip());
			
			/* Create Pool config */
			
			String pool_name = host_name ;
			String pool_type = "Backup";
			String recycle = "yes";
			String autoprune = "yes";
			FileIO.createPoolToConfig(pool_name, pool_type, "", "", "", "", recycle, autoprune);
			
			/* Create FileSet config */
			
			String fileset_name = host_name ;
			String signature = "MD5" ;
			String compression = "GZIP";
			FileIO.createFilesetToConfig(fileset_name, backup_path, exclude_path, signature, compression);
			
			/* Create JobDef config */
			
			// Nothing to do here
			
			/* Create Client config */
			String client_name = host_name+"-fd";
			FileIO.createClientToConfig(client_name, host_ip, "MyCatalog", "", autoprune);
			
			/* Create Job config */
			String job_name = host_name + "_backup" ;
			String job_type = "Backup";
			String jobdefs = "DefaultJob";
			FileIO.createJobToConfig(job_name,job_type,jobdefs,client_name,pool_name,host_name,fileset_name,schedule);
			
	    	request.setAttribute("status", "finish");
	    	request.getRequestDispatcher("Wizard.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}