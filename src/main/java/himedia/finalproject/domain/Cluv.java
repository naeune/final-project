package himedia.finalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
[테이블 생성 쿼리] -----------------------------
create table cluv (
cluv_id  int auto_increment,
title varchar(255),
contents text,
create_time char(10),
modified_time char(10),
constraint pk_cluv_no primary key(cluv_id)
);
---------------------------------------------
 */


@Entity
@Setter @Getter
@Builder
@NoArgsConstructor
@Table(name = "cluv")
public class Cluv extends Timestamped {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="cluv_id")
	private Long cluvId;
	
	private String title;	
	private String contents;
	
	public Cluv(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	public Cluv(Long id, String title, String contents) {
		this.cluvId = id;
		this.title = title;
		this.contents = contents;
	}

}
