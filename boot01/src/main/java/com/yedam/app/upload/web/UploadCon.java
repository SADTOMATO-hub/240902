package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadCon { //이 작업의 핵심은 경로를 정확하게 지정하는 것이다.
	@Value("${file.upload.path}")//환경변수 및 properties 파일의 변수 값을 , 메모리에 등록된 변수값을 호출하는 것
	private String uploadpath;
	//이 부분은 일일히 설정을 해줘야 함
	
	
	@GetMapping("formUpload")//경로 = 파일명
	public void formUploadPage() {
		System.err.println(uploadpath);
	}
	//classpath:/templates/formUpload.html
	
	@PostMapping("uploadForm")
	public String formloadFile(@RequestPart MultipartFile[] files) { //이게 key임, input에 multiple을 입력했을 경우 배열로 받아라
		for(MultipartFile file : files) {		
			System.out.println("");
			System.out.println(file.getOriginalFilename()); //파일을 확인하는 기능 하나 밖에 처리 못함.
			System.out.println(file.getContentType()); //파일의 확장자를 확인할 수 있음
			System.out.println(file.getSize()); //파일의 크기를 확인할 수 있음	
			//System.out.println(String.valueOf(file.getSize())); //파일의 크기를 확인할 수 있음
			System.out.println("=======================================================");
			
			String fileName = file.getOriginalFilename();
			String saveName = uploadpath + /*File.separator +*/ fileName; 
			
			System.out.println("saveName : " + saveName); //문제!!!발쌩!!! 중복된 이름이면 파일이 덮어씌어짐 
			Path savePath = Paths.get(saveName); //역할 이 경로를 통하면 문자열로 입력하는 작업에서 오류가 생길 확률이 줄어듬
			
			try {
				file.transferTo(savePath);
			} catch (IOException e) {
				e.printStackTrace();
			}//end try
			
		}//end formloadFile
		return "redirect:formUpload"; //이 흐름이 성공되면 console창에 업로드한 파일명이 뜸.
		//설정한 파일 크기보다 크기가 크면 안 넘어감		
	}
	@GetMapping("upload")
	public void uploadPage() {}
	
	@PostMapping("/uploadsAjax")
	@ResponseBody
	public List<String> uploadFile //핵심
			(@RequestPart MultipartFile[] uploadFiles) {
	    
		List<String> imageList = new ArrayList<>();
		
	    for(MultipartFile uploadFile : uploadFiles){
	    	if(uploadFile.getContentType().startsWith("image") == false){ //서버 측에서 이미지 파일만 받겠다고 설정함
	    		System.err.println("this file is not image type");
	    		return null;
	        }
	  
	        String fileName = uploadFile.getOriginalFilename();
	        
	        System.out.println("fileName : " + fileName);
	    
	        //날짜 폴더 생성
	        String folderPath = makeFolder(); //파일을 관리할 때 필요하다.
	        //UUID
	        String uuid = UUID.randomUUID().toString(); //128자리의 고유 식별자를 생성하는 기능이다. 절대 중복되지 않음을 보장한다.
	        //저장할 파일 이름 중간에 "_"를 이용하여 구분
	        
	        String uploadFileName = folderPath +File.separator + uuid + "_" + fileName; 
	        
	        String saveName = uploadpath + File.separator + uploadFileName;
	        
	        Path savePath = Paths.get(saveName);
	        //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
	        System.out.println("path : " + saveName);
	        try{
	        	uploadFile.transferTo(savePath);
	            //uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
	        } catch (IOException e) {
	             e.printStackTrace();	             
	        }
	        // DB에 해당 경로 저장
	        // 1) 사용자가 업로드할 때 사용한 파일명
	        // 2) 실제 서버에 업로드할 때 사용한 경로
	        //위의 두 정보를 같이 움직인다.
	        imageList.add(setImagePath(uploadFileName));
	     }
	    
	    return imageList;
	}
	
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator);
		File uploadPathFoler = new File(uploadpath, folderPath); //업로드하는 날짜를 기준으로 새 폴더를 만들어줌.
		// File newFile= new File(dir,"파일명");
		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath;
	}
	
	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
		// 이 작업들을 통해 파일 이름을 강제로 변환한다.
	}
	
}//end class
