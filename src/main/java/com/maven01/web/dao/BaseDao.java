package com.maven01.web.dao;

import java.util.Collection;
import java.util.List;

public interface BaseDao<T> 
{
	//根据id获取实体
	public T getEntityById(int id) throws Exception;
		
	//查询list
	public List<T> getList() throws Exception;
	
	//根据某个实体返回实体列表？？具体要用到实体的哪个参数
	public List<T> getListByEntity(T entity) throws Exception;
		
	//根据sql和输入的参数来获取总的条数？？基本没什么用处，特别是mybatis之后
	public int getCount(String sql,List<Object> params);

	//保存某个实体类
	public void save(T entity)throws Exception;
	
	//保存一个集合 ？？居然没有返回数值
	public void saveAll(Collection<T> entities)throws Exception;
	
	//更新一个对象
	public void update(T entity) throws Exception;
	
	//更新一组对象
	public void updataAll(Collection<T> entities)throws Exception;
	
	//根据一个对象删除
	public void deleteByEntity(T entity)throws Exception;
	
	//根据id删除要给对象
	public void deleteById(int id)throws Exception;
}
