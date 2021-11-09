from selenium import webdriver
from selenium.webdriver.common import keys
from selenium.webdriver.common.by import By
import unittest

class TestName(unittest.TestCase):
    def setUp(self):
        #like @before
        #setup the browser
        self.browser = webdriver.Chrome()

    def tearDown(self):
        self.browser.quit()

    def test_SimpleTest(self):
        self.browser.get('http://demo.guru99.com/test/login.html')
        email = self.browser.find_element_by_id('email')
        passwd = self.browser.find_element(By.ID, 'passwd')
        button = self.browser.find_element(By.ID, 'SubmitLogin')

        email.send_keys('you@amil.com')
        passwd.send_keys('12345')
        button.click()

        h3 = self.browser.find_element(By.XPATH, '/html/body/div[2]/div/div/h3')

        expected = 'success.html'
        actual = self.browser.current_url
        self.assertIn(expected, actual, 'Wrong redireted page')

        expected = 'Successfully Logged in...'
        actual = h3.text

        self.assertEqual(expected, actual, 'Login message fails...')
        

if __name__ == '__main__':
    unittest.main()
