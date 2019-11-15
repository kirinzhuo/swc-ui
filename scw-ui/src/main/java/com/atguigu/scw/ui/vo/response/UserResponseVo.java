package com.atguigu.scw.ui.vo.response;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserResponseVo implements Serializable {

	private String accesstoken;
	
	  private Integer id;

	    private String loginacct;


	    private String username;

	    private String email;

	    private String authstatus;

	    private String usertype;

	    private String realname;

	    private String cardnum;

	    private String accttype;

}
