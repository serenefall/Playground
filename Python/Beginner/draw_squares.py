import turtle

def draw_square(some_turtle):
    for i in range(1, 5):
        some_turtle.forward(100)
        some_turtle.right(90)

def draw_art(num, speed):
    window = turtle.Screen()
    window.bgcolor('yellow')

    brad = turtle.Turtle()
    brad.shape('turtle')
    brad.color('blue')
    brad.speed(speed)

    for i in range(0, num):
        draw_square(brad)
        brad.right(360/num) 

    brad.right(90)
    brad.forward(250)
    
draw_art(12, 15)
