package cn.easted.edm.core.generic.common;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 翻页实体类
 * 
 * @author: lei
 * @Date: 2016年12月27日 下午4:45:47
 */
public class Page {
	// 默认每页15条
	private static int DEFAULT_LIMIT = 15;
	//模糊查询
	@JSONField(name = "all")
	private String search;
	// 分页查询开始记录位置
	@JSONField(name = "start")
	private int offset;
	// 分页查看下结束位置
	private int offsetEnd;
	// 每页显示记录数
	@JSONField(name = "pageSize")
	private int limit;
	// 查询结果总记录数
	@JSONField(name = "searchCount")
	private int count;
	// 数据库中总条数
	@JSONField(name = "total")
	private int countAll;
	// 当前页码
	@JSONField(name = "currentPage")
	private int current;
	// 总共页数
	private int total;
	// 排序字段
	@JSONField(name = "orderName")
	private String orderName;
	//升序、降序
	@JSONField(name = "order")
	private String order;

	@JSONField(name = "data")
	private List<?> dataList;

	@JSONField(name = "draw")
	private String draw;

	private String filterName;

	private String domain;

	public Page() {
	}

	/**
	 * 构造函数
	 * 
	 * @param offset
	 *            从多少行开始
	 * @param limit
	 *            查询多少条
	 */
	public Page(int offset, int limit) {
		this.offset = offset;
		this.limit = limit;
		this.offsetEnd = this.offset + this.limit;
		this.current = (int) Math.floor((this.offset * 1.0d) / this.limit) + 1;
	}

	/**
	 * 
	 * @param offset
	 * @param limit
	 * @param count
	 */
	public Page(int offset, int limit, int count) {
		this(offset, limit);
		this.count = count;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getOffsetEnd() {
		return offsetEnd;
	}

	public void setOffsetEnd(int offsetEnd) {
		this.offsetEnd = offsetEnd;
	}

	public int getLimit() {
		if (this.limit == 0) {
			limit = DEFAULT_LIMIT;
		}
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCountAll() {
		return countAll;
	}

	public void setCountAll(int countAll) {
		this.countAll = countAll;
	}



	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setStart(int start) {
		this.offset = start;
	}

	public void setLength(int length) {
		this.limit = length;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.count = recordsFiltered;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.countAll = recordsTotal;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
