package fun.hijklmn.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fun.hijklmn.example.bo.ResultVo;
import fun.hijklmn.example.bo.SysUser;
import fun.hijklmn.example.common.ControlHandler;
import fun.hijklmn.example.common.HandlerProxy;
import fun.hijklmn.example.dao.Neo4jExampleNeo4jRepository;
import fun.hijklmn.example.po.Neo4jExample;

@Controller
public class Neo4jController extends BaseController {

	@Autowired
	private Neo4jExampleNeo4jRepository neo4jExampleNeo4jRepository;
	
	@RequestMapping("/neo4j/put")
	public void put(HttpServletRequest request, HttpServletResponse response) {
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) {

				List<Neo4jExample> entities = new ArrayList<>();
				
				for (int i=0; i<10; i++) {
					long exampleId = new Random().nextLong();
					Neo4jExample example = new Neo4jExample(exampleId, "默认模板", "YAS43F32DF86G84BV3DF34DF", UUID.randomUUID().toString().replaceAll("-", ""), exampleId + "");
					entities.add(example);
				}
				
				 Iterable<Neo4jExample> iterable = neo4jExampleNeo4jRepository.saveAll(entities);
				
				resultVo.setResult(iterable);
				
				return null;
				
			}}, request, response);
	}
	
	@RequestMapping("/neo4j/get")
	public void get(HttpServletRequest request, HttpServletResponse response) {
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) {

				Iterable<Neo4jExample> iterable = neo4jExampleNeo4jRepository.findAll();
				
				List<Object> list = new ArrayList<>();
				
				iterable.forEach(new Consumer<Neo4jExample>() {

					@Override
					public void accept(Neo4jExample example) {
						list.add(example);
					}});
				
				resultVo.setItems(list);
				
				return null;
				
			}}, request, response);
	}
	
}
