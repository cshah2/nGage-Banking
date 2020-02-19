<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>postTransaction</name>
   <tag></tag>
   <elementGuidId>977b5488-8d59-4c35-82d3-d371ba28c54b</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;entries\&quot;: [{\n\t\t\&quot;acctGroup\&quot;: ${acctGroup},\n\t\t\&quot;acctNbr\&quot;: \&quot;${acctNbr}\&quot;,\n\t\t\&quot;comment\&quot;: \&quot;${comment}\&quot;,\n\t\t\&quot;isDr\&quot;: ${isDr0},\n\t\t\&quot;posnAcctNbr\&quot;: \&quot;${posnAcctNbr}\&quot;,\n\t\t\&quot;posnId\&quot;: \&quot;${posnId}\&quot;,\n\t\t\&quot;trnAmt\&quot;: ${trnAmt}\n\t}, {\n\t\t\&quot;isDr\&quot;: ${isDr1},\n\t\t\&quot;trnAmt\&quot;: ${trnAmt}\n\t}],\n\t\&quot;mode\&quot;: 2,\n\t\&quot;trnCode\&quot;: \&quot;${trnCode}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>client_id</name>
      <type>Main</type>
      <value>${client_id}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>secret</name>
      <type>Main</type>
      <value>${secret}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Fnx-Header</name>
      <type>Main</type>
      <value>${fnxHeader}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${baseUrl}/core/v1/trn</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.FinxactURL</defaultValue>
      <description></description>
      <id>9530ffb0-7e37-4d9f-a74f-31a82123a22f</id>
      <masked>false</masked>
      <name>baseUrl</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.FnxClientId</defaultValue>
      <description></description>
      <id>e38b89be-c005-4718-8a97-4cfc3f405b9e</id>
      <masked>false</masked>
      <name>client_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.FnxSecretKey</defaultValue>
      <description></description>
      <id>bde78ff0-19ad-4b7c-90eb-95bd35d0886b</id>
      <masked>false</masked>
      <name>secret</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.FnxHeder</defaultValue>
      <description></description>
      <id>09af52fa-4773-4e50-92bf-1597844dd833</id>
      <masked>false</masked>
      <name>fnxHeader</name>
   </variables>
   <variables>
      <defaultValue>0</defaultValue>
      <description></description>
      <id>8a6e073e-ed82-47cc-90b4-710f89958f67</id>
      <masked>false</masked>
      <name>acctGroup</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>e792440c-02c9-4835-b209-5d71ede6f912</id>
      <masked>false</masked>
      <name>acctNbr</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>e942ca89-0edc-41ac-9c75-61c02dd697a2</id>
      <masked>false</masked>
      <name>comment</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>59acd4ae-3d72-4cff-8453-46322780c7d5</id>
      <masked>false</masked>
      <name>isDr0</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>c4481aa2-c6a4-4235-abd3-f19aa941fcad</id>
      <masked>false</masked>
      <name>isDr1</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>be19b0b7-e099-4b9f-9b02-cecaa23a9666</id>
      <masked>false</masked>
      <name>posnAcctNbr</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>d67e0f02-6c7d-484d-8e44-e860245d10f4</id>
      <masked>false</masked>
      <name>posnId</name>
   </variables>
   <variables>
      <defaultValue>0</defaultValue>
      <description></description>
      <id>ff23e4ea-7035-40b4-b0b2-f09e0ebdd4c5</id>
      <masked>false</masked>
      <name>trnAmt</name>
   </variables>
   <variables>
      <defaultValue>0</defaultValue>
      <description></description>
      <id>fedd89f2-6d82-4b84-aa42-a61abc8b64ec</id>
      <masked>false</masked>
      <name>trnCode</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
