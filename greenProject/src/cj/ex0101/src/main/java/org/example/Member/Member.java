package org.example.member;
import lombok.*;

//@Data
@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString

public class Member {
    private String email;
    private String password;
    private String name;
    private String sign_date;
  }