package com.fss.security.bo;

import com.fss.security.dao.UmsUserDao;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class UserPermissionBo implements Serializable {
    private UmsUserDao umsUserDao;
    private List<String> roleNames;
    private List<String> permissionNames;
}
