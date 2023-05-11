package com.dbfinal.VO;

import com.dbfinal.entity.Visitors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {

    private String token;

    private Visitors visitors;

}
