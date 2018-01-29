import webbrowser
import time

total_breaks = 3
break_count = 0

print ('This program started on' + time.ctime())
while (break_count < total_breaks):
    print('Working...')
    time.sleep(5)
    print('Take a break!')
    webbrowser.open('https://www.youtube.com/watch?v=Aw6a0nGgduw')
    break_count = break_count + 1
print ('Time to go home!')
