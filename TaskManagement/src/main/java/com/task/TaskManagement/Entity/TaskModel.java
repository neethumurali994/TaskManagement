package com.task.TaskManagement.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class TaskModel {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
	    @NotEmpty
	    @Size(min=5, max=30)
		private String description;
		@NotEmpty
		private String dateP;
		@NotEmpty
		private String startTime;
		@NotEmpty
		private String endTime;
		@ManyToOne
		@JoinColumn(name ="UserModel_email")
		private UserModel user;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String desc) {
			this.description = desc;
		}
		public String getDateP() {
			return dateP;
		}
		public void setDateP(String dateP) {
			this.dateP = dateP;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public UserModel getUser() {
			return user;
		}
		public void setUser(UserModel user) {
			this.user = user;
		}
		@Override
		public String toString() {
			return "Task [id=" + id + ", description=" + description + ", date=" + dateP + ", startTime=" + startTime + ", endTime="
					+ endTime + ", user=" + user + "]";
		}
		public TaskModel(String description, String dateP, String startTime, String endTime) {
			super();
			this.description = description;
			this.dateP = dateP;
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		public TaskModel()
		{
			
		}
}
