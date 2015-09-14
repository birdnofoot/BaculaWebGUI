package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.* ;

@WebServlet("/createservlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CreateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String create_type = request.getParameter("create_type");
		
		if(create_type.equals("client")){
			String client_name = request.getParameter("client_name");
			String client_ip_address = request.getParameter("client_ip_address");
			String catalog = request.getParameter("catalog");
			String file_retention = request.getParameter("file_retention");
			String autoprune = request.getParameter("autoprune");
			FileIO.createClientToConfig(client_name, client_ip_address, catalog, file_retention, autoprune);
		}
		else if(create_type.equals("device")){
			String device_name = request.getParameter("device_name");
			String label_media = request.getParameter("label_media");
			String archive_device = request.getParameter("archive_device");
			FileIO.createDeviceToConfig(device_name, label_media, archive_device);
		}
		else if(create_type.equals("fileset")){
			String fileset_name = request.getParameter("fileset_name");
			String backup_folder_path = request.getParameter("backup_folder_path");
			String exclude_folder_path = request.getParameter("exclude_folder_path");
			String signature = request.getParameter("signature");
			String compression = request.getParameter("compression");
			FileIO.createFilesetToConfig(fileset_name, backup_folder_path, exclude_folder_path, signature, compression);
			response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
		}
		else if(create_type.equals("jobdefs")){
			String jobdef_name = request.getParameter("jobdef_name");
			String jobdef_type = request.getParameter("jobdef_type");
			String level = request.getParameter("level");
			String client = request.getParameter("client");
			String fileset = request.getParameter("fileset");
			String schedule = request.getParameter("schedule");
			String storage = request.getParameter("storage");
			String pool = request.getParameter("pool");
			String incremental_backup_pool = request.getParameter("incremental_backup_pool");
			String full_backup_pool = request.getParameter("full_backup_pool");
			String priority = request.getParameter("priority");
			FileIO.createJobDefsToConfig(jobdef_name, jobdef_type, level, client, fileset, schedule, 
					storage, pool, full_backup_pool, incremental_backup_pool, priority);
		}
		else if(create_type.equals("job")){
			String job_name = request.getParameter("job_name");
			String jobdefs = request.getParameter("jobdefs");
			String job_type = request.getParameter("job_type");
			String client = request.getParameter("client");
			String pool = request.getParameter("pool");
			String storage = request.getParameter("storage");
			String fileset = request.getParameter("fileset");
			String schedule = request.getParameter("schedule");
			FileIO.createJobToConfig(job_name,jobdefs,job_type,client,pool,storage,fileset,schedule);
		}
		else if(create_type.equals("pool")){
			String pool_name = request.getParameter("pool_name");
			String pool_type = request.getParameter("pool_type");
			String recycle = request.getParameter("recycle");
			String autoprune = request.getParameter("autoprune");
			String volume_retention = request.getParameter("volume_retention");
			String maximum_volume_bytes = request.getParameter("maximum_volume_bytes");
			String maximum_volumes = request.getParameter("maximum_volumes");
			String maximum_volume_jobs = request.getParameter("maximum_volume_jobs");
			String label_format = request.getParameter("label_format");
			FileIO.createPoolToConfig(pool_name, pool_type, recycle, autoprune, volume_retention, 
					maximum_volume_bytes, maximum_volumes, maximum_volume_jobs,label_format);
		}
		else if (create_type.equals("schedule")){
			String schedule_name = request.getParameter("schedule_name");
			String run = request.getParameter("run");
			FileIO.createScheduleToConfig(schedule_name,run);
		}
		else{
		}
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}