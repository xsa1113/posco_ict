<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

//database에서 산출
String name = "성춘향";
int age = 16;
String birth = "09/03/12";


String json = "{ \"name\":" +name + "\", \"age\":" + age + ", \"birth\":\"" + birth + "\"}";
out.println(json);

%>