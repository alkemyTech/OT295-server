//------------------------------------------------------------------------------//
//  EmailServiceInterface: send emails in different situations
//
//  By                          DATE                TICKET              DETAILS/CHANGES
//  Daniel-Zemanate             2022-09-17          OT295-28            Interface for sending emails. Arguments to create any kind of email.
//------------------------------------------------------------------------------//

package com.alkemy.ong.service;

public interface EmailServiceInterface {

    void sendEmailTo(String to, String template);


}
