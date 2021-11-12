package com.bkap.utils;



import java.util.List;

import javax.ws.rs.core.MediaType;


import com.bkap.entity.BkapRespone;
import com.bkap.entity.HaiSan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class CallWebService {
	public  List<HaiSan> loadAll() {
		String api = "http://localhost:8080/Prac_HaiSan/api/hai-san/list-haisan";
		Client client = new Client();
		WebResource webRes = client.resource(api);
		ClientResponse cliRes = webRes.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String json = cliRes.getEntity(String.class);
		
		
		Gson gson = new Gson();
		TypeToken<List<HaiSan>> token = new TypeToken<List<HaiSan>>() {};
		
		List<HaiSan> lst = gson.fromJson(json, token.getType());
		return lst;

	}
	public  List<HaiSan> search(String search) {
		String api = "http://localhost:8080/Prac_HaiSan/api/hai-san/search-haisan";
		Client client = new Client();
		WebResource webRes = client.resource(api);
		ClientResponse cliRes = webRes.path(search).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String json = cliRes.getEntity(String.class);
		
		Gson gson = new Gson();
		TypeToken<List<HaiSan>> token = new TypeToken<List<HaiSan>>() {};
		
		List<HaiSan> lst = gson.fromJson(json, token.getType());
		return lst;
//		if (lst != null && lst.size() > 0) {
//			return lst;
//		} else {
//			return null;
//		}

	}
	public  int getTotalPage() {
		String api = "http://localhost:8080/Prac_HaiSan/api/hai-san/totalpage";
		Client client = new Client();
		WebResource webRes = client.resource(api);
		ClientResponse cliRes = webRes.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String json = cliRes.getEntity(String.class);
		
		Gson gson = new Gson();
		BkapRespone bRsp = gson.fromJson(json, BkapRespone.class);
		return Integer.parseInt(bRsp.getMessage());
	}
	public  List<HaiSan> loadPage(int offset, int limit) {
		String api = "http://localhost:8080/Prac_HaiSan/api/hai-san/list-page";
		Client client = new Client();
		WebResource webRes = client.resource(api);
		ClientResponse cliRes = webRes.path(String.valueOf(offset)).path("" +limit).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String json = cliRes.getEntity(String.class);
		
		
		Gson gson = new Gson();
		TypeToken<List<HaiSan>> token = new TypeToken<List<HaiSan>>() {};
		
		List<HaiSan> lst = gson.fromJson(json, token.getType());
		return lst;

	}
	
	public HaiSan loadDetail(String id) {
		String api = "http://localhost:8080/Prac_HaiSan/api/hai-san/detail/"+id;

		Client client = new Client();
		WebResource resource = client.resource(api); 
		ClientResponse respone = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String json = respone.getEntity(String.class);

		Gson gson = new Gson();
		HaiSan hs = gson.fromJson(json, HaiSan.class);
		return hs;
	}
	
	public  String insert(HaiSan hs) {
		String api = "http://localhost:8080/Prac_HaiSan/api/hai-san/insert" ;		
		Gson gson = new Gson();
		String json = gson.toJson(hs);
		Client client = new Client();		
		WebResource webRes = client.resource(api);
		ClientResponse cliRes = webRes.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, json);
	
		String jsonResp = cliRes.getEntity(String.class);

		return jsonResp;
	}
	public  String update(HaiSan hs) {
		String api = "http://localhost:8080/Prac_HaiSan/api/hai-san/update";
		
		Gson gson = new Gson();
		String json = gson.toJson(hs);
		Client client = new Client();		
		WebResource webRes = client.resource(api);
		ClientResponse cliRes = webRes.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, json);
	
		String jsonResp = cliRes.getEntity(String.class);

		return jsonResp;
	}
	
	
	
	
	public  String delete (String id) {
		System.out.println("OK k k k k k k k k");
		String api = "http://localhost:8080/Prac_HaiSan/api/hai-san/delete-haisan/"+id;
		Client client = new Client();
		WebResource webRes = client.resource(api);
		ClientResponse cliRes = webRes.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String json = cliRes.getEntity(String.class);
		
		return json;

	}

}
