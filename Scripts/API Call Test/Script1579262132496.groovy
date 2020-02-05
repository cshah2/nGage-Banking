import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.javafaker.Faker
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import actions.Email
import constants.Operator
import internal.GlobalVariable as GlobalVariable

//CustomKeywords.'actions.Email.verifyMailSubject'('pramod.m@1secmail.com', 0, 'Your Savana Bank Activation Code', Operator.EQUALS)
//
//CustomKeywords.'actions.Email.getVerificationCode'('pramod.m@1secmail.com', 0)

//CustomKeywords.'actions.Email.getTemporaryPassword'('sav.auto@1secmail.com', 1)

Faker faker = new Faker(Locale.US)

println "Password1 = "+faker.internet().password()
println "Password2 = "+faker.internet().password(true)
println "Password3 = "+faker.internet().password(8, 15)
println "Password4 = "+faker.internet().password(8, 15, true)
println "Password5 = "+faker.internet().password(12, 16, true, true)
println "Password6 = "+faker.internet().password(8, 15, true, true, true)