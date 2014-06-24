package com.snooze;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
       format = {"html:target/cucumber"},
        tags = "@Signin")
public class Runfile{

}

