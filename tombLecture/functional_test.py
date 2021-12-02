from selenium import webdriver
import unittest
class FunctionalTest(unittest.TestCase):
    def setUp(self):
        self.browser = webdriver.Chrome()
        self.browser.get('http://localhost:8000')

    def tearDown(self):
        self.browser.quit()

    #@unittest.SkipTest
    def test_title(self):
        self.assertIn('Django', self.browser.title, 'Functional test - test title - Wrong title')

if __name__ == '__main__':
    unittest.main()
    