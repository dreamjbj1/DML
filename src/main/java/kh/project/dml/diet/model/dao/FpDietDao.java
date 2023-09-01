package kh.project.dml.diet.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.project.dml.diet.model.vo.FpDietVo;




@Repository("FpDietDao")
public class FpDietDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<FpDietVo> selectList()  {
		return sqlSession.selectList("diet.selectList");
	}
	public FpDietVo selectOne(int mealCode) {
		return sqlSession.selectOne("diet.selectOne", mealCode);
	}
	public int insert(FpDietVo vo)  {
		return sqlSession.insert("diet.insert", vo);
	}
	public int update(FpDietVo vo)  {
		return sqlSession.update("diet.update", vo);
	}
	public int delete(int mealCode) {
		return sqlSession.delete("diet.delete",  mealCode);
	}
}