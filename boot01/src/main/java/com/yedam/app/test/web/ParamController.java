package com.yedam.app.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class ParamController {
	//content_type : application/x-www-form-urlencoded <== 이 친구가 default 
	//QueryString(질의문자열) : key=value&key=value&key=value...
	//Method : 상관없음
	
	//QueryString => 커맨드 객체 (어노테이션 x, 객체)
	
	@RequestMapping(path="comobj",
			method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String commandObject(EmpVO empVO) {
		String result = "";
		result += "Path : /comobj \n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();
		return result;	
	} //end of commandObject
	
	@RequestMapping(path="reqparam",
			method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String requestParam(@RequestParam //Integer employeeId, // 필수   <==== 무조건 있어야 함
										     String lastName, 
										     Integer employeeId,        //보시다시피 처음 오는 건 필수임
							   @RequestParam(name="message", // name에 message를 입력하지 않으면 msg 사용불가
									   		 defaultValue = " No message",     //기본 값을 설정하는 것
									   		 required = true)String msg) { //msg 리퀘스트
		String result = "";
		result += "Path : /reqparam \n";
		result += "\t employee_id : " + employeeId;
		result += "\t last_name : " + lastName;
		result += "\t message : " + msg;
		return result;	
	} //end of requestParam

	//Content-type : application/json
	//JSON 포맷 :  배열 or 객체만 사용할 수 있음
	//@RequestBody=리퀘스트 안의 바디를 파싱한다. get 방식을 사용할 수 없다. POST, PUT
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody EmpVO empVO) {  //이 어노테이션 쓰면 JSON타입을 쓴다.
		String result = "path : /resbody \n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " +empVO.getLastName();
		return result;
	}//end requestBody
	
	@PostMapping("resbodyList")
	@ResponseBody
	public String reqestBody(@RequestBody List<EmpVO> list) {
		String result = "path : /resbodyList \n";
		for (EmpVO empVO : list) {
			result += "\t employee_id : " + empVO.getEmployeeId();
			result += "\t last_name : " +empVO.getLastName();
			result += "\n";
		}
		return result;
	}//end requestBody
	
	//@PathVariable : 경로에 값을 포함하는 방식, 단일 값
	//Mehod는 상관없음, 경로에 값을 포함하는 방식이기 때문에 메서드가 상관없음
	//Content-type도 상관없음
	@RequestMapping("/path/{name}") // name = love를 넘기고 싶다면 어떻게 해야할까?? => path/love이렇게 해라
								    // 경로에 데이터를 넣기 때문에 id 같을 입력하지 않게 되면 경로 자체가 다른 경로가 됨
									// 단독보다는 합성해서 씀
	@ResponseBody
	public String pathVariable(@PathVariable String name) {// 저 위에 들어가는 중괄호에 이 단일 값을 넣음
		String result = "";
		result += "path : /path/{name} \n";
		result += "\t name : " + name; 
		return result;
	}//end pathVariable
	
}//end class

