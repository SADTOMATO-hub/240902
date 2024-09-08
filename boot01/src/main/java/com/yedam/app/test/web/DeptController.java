package com.yedam.app.test.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class DeptController {
	private DeptService deptService;
	
	@Autowired
	DeptController(DeptService deptService){
		this.deptService = deptService;
	}
	//전체조회
		@GetMapping("deptList")
		public String deptList(Model model) {
			List<DeptVO> list = deptService.deptList();
			model.addAttribute("depts", list);
			return "dept/deptList";
			//dept/list
		}
	//단건조회
		@GetMapping("deptInfo")
		public String deptInfo(Model model, int departmentId) {
			DeptVO info = deptService.deptInfo(departmentId);
			model.addAttribute("depfInfo", info);
			return "dept/deptInfo";
		}
	//새 부서 등록 - 페이지
		@GetMapping("insertDeptForm")
		public String insertInfo() {
			return "dept/insertDeptForm";
		}
		
	//새 부서 등록 - 처리
		@PostMapping("insertDeptData")
		public String insertDeptInfo(DeptVO deptVO) { //인서트 같은 경우엔 model을 요하지 않는다. form태그 때문에
			int did = deptService.insetInfo(deptVO);
			System.out.println(did);
			String url = null;
			if (did > -1) {
				url = "redirect:deptInfo?departmentId=" + did;
			}
			return url;				
		}
	//수정 - 페이지
	//수정 - 처리 : JSON
}
//6