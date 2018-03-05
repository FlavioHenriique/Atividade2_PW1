package com.ifpb.atividade2.command;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public interface Command {
 
    
    void execute(HttpServletRequest request, HttpServletResponse response);
}
