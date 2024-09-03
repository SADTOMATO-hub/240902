package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {
	@Autowired //필드주입, 테스트에서만 쓰도록 해
	private EmpMapper empMapper;
	//construct
	//method
	//@Test
	void contextLoads() {
		assertNotNull(empMapper);
		//getter, setter가 없음에도 불구하고 필드를 건드림
		
	}
//	@Test
	void empList() {
		//전체조회 : 입력, x -> 출력, 1건 이상
		List<EmpVO> list = empMapper.selectEmpAllList(); //리스트 타입은 결과가 없어도 널 값이 나오지 않음
		assertTrue(!list.isEmpty()); //대신에 값이 빌 수도 있기 때문에 이 함수로 참,거짓을 따짐 = 비어있지 않나요? 라는 뜻
	}
//	@Test
	void empInfo() {
		//단건 조회 : 입력, 사원번호(100)
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO infoVO = empMapper.selectEmpInfo(empVO);
		assertEquals(infoVO.getLastName(), "king");
	}
//	@Test
	void insertInfo() {
		//사원등록 문 : 결과는 1을 반환한다.
		EmpVO empvo = new EmpVO();
		empvo.setLastName("lee");
		empvo.setEmail("dntkds11111@naver.com");
		empvo.setJobId("ST_MAN");
		
		int result = empMapper.insertEmpInfo(empvo);
		assertEquals(result, 1);
	}
//	@Test
	void insertInfoFull() throws ParseException {
		//모든 데이트 넣기
		EmpVO empvo = new EmpVO();
		empvo.setLastName("kim");
		empvo.setEmail("dntkds1110000@naver.com");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = sdf.parse("2024-08-15");
		empvo.setHireDate(today);
		empvo.setJobId("SA_REP");
		empvo.setSalary(1500.0);
		
		int result = empMapper.insertEmpInfo(empvo);
		assertEquals(result, 1);
	}
//	@Test
	void deleteInfo () {
		//삭제할 사번 = 211, 212, 209
		int result = empMapper.deleteEmpInfo(209);
		assertEquals(result, 1);
	}
//	@Test
	void empUpdate() {
		EmpVO empvo = new EmpVO();
		empvo.setEmployeeId(100);
		
		EmpVO selectEmp = empMapper.selectEmpInfo(empvo);
		selectEmp.setEmail("love12@naver.com");
		
		int result = empMapper.updateEmpInfo(selectEmp.getEmployeeId(), selectEmp);
		assertEquals(result, 1);
	}
		
		
}
