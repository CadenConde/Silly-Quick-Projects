import pyautogui
import pytesseract
import keyboard
import time 
from PIL import Image 

#run on human benchmark, verbal memorys
text = ''
seen = ["This will never be used"]

time.sleep(3)

left = 300
top = 500
width = 1400  # (600 - 100)
height = 100  # (600 - 100)

while True:
    myScreenshot = pyautogui.screenshot(region=(left, top, width, height))
    time.sleep(.05)
    myScreenshot.save('.\\screenshots\\word.png')
    image_path = '.\\screenshots\\word.png'
    img = Image.open(image_path)
    
    text = pytesseract.image_to_string(img)
    
    pyautogui.moveTo(1041, 652)
    for x in seen:
        if text == x:
            pyautogui.moveTo(863, 652) #(seen)
            break
        else:
            continue
            
    pyautogui.click()
    seen.append(text)
    if keyboard.is_pressed('ctrl+alt'):
        print("Ctrl + Alt pressed. Stopping the program.")
        exit()