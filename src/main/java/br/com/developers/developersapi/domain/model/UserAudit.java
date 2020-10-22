package br.com.developers.developersapi.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class UserAudit implements Serializable {

	private static final long serialVersionUID = 8453040276165370947L;

	@Column(name = "created_at")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	protected LocalDateTime createdAt;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	protected LocalDateTime updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return this.updatedAt == null ? getCreatedAt() : this.updatedAt;
	}
}
