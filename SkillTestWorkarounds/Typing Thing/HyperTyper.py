import pyautogui
import pytesseract
import time 
from PIL import Image 

#run on monkeytype 50 word test

text = ''
time.sleep(3)

left = 100
top = 520
width = 1700  # (600 - 100)
height = 170  # (600 - 100)

myScreenshot = pyautogui.screenshot(region=(left, top, width, height))
myScreenshot.save('.\\screenshots\\typeMe.png')
image_path = '.\\screenshots\\typeMe.png'
img = Image.open(image_path)
  
text = pytesseract.image_to_string(img) 
text = text.replace('\n',' ')

print(text)
pyautogui.typewrite(text)

for i in range(1):
    left = 100
    top = 570
    width = 1700  # (600 - 100)
    height = 100  # (600 - 100)

    time.sleep(.9)

    myScreenshot = pyautogui.screenshot(region=(left, top, width, height))
    myScreenshot.save('.\\screenshots\\typeMe.png')
    image_path = '.\\screenshots\\typeMe.png'
    img = Image.open(image_path)
    
    text = pytesseract.image_to_string(img) 
    text = text.replace('\n',' ')

    print(text)
    pyautogui.typewrite(text)