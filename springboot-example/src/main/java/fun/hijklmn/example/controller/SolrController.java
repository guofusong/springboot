package fun.hijklmn.example.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fun.hijklmn.common.utils.WebParamsGetter;
import fun.hijklmn.example.bo.ResultVo;
import fun.hijklmn.example.bo.SysUser;
import fun.hijklmn.example.common.ControlHandler;
import fun.hijklmn.example.common.HandlerProxy;

@Controller
public class SolrController extends BaseController {

	@Autowired
	private SolrClient solrClient;
	
	@RequestMapping("/solr/put")
	public void put(HttpServletRequest request, HttpServletResponse response) {
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) throws Exception {

				long id = System.currentTimeMillis();
				
				SolrInputDocument solrInputDocument = new SolrInputDocument();
				solrInputDocument.addField("id", id + "");
				solrInputDocument.addField("nonceStr", id);
				solrInputDocument.addField("content", "HSDA789SDFJB88FBSJKD0999667FSDFKJDSJ");
				solrInputDocument.addField("name", "solr模板");
				solrInputDocument.addField("timeStamp", id + "");
				
				solrClient.add(solrInputDocument);
				
				UpdateResponse updateResponse = solrClient.commit();
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("id", id);
				map.put("requestUrl", updateResponse.getRequestUrl());
				map.put("elapsedTime", updateResponse.getElapsedTime());
				map.put("qTime", updateResponse.getQTime());
				map.put("status", updateResponse.getStatus());
				
				resultVo.setResult(map);
				
				return null;
				
			}}, request, response);
	}
	
	@RequestMapping("/solr/get/{id}")
	public void get(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) throws Exception {
				
				if (StringUtils.isBlank(id)) {
					return null;
				}
				
				SolrDocument solrDocument = solrClient.getById(id);
				
				Iterator<Entry<String, Object>> iterator = solrDocument.iterator();
				
				Map<String, Object> map2 = new HashMap<>();
				
				iterator.forEachRemaining(new Consumer<Entry<String, Object>>() {

					@Override
					public void accept(Entry<String, Object> entry) {
						map2.put(entry.getKey(), entry.getValue());
					}});
				
				resultVo.setResult(map2);
				
				return null;
				
			}}, request, response);
	}
	
	@RequestMapping("/solr/search")
	public void search(HttpServletRequest request, HttpServletResponse response) {
		
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) throws Exception {
				
				Map<String, Object> map = WebParamsGetter.getRequestDataMap(request);
				
				SolrQuery solrQuery = new SolrQuery();
				
				map.forEach(new BiConsumer<String, Object>() {
					@Override
					public void accept(String t, Object u) {
						solrQuery.add(t, u.toString());
					}});
				
				QueryResponse queryResponse = solrClient.query(solrQuery);
				
				SolrDocumentList solrDocumentList = queryResponse.getResults();
				
				Map<String, Object> map3 = new HashMap<>();
				
				for (SolrDocument solrDocument : solrDocumentList) {

					Iterator<Entry<String, Object>> iterator = solrDocument.iterator();
					
					iterator.forEachRemaining(new Consumer<Entry<String, Object>>() {

						@Override
						public void accept(Entry<String, Object> t) {
							map3.put(t.getKey(), t.getValue());
						}});
				}

				resultVo.setResult(map3);
				
				return null;
				
			}}, request, response);
		
	}
	
}
