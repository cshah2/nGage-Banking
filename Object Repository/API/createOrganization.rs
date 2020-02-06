<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>createOrganization</name>
   <tag></tag>
   <elementGuidId>6fc4b493-ebfc-4488-a917-16644ae531ca</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;addresses\&quot;: [{\n\t\t\&quot;_schVn\&quot;: 0,\n\t\t\&quot;_vn\&quot;: 0,\n\t\t\&quot;addrType\&quot;: 1,\n\t\t\&quot;city\&quot;: \&quot;${city}\&quot;,\n\t\t\&quot;cntry\&quot;: \&quot;US\&quot;,\n\t\t\&quot;label\&quot;: \&quot;PA\&quot;,\n\t\t\&quot;postCode\&quot;: \&quot;${zipcode}\&quot;,\n\t\t\&quot;region\&quot;: \&quot;AL\&quot;,\n\t\t\&quot;street\&quot;: \&quot;${addressLine1}\&quot;,\n\t\t\&quot;street2\&quot;: \&quot;${addressLine2}\&quot;,\n\t\t\&quot;street3\&quot;: \&quot;${addressLine3}\&quot;,\n\t\t\&quot;street4\&quot;: \&quot;${addressLine4}\&quot;,\n\t\t\&quot;validFromDtm\&quot;: \&quot;${addressValidFrom}\&quot;,\n\t\t\&quot;validToDtm\&quot;: \&quot;${addressValidUntil}\&quot;,\n\t\t\&quot;verifyDtm\&quot;: \&quot;${addressVerifiedDate}\&quot;,\n\t\t\&quot;yrsAddr\&quot;: 0\n\t}],\n\t\&quot;customer\&quot;: {\n\t\t\&quot;customerGroup\&quot;: \&quot;2\&quot;,\n\t\t\&quot;customerId\&quot;: \&quot;${customerId}\&quot;,\n\t\t\&quot;loginId\&quot;: \&quot;${email}\&quot;,\n\t\t\&quot;startDtm\&quot;: \&quot;2020-02-05T14:06:17Z\&quot;\n\t},\n\t\&quot;party_org\&quot;: {\n\t\t\&quot;_schVn\&quot;: 0,\n\t\t\&quot;cntry\&quot;: \&quot;US\&quot;,\n\t\t\&quot;contactPref\&quot;: 2,\n\t\t\&quot;dbaName\&quot;: \&quot;${dbaName}\&quot;,\n\t\t\&quot;desc\&quot;: \&quot;${description}\&quot;,\n\t\t\&quot;dunsNbr\&quot;: ${dbnumber},\n\t\t\&quot;emails\&quot;: [{\n\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\&quot;data\&quot;: \&quot;${email}\&quot;,\n\t\t\t\&quot;emailType\&quot;: 1,\n\t\t\t\&quot;isPreferred\&quot;: false,\n          \t\&quot;validFromDtm\&quot;: \&quot;${emailValidFrom}\&quot;,\n\t\t\t\&quot;validToDtm\&quot;: \&quot;${emailValidUntil}\&quot;,\n\t\t\t\&quot;verifyDtm\&quot;: \&quot;${emailVerifiedDate}\&quot;\n\t\t}],\n\t\t\&quot;estDate\&quot;: \&quot;2020-02-05\&quot;,\n\t\t\&quot;isGovtOwn\&quot;: true,\n\t\t\&quot;isIntrntl\&quot;: true,\n\t\t\&quot;isPubliclyHeld\&quot;: true,\n\t\t\&quot;isSmallBusiness\&quot;: true,\n\t\t\&quot;isTaxExempt\&quot;: true,\n\t\t\&quot;name\&quot;: \&quot;${orgName}\&quot;,\n\t\t\&quot;party_orgDueDiligence\&quot;: {\n\t\t\t\&quot;acceptRccPmt\&quot;: false,\n\t\t\t\&quot;acctPurpose\&quot;: 0,\n\t\t\t\&quot;amtACHMo\&quot;: 1,\n\t\t\t\&quot;amtMobileDepMo\&quot;: 1,\n\t\t\t\&quot;amtRemoteDepMo\&quot;: 1,\n\t\t\t\&quot;amtWiresMo\&quot;: 1,\n\t\t\t\&quot;chkGrtrThsnd\&quot;: false,\n\t\t\t\&quot;cntACHMo\&quot;: 1,\n\t\t\t\&quot;cntMobileDepMo\&quot;: 1,\n\t\t\t\&quot;cntRemoteDepMo\&quot;: 1,\n\t\t\t\&quot;cntWiresMo\&quot;: 1,\n\t\t\t\&quot;estmtdAnnualRevenue\&quot;: 1,\n\t\t\t\&quot;hdqtrsCntry\&quot;: \&quot;US\&quot;,\n\t\t\t\&quot;industry\&quot;: 11,\n\t\t\t\&quot;internetGamblingInc\&quot;: true,\n\t\t\t\&quot;intrmySvcs\&quot;: [],\n\t\t\t\&quot;isAtmOper\&quot;: true,\n\t\t\t\&quot;isCharity\&quot;: true,\n\t\t\t\&quot;isMarijuanaBusiness\&quot;: true,\n\t\t\t\&quot;isThirdPartyBenefit\&quot;: true,\n\t\t\t\&quot;mnyOrderGrtrThsnd\&quot;: false,\n\t\t\t\&quot;nbrLoc\&quot;: 1,\n\t\t\t\&quot;nonCashActivities\&quot;: true,\n\t\t\t\&quot;operCntry\&quot;: [\&quot;US\&quot;],\n\t\t\t\&quot;pctRevenueMnySvcs\&quot;: 1,\n\t\t\t\&quot;structure\&quot;: 1,\n\t\t\t\&quot;tfrForCust\&quot;: true,\n\t\t\t\&quot;virtualCcy\&quot;: true,\n\t\t\t\&quot;yearsOwnBusiness\&quot;: 1\n\t\t},\n\t\t\&quot;phones\&quot;: [{\n\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\&quot;data\&quot;: \&quot;${phone}\&quot;,\n\t\t\t\&quot;isPreferred\&quot;: false,\n\t\t\t\&quot;phoneType\&quot;: 1,\n\t\t\t\&quot;validFromDtm\&quot;: \&quot;${phoneValidFrom}\&quot;,\n\t\t\t\&quot;validToDtm\&quot;: \&quot;${phoneValidUntil}\&quot;,\n\t\t\t\&quot;verifyDtm\&quot;: \&quot;${phoneVerifiedDate}\&quot;\n\t\t}],\n\t\t\&quot;region\&quot;: \&quot;AL\&quot;,\n\t\t\&quot;taxExemptType\&quot;: 1,\n\t\t\&quot;tin\&quot;: \&quot;${taxId}\&quot;,\n\t\t\&quot;tinType\&quot;: 1,\n\t\t\&quot;tradeName\&quot;: \&quot;${tradeName}\&quot;,\n\t\t\&quot;webSiteURL\&quot;: \&quot;${website}\&quot;\n\t}\n}&quot;,
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
   <restUrl>${baseUrl}/core/v1/customer/organization</restUrl>
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
      <id>ec8f7e48-8f61-4fc1-b186-51e436fe705f</id>
      <masked>false</masked>
      <name>customerId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>c4ea178e-0ed2-4108-9a42-88037f740757</id>
      <masked>false</masked>
      <name>taxId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>2fd6e563-6761-47fa-9bee-851353bb683c</id>
      <masked>false</masked>
      <name>addressLine1</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>fa679d9c-7f55-4eae-990e-abc3f0bc0457</id>
      <masked>false</masked>
      <name>addressLine2</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>f195ac84-0f6b-4881-8923-576ba11d0556</id>
      <masked>false</masked>
      <name>addressLine3</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>285bc3fe-e15f-4667-86b4-95dd2bfa0f88</id>
      <masked>false</masked>
      <name>addressLine4</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>0439fd23-f5c3-4feb-9930-6ea90b634248</id>
      <masked>false</masked>
      <name>city</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>48c0b4ce-3baa-487d-942a-5c5dbe067817</id>
      <masked>false</masked>
      <name>zipcode</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>417fa6e6-3d86-4a39-9d15-e90c73729fad</id>
      <masked>false</masked>
      <name>addressValidFrom</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>501d4f1c-e570-4dd7-ad62-83cd50fa98a3</id>
      <masked>false</masked>
      <name>addressValidUntil</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>81d18d3d-7ed0-4dbb-b45c-85fb622b2f05</id>
      <masked>false</masked>
      <name>addressVerifiedDate</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>9fa646a5-c9c7-47c2-971c-bb275afd5228</id>
      <masked>false</masked>
      <name>email</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>3cd73171-fd82-40be-a9aa-63f1e53b3215</id>
      <masked>false</masked>
      <name>emailValidFrom</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>d8f5c858-bf60-424d-86a2-a14135a3a1da</id>
      <masked>false</masked>
      <name>emailValidUntil</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>346e5a7b-5416-4d8b-b861-a33e994057da</id>
      <masked>false</masked>
      <name>emailVerifiedDate</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>4278f378-1913-422a-88c4-4264a619f146</id>
      <masked>false</masked>
      <name>website</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>2f6fb0ea-03eb-4f44-ac8e-0720d3d0043f</id>
      <masked>false</masked>
      <name>phone</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>f5147254-706e-42fa-9096-cc7fa79c968e</id>
      <masked>false</masked>
      <name>phoneValidFrom</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>5f90f8b4-b0cb-4270-8ea7-c0c5280cb42d</id>
      <masked>false</masked>
      <name>phoneValidUntil</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>72fcc26c-6138-435b-973d-477d7aa50b8e</id>
      <masked>false</masked>
      <name>phoneVerifiedDate</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>411b649e-1df0-40a0-98a9-e00ddba12a66</id>
      <masked>false</masked>
      <name>tradeName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>c6409c57-dc62-425c-be26-2e480b7ed310</id>
      <masked>false</masked>
      <name>orgName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>33501fcc-6182-4ed9-a197-2319e5e36db0</id>
      <masked>false</masked>
      <name>dbaName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>3de0cac3-ac5d-435c-8740-b1a85d729a5c</id>
      <masked>false</masked>
      <name>description</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>56e2f19c-b20b-48fe-b5c9-f77fc0207278</id>
      <masked>false</masked>
      <name>dbnumber</name>
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
