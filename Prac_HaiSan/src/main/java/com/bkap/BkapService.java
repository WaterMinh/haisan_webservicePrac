package com.bkap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.bkap.dao.HaiSanDAO;


import com.bkap.dao.ImplHaiSanDAO;
import com.bkap.entity.Messages;

import com.bkap.entity.HaiSan;
import com.google.gson.Gson;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;

@Path("/hai-san/")
public class BkapService {
	@Path("hello")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String hello() {
		BkapRespone bResp = new BkapRespone(100, "Wellcom to Hai San Web");
		Gson gson = new Gson();
		String json = gson.toJson(bResp);
		
		return json;
		
	}
	@Path("list-haisan")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getListHaiSan() {
		HaiSanDAO dao = new ImplHaiSanDAO();
		List<HaiSan> lst = dao.selectAll();
		
		Gson gson = new Gson();
		String json = gson.toJson(lst);
		
		return json;
		
		
		
	}
	@Path("search-haisan/{search}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String searchListHaiSan(@PathParam("search") String search) {
		
		HaiSanDAO dao = new ImplHaiSanDAO();
		List<HaiSan> lst = dao.search(search);
		
		Gson gson = new Gson();
		String json = gson.toJson(lst);
		
		return json;
		
		
		
	}
	@Path("totalpage")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTotalPage() {
		HaiSanDAO dao = new ImplHaiSanDAO();
		BkapRespone bRsp = new BkapRespone(110, String.valueOf(dao.getNumTotal()));
		
		Gson gson = new Gson();
		String json = gson.toJson(bRsp);
		
		return json;
		
	}
	@Path("list-page/{offset}/{limit}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getListByPage(@PathParam("offset") int offset, @PathParam("limit") int limit) {
		HaiSanDAO dao = new ImplHaiSanDAO();
		List<HaiSan> lst = dao.selectByPag(offset,limit);
		
		Gson gson = new Gson();
		String json = gson.toJson(lst);
		
		return json;
		
		
		
	}
	
	
	@GET
	@Path("detail/{id: \\d}")
	@Produces(MediaType.APPLICATION_JSON)
	public String loadDetail(@PathParam("id") int id) {
		HaiSanDAO dao = new ImplHaiSanDAO();
		HaiSan hs = dao.loadDetail(id);

		Gson gson = new Gson();
		String json = gson.toJson(hs);

		return json;
	}

	
	@Path("insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(String json) {
		Gson gson = new Gson();
		HaiSan hs = gson.fromJson(json, HaiSan.class);
		HaiSanDAO dao = new ImplHaiSanDAO();
		boolean SaveOk = dao.insert(hs);
		
		
		if (SaveOk) {
			return gson.toJson(new Messages(100, "Th??m m???i d??? li???u th??nh c??ng!"));
		} else {
			return gson.toJson(new Messages(101, "Th??m m???i th???t b???i!"));
		}	
		
	}
	
	
	@POST
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public String update(String json) {
		
		Gson gson = new Gson();
		HaiSanDAO dao = new ImplHaiSanDAO();
		HaiSan hs = gson.fromJson(json, HaiSan.class);

		boolean updateOk = dao.update(hs);

		if (updateOk) {
			return gson.toJson(new Messages(100, "C???p nh???t d??? li???u th??nh c??ng!"));
		} else {
			return gson.toJson(new Messages(101, "C???p nh???t th???t b???i!"));
		}
	}
	
	
	
	@Path("delete-haisan/{id: \\d}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteById(@PathParam("id") String id) {
		
		HaiSanDAO dao = new ImplHaiSanDAO();
		
		boolean deleteOk = dao.delete(Integer.parseInt(id));
		System.out.println("id:"+id);
		if (deleteOk) {
			return "X??a th??nh c??ng";
			
		} else {
			return "X??a th???t b???i";

		}
	
		
	}
	
	@Context
	private ServletContext servletContext;
	private final String HOST_UPLOAD = "/Upload/";
	
	
	@Path("upload")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String uploadFile(@FormDataParam("file") InputStream is,  @FormDataParam("file") FormDataContentDisposition fdcd, FormDataMultiPart formData) {
		String filePath = HOST_UPLOAD + fdcd.getFileName(); 
		String isOk = null;
		if (saveFile(is, filePath)) {
			isOk = "L??u file th??nh c??ng";
		} else {
			isOk = "L??u file th???t b???i";
		}
		
		
		System.out.println("D??? li???u form g???i l??n: " + formData.getField("txtName").getValue());

		return isOk;
	}
	
	private boolean saveFile(InputStream is, String filePath) {
		
		try {
			String realPath = servletContext.getRealPath(filePath);

			File file = new File(realPath);
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("Realpath: " + realPath);
			System.out.println(file.getAbsolutePath());

			FileOutputStream fos = new FileOutputStream(file);
			int data;
			byte buffer[] = new byte[1024];
			while ((data = is.read(buffer)) != -1) {
				fos.write(buffer);
			}

			fos.flush(); 
			fos.close();

			return true;
		} catch (FileNotFoundException e) {
			System.out.println("L???i: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("L???i: " + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}
	
	

}
