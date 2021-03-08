package com.park.myjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.park.myjpa.domain.Phone;
import com.park.myjpa.domain.PhoneRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PhoneService {
	
	private final PhoneRepository phoneRepository;
	
	public List<Phone> 전체보기() {
		return phoneRepository.findAll();
	}
	public Phone 상세보기(long id) {
		return phoneRepository.findById(id).get();
	}
	
	@Transactional
	public void 삭제하기(long id) {
		phoneRepository.deleteById(id);
	}
	
	@Transactional
	public Phone 수정하기(long id, Phone phone) {
		// 영속화
		Phone phoneEntity = phoneRepository.findById(id).get();
		
		// 영속화된 객체를 수정
		phoneEntity.setName(phone.getName());
		phoneEntity.setTel(phone.getTel());
		
		
		// 서비스 종료시에 영속성 컨텍스트가 변경을 감지해서 flush()로 DB에 반영합니다.
		return phoneEntity;
	}
	
	@Transactional
	public Phone 저장하기(Phone phone) {
		return phoneRepository.save(phone);
	}
	
}
