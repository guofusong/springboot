package fun.hijklmn.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fun.hijklmn.common.utils.RandomUtils;
import fun.hijklmn.example.bo.ResultVo;
import fun.hijklmn.example.bo.SysUser;
import fun.hijklmn.example.common.ControlHandler;
import fun.hijklmn.example.common.HandlerProxy;
import fun.hijklmn.example.po.ElasticsearchExample;

@Controller
public class ElasticsearchController extends BaseController {

	/*
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@RequestMapping(value = "/elasticsearch/create/{indexName}")
	public void create(@PathVariable String indexName, HttpServletRequest request, HttpServletResponse response) {
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) throws Exception {

				if (StringUtils.isBlank(indexName)) {
					return null;
				}
				
				boolean exists = elasticsearchTemplate.indexExists(indexName);
				
				if (!exists) {
					exists = elasticsearchTemplate.createIndex(indexName);
				}
				
				resultVo.setResult(exists);
				
				return null;
				
			}}, request, response);
	}
	
	@RequestMapping(value = "/elasticsearch/put/{indexName}")
	public void put(@PathVariable String indexName, HttpServletRequest request, HttpServletResponse response) {
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) throws Exception {

				if (StringUtils.isBlank(indexName)) {
					return null;
				}
				
				long id = System.currentTimeMillis();
				
				ElasticsearchExample elasticsearchExample = new ElasticsearchExample(id, "Elasticsearch模板", "UIGUGIUGB783JKHGK56786587JGJKGBKBOPI", RandomUtils.getUUID(), id + "", "Elasticsearch模板");
				
				boolean b = elasticsearchTemplate.putMapping(ElasticsearchExample.class, elasticsearchExample);
				
				resultVo.setResult(b);
				
				return null;
				
			}}, request, response);
	}
	
	@RequestMapping(value = "/elasticsearch/get/{id}")
	public void get(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) throws Exception {

				if (id == null) {
					return null;
				}
				
				List<Long> ids = new ArrayList<>();
				ids.add(id);
				
				Criteria criteria = new Criteria("id");
				
				CriteriaQuery criteriaQuery = new CriteriaQuery(criteria);
				
				List<ElasticsearchExample> elasticsearchExamples = elasticsearchTemplate.queryForList(criteriaQuery, ElasticsearchExample.class);
				
				List<ElasticsearchExample> elasticExamples = new ArrayList<>();
				
				elasticsearchExamples.forEach(new Consumer<ElasticsearchExample>() {

					@Override
					public void accept(ElasticsearchExample t) {
						elasticExamples.add(t);
					}});
				
				resultVo.setResult(elasticExamples);
				
				return null;
				
			}}, request, response);
	}*/
	
}
