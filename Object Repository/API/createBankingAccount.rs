<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>createBankingAccount</name>
   <tag></tag>
   <elementGuidId>50dbe4f1-3f18-4074-9cbe-05509d1f5308</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;customer\&quot;: {\n\t\t\&quot;customerGroup\&quot;: \&quot;2\&quot;,\n\t\t\&quot;customerId\&quot;: \&quot;${consumerId}\&quot;\n\t},\n\t\&quot;newAccounts\&quot;: [{\n\t\t\&quot;Acct\&quot;: {\n\t\t\t\&quot;acct_bk\&quot;: {\n\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\&quot;acctGroup\&quot;: 1,\n\t\t\t\t\&quot;acctNbr\&quot;: \&quot;${acctNbr}\&quot;,\n\t\t\t\t\&quot;acctTitle\&quot;: \&quot;${acctTitle}\&quot;,\n\t\t\t\t\&quot;acctType\&quot;: \&quot;${acctOwnership}\&quot;,\n\t\t\t\t\&quot;desc\&quot;: \&quot;${desc}\&quot;,\n\t\t\t\t\&quot;isBrokered\&quot;: false,\n\t\t\t\t\&quot;isElectronicStmt\&quot;: true,\n\t\t\t\t\&quot;isPaperStmt\&quot;: false,\n\t\t\t\t\&quot;isWthFed\&quot;: false,\n\t\t\t\t\&quot;isWthNra\&quot;: false,\n\t\t\t\t\&quot;isWthState\&quot;: false,\n\t\t\t\t\&quot;signedDocs\&quot;: [],\n\t\t\t\t\&quot;stmtFreq\&quot;: \&quot;1D\&quot;,\n\t\t\t\t\&quot;tmZoneCode\&quot;: \&quot;utc\&quot;\n\t\t\t},\n\t\t\t\&quot;posn_depDtl\&quot;: [{\n\t\t\t\t\&quot;posn_dep\&quot;: {\n\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\&quot;acctgSeg\&quot;: {\n\t\t\t\t\t\t\&quot;deptId\&quot;: \&quot;350\&quot;,\n\t\t\t\t\t\t\&quot;vertical\&quot;: \&quot;01\&quot;\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;bal\&quot;: 0,\n\t\t\t\t\t\&quot;ccyCode\&quot;: \&quot;USD\&quot;,\n\t\t\t\t\t\&quot;posnName\&quot;: \&quot;${posnName}\&quot;,\n\t\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode}\&quot;,\n\t\t\t\t\t\&quot;subBals\&quot;: {\n\t\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\t\&quot;dec0\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec2\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec5\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t}\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;tmZoneCode\&quot;: \&quot;utc\&quot;\n\t\t\t\t},\n\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode}\&quot;\n\t\t\t}],\n\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode}\&quot;\n\t\t},\n\t\t\&quot;AcctPartyRel\&quot;: {\n\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\&quot;partyAcctName\&quot;: \&quot;${acctTitle}\&quot;,\n\t\t\t\&quot;partyPct\&quot;: 100,\n\t\t\t\&quot;relType\&quot;: \&quot;1\&quot;\n\t\t}\n\t}]\n}&quot;,
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
   <restUrl>${baseUrl}/core/v1/customer/linkAccount</restUrl>
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
      <defaultValue>''</defaultValue>
      <description></description>
      <id>413ee374-d3dd-407a-be24-e77c6f00512b</id>
      <masked>false</masked>
      <name>consumerId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>46330815-0355-4ff1-a342-3a0279c1cbf8</id>
      <masked>false</masked>
      <name>acctNbr</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>45dbcee6-a022-4f71-96cb-e2106292767d</id>
      <masked>false</masked>
      <name>acctTitle</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>63624d4e-8a15-47a9-8da6-889ab50f9b74</id>
      <masked>false</masked>
      <name>acctOwnership</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>2a47b165-d817-4062-8ab4-8e4840809cd9</id>
      <masked>false</masked>
      <name>desc</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>e17c64da-f67a-4f82-8d90-a2b41fee7086</id>
      <masked>false</masked>
      <name>posnName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>efdcb03f-d35b-4697-8c4e-da219df9fd9b</id>
      <masked>false</masked>
      <name>prodCode</name>
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
