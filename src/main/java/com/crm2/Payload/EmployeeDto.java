package com.crm2.Payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class EmployeeDto {
  private Long id;

  @Size(min = 3, message = "At least three char required")
    private String name;

  @Email
    private String emailId;

  @Size(min = 10, max = 10)
    private String mobile;
//private Date date;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public @Size(min = 10, max = 10) String getMobile() {
    return mobile;
  }

  public void setMobile(@Size(min = 10, max = 10) String mobile) {
    this.mobile = mobile;
  }

  public @Email String getEmailId() {
    return emailId;
  }

  public void setEmailId(@Email String emailId) {
    this.emailId = emailId;
  }

  public @Size(min = 3, message = "At least three char required") String getName() {
    return name;
  }

  public void setName(@Size(min = 3, message = "At least three char required") String name) {
    this.name = name;
  }
}
