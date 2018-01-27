#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jan 24 13:26:57 2018

@author: Fall
"""

import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(-5,5,1000)
y = np.sin(x)
plt.plot(x, y, label="objective")
plt.plot(x, 0*x+0.5, color="r", linestyle="--", label="constraint")
plt.fill_between(x, -1, 1, where=y>=0.5, label="feasible region", alpha=0.3)
plt.plot([-7*np.pi/6, np.pi/6, 5*np.pi/6], 0.5+np.zeros(3), '*', color="orange", markersize=12, label="solutions")
plt.legend()
plt.title("$\min_x \; \sin(x) \; s.t. \; \sin(x)\geq 0.5$")
plt.show()

x = np.linspace(-10,10,1000)
plt.plot(x,x**2)
plt.title("A convex function")
plt.show()

plt.figure()
plt.plot(x, -x*np.sin(x))
plt.title("A non-convex function")
plt.show()

plt.figure()
plt.plot(x, np.sqrt(np.abs(x)))
plt.title("A non-convex function with only one minimum.")
plt.show()