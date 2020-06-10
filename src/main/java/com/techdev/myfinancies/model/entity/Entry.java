package com.techdev.myfinancies.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.techdev.myfinancies.model.enums.EntryStatus;
import com.techdev.myfinancies.model.enums.EntryType;

@Entity
@Table(name = "entry", schema ="finance")
public class Entry {
	
	
	@Id
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name = "month")
	private Integer month;
	@Column (name = "year")
	private Integer year;
	@Column (name = "value")
	private BigDecimal value;
	@ManyToOne
	@JoinColumn (name = "user_id")
	private User user;
	@Column(name = "register_date")
	@Convert(converter= Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate entryDate;
	@Column(name = "type")
	@Enumerated(value = EnumType.STRING)
	private EntryType type;
	@Column(name = "status")
	@Enumerated(value = EnumType.STRING)
	private EntryStatus status;
	
	public Entry(){
	}

	public Entry(Long id, Integer month, Integer year, BigDecimal value, User user, LocalDate entryDate, EntryType type,
			EntryStatus status) {
		super();
		this.id = id;
		this.month = month;
		this.year = year;
		this.value = value;
		this.user = user;
		this.entryDate = entryDate;
		this.type = type;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public EntryType getType() {
		return type;
	}

	public void setType(EntryType type) {
		this.type = type;
	}

	public EntryStatus getStatus() {
		return status;
	}

	public void setStatus(EntryStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entryDate == null) ? 0 : entryDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entry other = (Entry) obj;
		if (entryDate == null) {
			if (other.entryDate != null)
				return false;
		} else if (!entryDate.equals(other.entryDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", month=" + month + ", year=" + year + ", value=" + value + ", user=" + user
				+ ", entryDate=" + entryDate + ", type=" + type + ", status=" + status + "]";
	}
	
	
	
		
}
