from django.test import TestCase
from django.urls import resolve
from tombApp.views import home_page
from django.http import HttpRequest

# Create your tests here.
class HomePageTest(TestCase):
    def testHomePage(self):
        found = resolve('/')
        self.assertEqual(found.func, home_page, "test.py - Home resolves incorrectly")
