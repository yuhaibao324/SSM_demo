package com.generator;

import java.io.File;
 
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @ClassName:  Generator   
 * @Description:运行java代码生成文件
 * @author: caiji
 * @date: 2019年4月27日 下午1:50:33
 */
public class Generator {

	public void generator() throws Exception {

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//指向逆向工程配置文件
		File configFile = new File("src/main/resources/generatorConfig.xml");//设置相对路径
		
		ConfigurationParser cp = new ConfigurationParser(warnings);
		
		Configuration config = cp.parseConfiguration(configFile);
		
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		
		myBatisGenerator.generate(null);
		
	}

	public static void main(String[] args) throws Exception {
		try {
			Generator generatorSqlmap = new Generator();
			
			
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
