package yiheng.chen.service;

/**
 * baseService interface
 */
public interface BaseService<Mapper> {

	/**
	 * get basic mapper
	 * @return
	 */
	Mapper getMapper();
	
}