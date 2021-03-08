package com.park.myjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Phone {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Table, auto_increment, sequence
	private long id;
	
	private String name;
	private String tel;
}
