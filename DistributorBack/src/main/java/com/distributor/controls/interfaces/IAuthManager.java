package com.distributor.controls.interfaces;

import com.distributor.models.Credential;

public interface IAuthManager {

    String getConnectReturnToken(Credential credential);
}
