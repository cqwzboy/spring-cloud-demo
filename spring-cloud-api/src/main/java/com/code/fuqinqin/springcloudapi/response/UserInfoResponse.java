package com.code.fuqinqin.springcloudapi.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author fuqinqin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse implements Serializable {
    private Long userId;
    private String userName;
    private Integer age;
}
