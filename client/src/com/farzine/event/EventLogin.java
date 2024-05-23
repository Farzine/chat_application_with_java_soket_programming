package com.farzine.event;

import com.farzine.model.Model_Login;
import com.farzine.model.Model_Register;

public interface EventLogin {

    public void login(Model_Login data);

    public void register(Model_Register data, EventMessage message);

    public void goRegister();

    public void goLogin();
}
