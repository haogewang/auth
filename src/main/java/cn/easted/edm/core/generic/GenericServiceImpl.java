package cn.easted.edm.core.generic;

import java.util.List;

/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作, 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型 PK :代表对象的主键类型
 *
 * @author MinQF
 * @since 2016年12月10日 下午21:30:30
 */
public abstract class GenericServiceImpl<Model, PK> implements GenericService<Model, PK> {

	/**
	 * 定义成抽象方法,由子类实现,完成dao的注入
	 *
	 * @return GenericDao实现类
	 */
	public abstract GenericDao<Model, PK> getDao();

	/**
	 * 插入对象
	 *
	 * @param model
	 *            对象
	 */
	public int insert(Model model) {
		return getDao().insertSelective(model);
	}

	/**
	 * 更新对象
	 *
	 * @param model
	 *            对象
	 */
	public int update(Model model) {
		return getDao().updateByPrimaryKeySelective(model);
	}

	/**
	 * 通过主键, 删除对象
	 *
	 * @param id
	 *            主键
	 */
	public int delete(PK id) {
		return getDao().deleteByPrimaryKey(id);
	}

	/**
	 * 通过主键, 查询对象
	 *
	 * @param id
	 *            主键
	 * @return
	 */
	public Model selectById(PK id) {
		return getDao().selectByPrimaryKey(id);
	}

	/**
	 * 查询所有内容
	 * 
	 * @return model 对象列表
	 */
	public abstract List<Model> selectAll();
}
