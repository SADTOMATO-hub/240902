package com.yedam.app.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.user.service.UserVO;
@CrossOrigin
@Controller
public class UserCont {
	@PostMapping("jsonListAjax")/*JSON은 post 방식 밖에 안 됨*/
	@ResponseBody // AJAX임을 알림 => return 결과가 순수 데이터, 페이지는 됐고 데이터만 주쇼
	public Map<String, Object> jsonListAjax(@RequestBody List<UserVO> userVO){ //단건이 아니라 list 타입으로 처리하려고 함
							 // JSON : @RequestBody + 객체, 배열
		Map<String, Object> map = new HashMap<>();
		map.put("type", "jsonListAjax");
		map.put("data", userVO);
		return map;
	}
	@PostMapping("jsonAjax")/*JSON은 post 방식 밖에 안 됨*/
	@ResponseBody // AJAX임을 알림 => return 결과가 순수 데이터, 페이지는 됐고 데이터만 주쇼
	public Map<String, Object> jsonAjax(@RequestBody UserVO userVO){
							 // JSON : @RequestBody + 객체, 배열
		Map<String, Object> map = new HashMap<>();
		map.put("type", "jsonAjax");
		map.put("data", userVO);
		return map;
	}
	@PostMapping("postAjax")/*주소*/
	@ResponseBody // AJAX임을 알림 => return 결과가 순수 데이터, 페이지는 됐고 데이터만 주쇼
	public Map<String, Object> postAjax(UserVO userVO){
							   // 어노테이션 없이 객체 : 커맨드 객체
							   // QueryString을 처리
		Map<String, Object> map = new HashMap<>();
		map.put("type", "postAjax");
		map.put("data", userVO);
		return map;
	}
	@GetMapping("getAjax")/*주소*/
	@ResponseBody // AJAX임을 알림 => return 결과가 순수 데이터, 페이지는 됐고 데이터만 주쇼
	public Map<String, Object> getAjax(UserVO userVO){
							   // 어노테이션 없이 객체 : 커맨드 객체
							   // QueryString을 처리
		Map<String, Object> map = new HashMap<>();
		map.put("type", "getAjax");
		map.put("data", userVO);
		return map;
	}
}
