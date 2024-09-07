package com.yedam.app.test.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@RestController // rest 전용 컨트롤러 @controller + 모든 메소드에 @ResoponseBody를 적용
				//@ResoponseBody : AJAX를 의미한단다
@RequiredArgsConstructor
public class EmpRestController {
		private final EmpService empService;

		@GetMapping("/restTest")
		public String restTest () {
			return "test/main";
		}
		//REST : 전용 어노테이션
		//전체조회 : GET + URI(자원 => emps 자원은 복수다)
		@GetMapping("emps")
		public List<EmpVO> emplist(){
			return empService.empList();
			//보시다시피 모델을 요하지 않음 = 페이지를 요구하지 않는다는 뜻이다.
			//JSON 타입으로 데이터가 넘어간다
		}
		//단건조회 : GET + URI(자원 => emps 자원은 복수다)
		@GetMapping("emps/{eid}") //REST의 경우 특정한 대상을 지정하여 데이터를 호출할 때는 @PathVariable 동반한다.
		public EmpVO empInfo(@PathVariable Integer eid) {
			EmpVO empVO = new EmpVO();
			empVO.setEmployeeId(eid);
			
			return empService.empinfo(empVO);
		}
		//등록	: POST + URI(자원 => emps 자원은 복수다)
		@PostMapping("emps")
		public int empInsert(@RequestBody EmpVO empVO) { //rest 같은 경우는 폼 태그를 거치지 않기 때문에 @RequestBody를 쓴다.
			return empService.empInsert(empVO);
		}
		//수정	: PUT + URI(자원 => emps 자원은 복수다)
		@PutMapping("emps/{eid}") //자원 뒤에 /{} 통해 수정할 대상을 지정한다.
		public Map<String, Object> empUpdate(@PathVariable Integer eid, //REST의 경우 특정한 대상을 지정하여 데이터를 호출할 때는 @PathVariable 동반한다.
											 @RequestBody EmpVO empVO) { //rest 같은 경우는 폼 태그를 거치지 않기 때문에 @RequestBody를 쓴다.
			empVO.setEmployeeId(eid); // 두 어노테이션을 합치는 작업
			return empService.empUpdate(empVO);
		}
		//삭제	: DELETE + URI(자원 => emps 자원은 복수다)
		@DeleteMapping("emps/{eid}")
		public Map<String, Object> empDelete (@PathVariable Integer eid){
			return empService.empDelete(eid);
		}
}
