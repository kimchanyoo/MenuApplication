from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
import time

def get_anu_meal():
    url = 'https://www.andong.ac.kr/main/module/foodMenu/index.do?menu_idx=222'

    # 웹 드라이버 실행
    driver = webdriver.Chrome(service= Service(ChromeDriverManager().install()))  # Chrome 웹 드라이버의 경로를 지정하세요.
    driver.get(url)

    # 페이지가 완전히 로드될 때까지 기다림
    time.sleep(2)

    # # 자바스크립트 함수 실행 - 이전날 불러오기
    # driver.execute_script("prevDay();")
    # time.sleep(2)  # 자바스크립트 함수가 완전히 실행되기까지 기다림

    # # 자바스크립트 함수 실행 - 다음날 불러오기
    driver.execute_script("nextDay();")
    time.sleep(2)  # 자바스크립트 함수가 완전히 실행되기까지 기다림

    # # 자바스크립트 함수 실행 - 다음날 불러오기
    # driver.execute_script("nextDay();")
    # time.sleep(2)  # 자바스크립트 함수가 완전히 실행되기까지 기다림


    breakfast_temp = driver.find_element(By.XPATH,'//*[@id="container"]/div[5]/div[2]/dl[1]/dd').text
    lunch_temp = driver.find_element(By.XPATH,'//*[@id="container"]/div[5]/div[2]/dl[2]/dd').text
    dinner_temp = driver.find_element(By.XPATH,'//*[@id="container"]/div[5]/div[2]/dl[3]/dd').text
    date_temp = driver.find_element(By.XPATH,'//*[@id="container"]/div[2]/span').text
    date = date_temp[:-3]
    print(date)

    # 함수화시 문자열이 여러개로 출력되는 문제 
    breakfast_temp = list(breakfast_temp)
    temp_list = []
    for i in breakfast_temp:
        temp = i.replace("\n", " ")
        temp_list.append(temp)
    breakfast = "".join(temp_list)
    print(breakfast)

    temp_list = []
    for i in lunch_temp:
        temp = i.replace("\n", " ")
        temp_list.append(temp)
    lunch = "".join(temp_list)
    print(lunch)

    dinner_temp = list(dinner_temp)
    temp_list = []
    for i in dinner_temp:
        temp = i.replace("\n", " ")
        temp_list.append(temp)
    dinner = "".join(temp_list)
    print(dinner)
    
    # # 웹 드라이버 종료
    driver.quit()

get_anu_meal()