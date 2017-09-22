package cn.easted.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml", "classpath:spring-vserver.xml" })
public class TestGenerator {

	private File configFile;

	@Before
	public void before() {
		// 读取mybatis参数
		configFile = new File("./src/test/resources/generatorConfig.xml");
	}

	@Test
	public void test() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		Properties properties = new Properties();
		ConfigurationParser cp = new ConfigurationParser(properties, warnings);

		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
}
