package org.com.dream.cloud.admin.api.service;

import org.com.dream.cloud.admin.api.entity.AuthUser;
import org.com.dream.cloud.commons.api.base.service.IBaseService;


public interface IAuthUserService extends IBaseService<AuthUser> {

    public AuthUser selectByName( String name);
}
