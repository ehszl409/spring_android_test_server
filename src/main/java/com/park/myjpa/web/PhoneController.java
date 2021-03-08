package com.park.myjpa.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.park.myjpa.domain.Phone;
import com.park.myjpa.service.PhoneService;
import com.park.myjpa.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PhoneController {
	
	public final PhoneService phoneService;
	
	@GetMapping("/phone") 
	public CMRespDto<?> findAll() {
		return new CMRespDto<>(1, phoneService.전체보기());
	}
	
	@GetMapping("/phone/{id}")
	public CMRespDto<?> findById(@PathVariable long id) {
		return new CMRespDto<>(1, phoneService.상세보기(id));
	}
	
	@PostMapping("/phone")
	public CMRespDto<?> save(@RequestBody Phone phone) {
		return new CMRespDto<>(1, phoneService.저장하기(phone));		
	}
	
	@DeleteMapping("/phone/{id}")
	public CMRespDto<?> delete(@PathVariable long id) {
		phoneService.삭제하기(id);
		return null;
	}
	
	@PutMapping("/phone/{id}")
	public CMRespDto<?> update(@PathVariable long id, @RequestBody Phone phone) {
		return new CMRespDto<>(1, phoneService.수정하기(id, phone));
		
	}
}
