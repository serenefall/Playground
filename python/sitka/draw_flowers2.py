#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Jan  7 00:34:27 2018

@author: Fall
"""

import turtle

def draw_diamond(some_turtle):
    for i in range(0, 2):
        some_turtle.forward(100)
        some_turtle.right(60)
        some_turtle.forward(100)
        some_turtle.right(120)

def draw_art(num, speed):
    window = turtle.Screen()
    window.bgcolor('yellow')

    brad = turtle.Turtle()
    brad.shape('turtle')
    brad.color('red')
    brad.speed(speed)

    for i in range(0, num):
        draw_diamond(brad)
        brad.right(360/num) 

    brad.right(90)
    brad.forward(300)
    
    window.exitonclick()
    
draw_art(10, 15)
