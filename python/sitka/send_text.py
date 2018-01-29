#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Jan 13 01:10:11 2018

@author: Fall
"""

from twilio.rest import Client

# Your Account SID from twilio.com/console
account_sid = "AC906c242a0789f352f85a727fc63523ce"
# Your Auth Token from twilio.com/console
auth_token  = "22eb3aac271f16d0ad372199ab7b66cf"

client = Client(account_sid, auth_token)

message = client.messages.create(
    to="+16045052781", 
    from_="+16048002606",
    body="Hello from Python!")

print(message.sid)
