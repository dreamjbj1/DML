package kh.project.dml.foodapi.model.vo;

import org.springframework.stereotype.Component;

import kh.project.dml.memberexset.model.vo.FpMemberExSetVo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Component
public class FpFoodApiVo {

	
	private String foodCd;
	private String foodName;
	private int calorie;
	private int crabs;
	private int protein;
	private int fat;
	
	@Override
	public String toString() {
		return "FpFoodApiVo []";
	}
	
	
}
