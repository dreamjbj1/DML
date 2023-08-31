package kh.project.dml.diet.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.project.dml.diet.model.dao.FdDietDao;
import kh.project.dml.diet.model.vo.FpDietVo;



@Service
public class FpDietService {

	@Autowired
	private FdDietDao fdDietDao;
	
	public List<FpDietVo> selectList()  {
		return fdDietDao.selectList();
	}
	public FpDietVo selectOne(int mealCode)  {
		return fdDietDao.selectOne(mealCode);
	}
	public int insert(FpDietVo vo)  {
		return fdDietDao.insert(vo);
	}
	public int update(FpDietVo vo) {
		return fdDietDao.update(vo);
	}
	public int delete(int mealCode)  {
		return fdDietDao.delete(mealCode);
	}
	
}