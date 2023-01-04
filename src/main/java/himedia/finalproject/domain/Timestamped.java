package himedia.finalproject.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter @Getter
@EntityListeners(AuditingEntityListener.class)
public class Timestamped {

	@Column(name="create_time")
	@CreatedDate
	private LocalDate createTime;
	
	@Column(name="modified_time")
	@LastModifiedDate
	private LocalDate modifiedTime;
}
