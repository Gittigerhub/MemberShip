package com.example.membership.DTO;

import com.example.membership.constant.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberShipDTO {

    private Long num;

    @NotBlank(message = "공백일 수 없습니다. 이름을 작성해주세요")
    @Size(min = 2, max = 10)
    private String name;        // 이름        // NotBlank, 최소: 2 ~ 최대: 10

    @NotBlank(message = "공백일 수 없습니다. 이메일을 작성해주세요")
    @Email(message = "이메일 형식에 맞춰서 작성하시오")
    @Size(max = 50, message = "최대 50글자 이내로 작성하셔야 합니다.")
    private String email;       // 이메일      // email, 최대: 50, 메세지 : 최대 50글자 이내로 작성하셔야 합니다.

    @NotBlank(message = "공백일 수 없습니다. 비밀번호를 작성해주세요")
    @Size(min =10, max = 16, message = "최소 10~ 최대 16 이내로 비밀번호를 작성하셔야 합니다.")
    private String password;    // 비밀번호     // NotBlank, 최소: 10 ~ 최대: 16, 메세지: 최소 10~ 최대 16 이내로 비밀번호를 작성하셔야 합니다.

    @NotBlank(message = "공백일 수 없습니다. 주소를 작성해주세요")
    private String address;     // 주소        // NotBlank

    // 권한
    private Role role;          // 이건 어짜피 유저디테일서비스에서 직접 넣어줄꺼임
    // 필요에 따라서 어드민 가입페이지와 일반유저 가입페이지가 분리될 수 있음
    // 위에 애들은은 값이 다 들어오지만 Role만 안들어 올것임
    // 기본타입 설정이 필요함, 서비스에서 가입시 어떤 권한으로 들어갈지 set해줌

}
