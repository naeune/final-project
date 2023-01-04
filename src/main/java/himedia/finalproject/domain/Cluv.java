package himedia.finalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
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
	
}
