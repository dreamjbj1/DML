package kh.project.dml.memberexset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.project.dml.memberexset.model.service.FpMemberExSetService;
import kh.project.dml.memberexset.model.vo.FpMemberExSetVo;


@Controller
@RequestMapping("/memberexset")
public class FpMemberExSetController {
	@Autowired
	private FpMemberExSetService fpmemberexsetService;
	
	@GetMapping("/list")
	public ModelAndView selectListmemberexset(ModelAndView mv) {
		mv.addObject("memberexsetlist", fpmemberexsetService.selectList());
		mv.setViewName("memberexset/list");
		return mv;
	}
	@GetMapping("/one")
	public ModelAndView selectOnememberexset(ModelAndView mv, String memberId) {
		mv.addObject("memberexsetone", fpmemberexsetService.selectOne(memberId));
		mv.setViewName("memberexset/one");
		return mv;
	}
	@GetMapping("/insert")
	public ModelAndView insertmemberexset(ModelAndView mv ) {
		mv.setViewName("memberexset/insert");
		return mv;
	}
	@PostMapping("/insert")
	public String insertDomemberexset(RedirectAttributes redirectAttr, FpMemberExSetVo vo ) {
		String viewPage = "redirect:/";
		int result = fpmemberexsetService.insert(vo);
		try {
			if (result < 1) {
				redirectAttr.addFlashAttribute("msg", "회원 가입 실패했습니다 \n 다시 입력해주세요");
				viewPage = "redirect:/memberexset/insert";
			} else {
				redirectAttr.addFlashAttribute("msg", "회원 가입 됐습니다");
				viewPage = "redirect:/memberexset/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewPage;
	}
	@GetMapping("/update")
	public ModelAndView updatememberexset(ModelAndView mv, String memberId ) {
		mv.addObject("memberexsetone", fpmemberexsetService.selectOne(memberId));
		mv.setViewName("memberexset/update");
		return mv;
	}
	@PostMapping("/update")
	public String updateDomemberexset(RedirectAttributes redirectAttr, FpMemberExSetVo vo ) {
		String viewPage = "redirect:/";
		int result = fpmemberexsetService.update(vo);
		try {
			if (result < 1) {
				redirectAttr.addFlashAttribute("msg", "회원 정보 수정 실패했습니다 \n 다시 입력해주세요");
				viewPage = "redirect:/memberexset/update";
			} else {
				redirectAttr.addFlashAttribute("msg", "회원 정보 수정 됐습니다");
				viewPage = "redirect:/memberexset/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewPage;
	}
	@PostMapping("/delete")
	public String deleteDomemberexset(RedirectAttributes redirectAttr,String memberId) {
		String viewPage = "redirect:/";
		int result = fpmemberexsetService.delete(memberId);
		try {
			if (result < 1) {
				redirectAttr.addFlashAttribute("msg", "회원 정보 삭제 실패했습니다 \n 다시 입력해주세요");
				viewPage = "redirect:/memberexset/list";//delete는 보통 처음에 있던 화면으로 돌아감 그래서 ajax를 쓰는데 그건 추후
			} else {
				redirectAttr.addFlashAttribute("msg", "회원 정보 삭제 됐습니다");
				viewPage = "redirect:/memberexset/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewPage;
	}
}