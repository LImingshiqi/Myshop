package com.lmx.myshop.web.api.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lmx.myshop.commons.persitence.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by LMX on 2019/8/1 10:17
 */
@Data
public class TbUserDto extends BaseEntity implements Serializable    {

        private String username;

        @JsonIgnore
        private String password;
        private String email;
        private String phone;

}
