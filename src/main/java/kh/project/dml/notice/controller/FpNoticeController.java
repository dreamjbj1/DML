package kh.project.dml.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.project.dml.notice.model.service.FpNoticeService;
import kh.project.dml.notice.model.vo.FpNoticeVo;


@Controller
@RequestMapping("/notice")
public class FpNoticeController {
	@Autowired
	private FpNoticeService fpNoticeServiceImpl;
	
	@GetMapping("/list")
	public ModelAndView selectListnotice(ModelAndView mv) {
		mv.addObject("noticelist", fpNoticeServiceImpl.selectList());
		mv.setViewName("notice/list");
		return mv;
	}
	@GetMapping("/one")
	public ModelAndView selectOnenotice(ModelAndView mv, int noticeNumber) {
		mv.addObject("noticeone", fpNoticeServiceImpl.selectOne(noticeNumber));
		mv.setViewName("notice/one");
		return mv;
	}
	@GetMapping("/insert")
	public ModelAndView insertnotice(ModelAndView mv ) {
		mv.setViewName("notice/insert");
		return mv;
	}
	@PostMapping("/insert")
	public String insertDonotice(RedirectAttributes redirectAttr, FpNoticeVo vo ) {
		String viewPage = "redirect:/";
		int result = fpNoticeServiceImpl.insert(vo);
		try {
			if (result < 1) {
				redirectAttr.addFlashAttribute("msg", "회원 가입 실패했습니다 \n 다시 입력해주세요");
				viewPage = "redirect:/notice/insert";
			} else {
				redirectAttr.addFlashAttribute("msg", "회원 가입 됐습니다");
				viewPage = "redirect:/notice/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewPage;
	}
	@GetMapping("/update")
	public ModelAndView updatenotice(ModelAndView mv, int noticeNumber ) {
		mv.addObject("noticeone", fpNoticeServiceImpl.selectOne(noticeNumber));
		mv.setViewName("notice/update");
		return mv;
	}
	@PostMapping("/update")
	public String updateDonotice(RedirectAttributes redirectAttr, FpNoticeVo vo ) {
		String viewPage = "redirect:/";
		int result = fpNoticeServiceImpl.update(vo);
		try {
			if (result < 1) {
				redirectAttr.addFlashAttribute("msg", "회원 정보 수정 실패했습니다 \n 다시 입력해주세요");
				viewPage = "redirect:/notice/update";
			} else {
				redirectAttr.addFlashAttribute("msg", "회원 정보 수정 됐습니다");
				viewPage = "redirect:/notice/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewPage;
	}
	@PostMapping("/delete")
	public String deleteDonotice(RedirectAttributes redirectAttr,int noticeNumber ) {
		String viewPage = "redirect:/";
		int result = fpNoticeServiceImpl.delete(noticeNumber);
		try {
			if (result < 1) {
				redirectAttr.addFlashAttribute("msg", "회원 정보 삭제 실패했습니다 \n 다시 입력해주세요");
				viewPage = "redirect:/notice/list";//delete는 보통 처음에 있던 화면으로 돌아감 그래서 ajax를 쓰는데 그건 추후
			} else {
				redirectAttr.addFlashAttribute("msg", "회원 정보 삭제 됐습니다");
				viewPage = "redirect:/notice/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewPage;
	}
}
