/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:   2017年8月31日 上午11:13:49   
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
/**  
 * All rights Reserved, Designed By http://www.easted.com.cn    
 * @author: 易迅通股份     
 * @date:2017年8月31日 上午11:13:49  
 * @version V1.0 
 * @Copyright: 2017 http://www.easted.com.cn Inc. All rights reserved.
 */
package cn.easted.edm.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.weld.util.collections.ArraySet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.easted.edm.core.fastjson.argumentResolver.FastJson;
import cn.easted.edm.core.generic.common.Page;
import cn.easted.edm.core.generic.enums.CompactVersion;
import cn.easted.edm.core.generic.enums.SoftWareProductType;
import cn.easted.edm.core.model.TAuthmanagement;
import cn.easted.edm.core.service.AuthManageService;
import cn.easted.edm.core.utils.ExcelUtil;
import cn.easted.edm.core.utils.ExportExcel;
import cn.easted.edm.core.utils.RandomNum;
import cn.easted.edm.web.exception.MyException;
import cn.easted.edm.web.exception.Result;
import cn.easted.edm.web.exception.ResultUtil;

/**
 * 权限管理控制器
 * @ClassName:ContractController
 * @author:Wanghao
 * @date: 2017年8月31日 上午11:13:49
 */
@Controller
@RequestMapping(value = "/auth")
public class ContractController {
	/**
	 * contractService
	 */
	@Resource
	private AuthManageService authService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload(){
		return "upload";
	}
	
	/**
	 * 分页
	 * @param ht ht
	 * @param page page 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result<?> getPage(TAuthmanagement ht, @FastJson Page page){
		page = authService.getPage(ht, page);
		return ResultUtil.success("200", page);
	}
	/**
	 * 产品版本列表
	 * @return
	 */
	@RequestMapping(value = "/productversionlist", method = RequestMethod.GET)
	@ResponseBody
	public Result<?> getProductList(){
		Set<String> products = new ArraySet<String>();
		Set<String> types = new ArraySet<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		for (SoftWareProductType type : SoftWareProductType.values()){
			products.add(type.getInfo());
		}
		for (CompactVersion type : CompactVersion.values()){
			types.add(type.getInfo());
		}
		List<String> setList= new ArrayList<String>(types); 
		Collections.sort(setList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.toString().compareTo(o2.toString());
			}

		});
		map.put("products", products);
		map.put("types", setList);
		return ResultUtil.success("200", map);
	}

	/**
	 * 新增
	 * @param ht ht
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Result<?> add(TAuthmanagement ht){
		Boolean b = false;
		int i = authService.insert(ht);
		if (i >0){
			b = true;
		}
		return ResultUtil.success("200", b);
	}

	/**
	 * 编辑前查询
	 * @param id id
	 * @return
	 */
	@RequestMapping(value = "/editbefore", method = RequestMethod.GET)
	@ResponseBody
	public Result<?> editbefore(Long id){
		TAuthmanagement ht = authService.selectById(id);
		return ResultUtil.success("200", ht);
	}

	/**
	 * 修改
	 * @param ht ht
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Result<?> update(TAuthmanagement ht){
		Boolean b = false;
		int i = authService.update(ht);
		if (i >0){
			b = true;
			return ResultUtil.success("200", b);
		}else {
			return ResultUtil.success("100", b);
		}
	}

	/**
	 * 删除
	 * @param id id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<?> delete(Long id){
		if (id == null){
			return ResultUtil.error("100", "删除失败");
		}
		Boolean b = false;
		int i = authService.delete(id);
		if (i >0){
			b = true;
		}
		return ResultUtil.success("200", b);
	}

	private Workbook wb; 
	/**
	 * 解析excel数据并保存至数据库
	 * @param request request
	 * @param response response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getExcelData", method = RequestMethod.POST)  
	@ResponseBody  
	public Result<?> insertDataFromExcel(HttpServletRequest request, HttpServletResponse response){  
		try {
			//创建一个通用的多部分解析器.    
			CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());    
			if (commonsMultipartResolver.isMultipart(request)){  
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
				Iterator<String> iterator = multipartRequest.getFileNames();  
				List<TAuthmanagement> list = new ArrayList<TAuthmanagement>();
				while (iterator.hasNext()){  
					MultipartFile multipartFile = multipartRequest.getFile(iterator.next());  
					if (multipartFile.getOriginalFilename() == null || multipartFile.getOriginalFilename().equals("")){  
						continue;  
					}  
					//上传文件到这里，获取该文件的文件流接下来就可以通过这个文件流对文件进行相关的操作：  
					InputStream is = multipartFile.getInputStream();
					String ext = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")); 
					if(".xls".equals(ext)){  
						wb = new HSSFWorkbook(is);  
					}else if(".xlsx".equals(ext)){  
						wb = new XSSFWorkbook(is);  
					}else{  
						wb=null;
						return ResultUtil.success("200", true);
					}  
					for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++){  
						Sheet sheet = wb.getSheetAt(numSheet);  //HSSFSheet表示每一页  
						if (sheet == null){  
							continue;  
						}  
						Row row = null;  
						String value = null;
						TAuthmanagement excel = null;
						//从第15行开始读
						for(int i = 15; i < sheet.getLastRowNum() + 1 ; i++) {  
							row = sheet.getRow(i);
							if (row == null){
								break;
							}
							if (row.getCell(0) == null){
								continue;
							}
							excel = new TAuthmanagement();
							for(int j = 0; j < row.getLastCellNum(); j++) {  
								switch (j) {
								case 0:
									value = ExcelUtil.getValueByCellNumber(sheet, row, excel, i, j);
									if (StringUtils.isBlank(value)){
										throw new MyException("100", "日期不能为空");
									}
									 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
										try {
											excel.setDate(sdf.parse(value));
										} catch (ParseException e) {
											throw new MyException("100", "日期格式不正确");
										}
									break;
								case 1:
									value = ExcelUtil.getValueByCellNumber(sheet, row, excel, i, j); 
									if (StringUtils.isBlank(value)){
										throw new MyException("100", "A级客户不能为空");
									}
									excel.setAclient(value);
									break;
								case 3:
									value = ExcelUtil.getValueByCellNumber(sheet, row, excel, i, j); 
									if (StringUtils.isBlank(value)){
										throw new MyException("100", "产品不能为空");
									}
									excel.setProduct(value);
									break;
								case 5:
									value = ExcelUtil.getValueByCellNumber(sheet, row, excel, i, j);  
									excel.setType(value);
									break;
								case 6:
									value = ExcelUtil.getValueByCellNumber(sheet, row, excel, i, j);  
									excel.setSuperveneNumber(value);
									break;
								case 7:
									value = ExcelUtil.getValueByCellNumber(sheet, row, excel, i, j);  
									excel.setSerinumber(value);
									break;
								case 8:
									value = ExcelUtil.getValueByCellNumber(sheet, row, excel, i, j);  
									excel.setAuthorizationcode(value);
									break;
								case 9:
									value = ExcelUtil.getValueByCellNumber(sheet, row, excel, i, j);  
									excel.setServernumber(value);
									break;
								case 10:
									value = ExcelUtil.getValueByCellNumber(sheet, row, excel, i, j);  
									excel.setBclientMachinecode(value);
									break;
								case 11:
									value = ExcelUtil.getValueByCellNumber(sheet, row, excel, i, j);  
									excel.setBauthSerilizenumber(value);
									break;

								default:
									break;
								}
							}  
							buildAuth(excel);
							list.add(excel);
//							authService.insert(excel);
						}
						authService.insertBatch(list);
					} 
					is.close();  
				}  
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new MyException("100", "数字转化异常" + e.getMessage());
		} catch (IOException e) {
			throw new MyException("100", "IO异常");
		}
		return ResultUtil.success("200", true);  
	}

	/**
	 * 赋默认值
	 * @param excel  
	 */
	private TAuthmanagement buildAuth(TAuthmanagement excel) {
		if (StringUtils.isBlank(excel.getSerinumber())){
			excel.setSerinumber(ExcelUtil.getDefaultSerialzNumber(5));
		}
		if (StringUtils.isBlank(excel.getAuthorizationcode())){
			excel.setAuthorizationcode(ExcelUtil.getDefaultAuthCode());
		}
		if (StringUtils.isBlank(excel.getServernumber())){
			if (!StringUtils.isBlank(authService.getMaxServerNumber())){
				excel.setServernumber(String.valueOf(Integer.parseInt(authService.getMaxServerNumber()) + 1));
			}else {
				excel.setServernumber("2000");
			}
		}
		if(StringUtils.isBlank(excel.getBclientMachinecode())) {
			if (CompactVersion.EASTED_View.getInfo().equals(excel.getType())){
				excel.setBclientMachinecode(RandomNum.createRandomString(Integer.valueOf(excel.getSuperveneNumber())/30*128));
			}else {
				excel.setBclientMachinecode(RandomNum.createRandomString(Integer.valueOf(excel.getSuperveneNumber())*128));
			}
		}
		if(StringUtils.isBlank(excel.getBauthSerilizenumber())) {
			if (CompactVersion.EASTED_View.getInfo().equals(excel.getType())){
				excel.setBauthSerilizenumber(RandomNum.createRandomString(Integer.valueOf(excel.getSuperveneNumber())/30*168));
			}else {
				excel.setBauthSerilizenumber(RandomNum.createRandomString(Integer.valueOf(excel.getSuperveneNumber())*168));
			}
		}
		return excel;
	}  
	/**
	 * 生成产品序列号、产品授权码、产品服务号
	 * @return
	 */
	@RequestMapping(value = "/generateCode", method = RequestMethod.POST)
	@ResponseBody
	public Result<?> generateCode(TAuthmanagement authTimeout){
		Map<String, String> map = new HashMap<String, String>();
		//随机序列号
		String serialNumber = ExcelUtil.getDefaultSerialzNumber(5);
		//随机授权码
		String authCode = ExcelUtil.getDefaultAuthCode();
		//获取服务号
		String serverNumber = null;
		if(authTimeout.getAuthTimeout()!= null && authTimeout.getAuthTimeout().startsWith("测试授权")){
			serverNumber = "000000";
			map.put("servernumber", serverNumber);
		}else {
			serverNumber = authService.getMaxServerNumber();
			if (StringUtils.isBlank(serverNumber)){
				serverNumber = "2000";
			}
			DecimalFormat df=new DecimalFormat("000000");
			String str2=df.format(Integer.parseInt(serverNumber) + 1);
			map.put("servernumber", str2);
		}
		
		map.put("serinumber", serialNumber);
		map.put("authorizationcode", authCode);
		
		return ResultUtil.success("200", map);
	}
	
	/**
	 * 生成B客户授权码
	 * @return
	 */
	@RequestMapping(value = "/generateBclientSeriaNumber", method = RequestMethod.POST)
	@ResponseBody
	public Result<?> generateBclientSeriaNumber(TAuthmanagement auth){
		if(StringUtils.isBlank(auth.getSuperveneNumber())) {
			return ResultUtil.error("100", "生成授权序列号失败");
		}
		String seriaNumber = "";
		if (CompactVersion.EASTED_View.getInfo().equals(auth.getType())){
			seriaNumber = RandomNum.createRandomString(Integer.valueOf(auth.getSuperveneNumber())/30*168);
		}else {
			seriaNumber = RandomNum.createRandomString(Integer.valueOf(auth.getSuperveneNumber())*168);
		}
		return ResultUtil.success("200", seriaNumber);
	}
	
	
	   /** 
     * 导出excel
     * @param queryJson 
     * @return 
     */  
    @RequestMapping(value = "/export", method = RequestMethod.POST)  
    public void export(HttpServletRequest request, HttpServletResponse response) {  
    	List<TAuthmanagement> authList = authService.list();
        ExportExcel<TAuthmanagement> excel= new ExportExcel<TAuthmanagement>();  
        String[] headers = { "序号", "", "软件产品", "序列号","","授权日期","授权码","服务编号","A级客户","规格型号","状态","B级客户机器码","B级客户授权码","合同码","并发数","授权期限"};  
        String fileName = "授权信息表";  
        excel.exportExcel(headers, authList, fileName, response);  
    }  

}
