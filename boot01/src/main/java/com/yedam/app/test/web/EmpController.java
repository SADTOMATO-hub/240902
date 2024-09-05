package com.yedam.app.test.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // Route : 사용자의 요청(endpoint)와 그에 대한 처리
// URI + METHOD => Service => View
//@RequiredArgsConstructor //매개변수를 통해 생성자를 쓰겠다.
public class EmpController {
	//해당 컨트롤러에서 제공하는 서비스
		//필드
	private final EmpService empService;
		
		//생성자
	EmpController(EmpService empService){
		this.empService = empService;
	}
	
	//GET : 조회, 빈페이지, 조건을 걸고 삭제하는 경우가 아니라면 삭제도 가능
	//POST : 데이터 조작(등록, 수정, 삭제)
	
		//매소드
	//전체조회 : GET
		@GetMapping("empList")
		public String empList(Model model) { //Model = Request + Response 모델 안에서 돈다.
			// 1) 기능 수행 => Service
			List<EmpVO> list = empService.empList();
			// 2) 수행한 결과를 클라이언트에게 전달
			model.addAttribute("emps", list);
			return "emp/list"; // 3)데이터를 출력할 페이지 결정 return은 /로 시작하면 안 돼
			// prefix + return + suffix => 실제 경로/ViewResolver
			// classpath:/templates/emp/list.html  
		}
	//단건조회 : GET => QueryString(커맨드 객체 Or @RequestParam), employeeId
		@GetMapping("empInfo") //GetMapping 이기 때문에 empInfo?key=value 형태가 되어야 한다. 이게 쿼리스트링임
		public String empInfo(EmpVO empVO, Model model) {
			EmpVO findVO = empService.empinfo(empVO);
			model.addAttribute("emp",findVO);
			// HttpServletRequest.setAttribute();
			return "emp/info";
			// classpath:/templates/emp/info.html / classpath = 
		}
	//등록 - 페이지 : Get
		@GetMapping("empInsert")
		public String empInsertForm() {
			return "emp/insert";
		}
	//등록 - 처리 : Post => form태그를 통한 submit
					//=> QueryString(커맨드 객체) 왜냐? 왤까...
		@PostMapping("empInsert") //get과 post는 기능이 다르기 때문에 같은 path를 써도 된다.
		public String empInsertProcess(EmpVO empVO) {
			int eid = empService.empInsert(empVO);
			String url = null;
			
			if(eid > -1) {
				// 정삭적으로 등록된 경우
				url = "redirect:empInfo?employeeId=" + eid;    //새로운 경로를 요청한다. "redirect:"가 가능한 경우는 GetMapping뿐이다.
			}else {
				// 등록되지 않은 경우
				url = "redirect:empList";
			}
			return url;
		}
	//수정 - 페이지 : Get, 조건이 필요 <=> 단건조회
		@GetMapping("empUpdate") //empUpdate?employeeId=value(key=value)
		public String empUpdateForm(EmpVO empVO, Model model) {
			EmpVO findVO = empService.empinfo(empVO);
			model.addAttribute("emp",findVO);
			// HttpServletRequest.setAttribute();
			return "emp/update";
		}
	//수정 - 처리 : post,ajax 사용 => QueryString 기반
		//@PostMapping("empUpdate")
		@ResponseBody //응답이기에 반환값 위에 AJAX에 대응하는 어노테이션
		public Map<String, Object> empupdateAJAXQueryString(EmpVO emoVO){
			return empService.empUpdate(emoVO);
		}
	//수정 - 처리 : ajax 사용 => JSON (@RequestBody) 기반
		@PostMapping("empUpdate")
		@ResponseBody //응답이기에 반환값 위에 AJAX에 대응하는 어노테이션
		public Map<String, Object> empupdateAJAXJSON(@RequestBody EmpVO emoVO){
			return empService.empUpdate(emoVO);
		}
	//삭제 - 바로 처리 : Get => QueryString(@RequestParam)
		@GetMapping("empDelete")
		public String empDelete(Integer employeeId) {
			empService.empDelete(employeeId);
			return "redirect:empList";
		}
		
	
}
