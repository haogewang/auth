package cn.easted.plugin;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * 扩展generator工具，添加生成分页sql的功能
 * 
 * @author: lei
 * @Date: 2016年12月27日 下午4:35:28
 */
public class PaginationPlugin extends PluginAdapter {
	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// add field, getter, setter for limit clause
		addLimit(topLevelClass, introspectedTable, "offset");
		addLimit(topLevelClass, introspectedTable, "limit");
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}

	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		// XmlElement isParameterPresenteElemen = (XmlElement) element
		// .getElements().get(element.getElements().size() - 1);
		XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
		isNotNullElement.addAttribute(new Attribute("test", "offset != null and offset>=0")); //$NON-NLS-1$ //$NON-NLS-2$
		// isNotNullElement.addAttribute(new Attribute("compareValue", "0"));
		// //$NON-NLS-1$ //$NON-NLS-2$
		isNotNullElement.addElement(new TextElement("limit #{limit} offset #{offset}"));
		// isParameterPresenteElemen.addElement(isNotNullElement);
		element.addElement(isNotNullElement);
		return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
	}

	/**
	 * 添加方法中自动返回id
	 */
	@Override
	public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

		Element insertElement = element.getElements().get(0);
		Attribute att = element.getAttributes().get(0);

		Attribute useGeneratedKeys = new Attribute("useGeneratedKeys", "true");
		element.getAttributes().add(useGeneratedKeys);
		Attribute keyProperty = new Attribute("keyProperty", "id");
		element.getAttributes().add(keyProperty);
		return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);

	}

	/**
	 * 添加分页字段
	 * 
	 * @param topLevelClass
	 * @param introspectedTable
	 * @param name
	 * @author lei
	 */
	private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
		CommentGenerator commentGenerator = context.getCommentGenerator();
		Field field = new Field();
		field.setVisibility(JavaVisibility.PROTECTED);
		field.setType(PrimitiveTypeWrapper.getIntegerInstance());
		field.setName(name);
		commentGenerator.addFieldComment(field, introspectedTable);
		topLevelClass.addField(field);
		char c = name.charAt(0);
		String camel = Character.toUpperCase(c) + name.substring(1);
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + camel);
		method.addParameter(new Parameter(PrimitiveTypeWrapper.getIntegerInstance(), name));
		method.addBodyLine("this." + name + "=" + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(PrimitiveTypeWrapper.getIntegerInstance());
		method.setName("get" + camel);
		method.addBodyLine("return " + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
	}

	/**
	 * This plugin is always valid - no properties are required
	 */
	public boolean validate(List<String> warnings) {
		return true;
	}

	/**
	 * 使mapper层的继承自GenericDao
	 */
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		/**
		 * 主键默认采用java.lang.Integer
		 */
		FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(
				"GenericDao<" + introspectedTable.getBaseRecordType() + ","
				// + introspectedTable.getExampleType() + ","
						+ "Long" + ">");
		FullyQualifiedJavaType imp = new FullyQualifiedJavaType("cn.easted.edm.core.generic.GenericDao");
		/**
		 * 添加 extends
		 */
		interfaze.addSuperInterface(fqjt);

		/**
		 * 添加import
		 */
		interfaze.addImportedType(imp);
		/**
		 * 删除不需要的方法
		 */
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}

	/**
	 * 多次执行时，防止sqlmapper重复生成
	 */
	@Override
	public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
		try {
			java.lang.reflect.Field field = sqlMap.getClass().getDeclaredField("isMergeable");
			field.setAccessible(true);
			field.setBoolean(sqlMap, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
