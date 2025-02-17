package com.codenation.entity;

import com.codenation.enums.Environment;
import com.codenation.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Level level;

	@Column(nullable = false, columnDefinition="TEXT")
	private String detail;

	@CreationTimestamp
	private Date createdAt;

	@Column(nullable = false)
	private String origin;

	@Column(length = 350)
	private String token;

	@Column(nullable = false)
	private String generatedBy;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Environment environment;

	private Boolean stored = false;
	private Integer events = 0;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Log)) {
			return false;
		}
		Log other = (Log) obj;
		return Objects.equals(detail, other.detail)
				&& Objects.equals(generatedBy, other.generatedBy)
				&& Objects.equals(level, other.level) && Objects.equals(origin, other.origin)
				&& Objects.equals(title, other.title);
	}

	public int hashCode() {
		return Objects.hash(id, title, level, detail, createdAt, origin, token, generatedBy, environment, stored, events);

	}
}
