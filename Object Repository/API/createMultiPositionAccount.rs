<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>createMultiPositionAccount</name>
   <tag></tag>
   <elementGuidId>6abdd271-4489-4ddf-b1ae-fecb0e23e241</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;customer\&quot;: {\n\t\t\&quot;customerGroup\&quot;: \&quot;2\&quot;,\n\t\t\&quot;customerId\&quot;: \&quot;${consumerId}\&quot;\n\t},\n\t\&quot;newAccounts\&quot;: [{\n\t\t\&quot;Acct\&quot;: {\n\t\t\t\&quot;acct_bk\&quot;: {\n\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\&quot;acctGroup\&quot;: 3,\n\t\t\t\t\&quot;acctNbr\&quot;: \&quot;${acctNbr}\&quot;,\n\t\t\t\t\&quot;acctTitle\&quot;: \&quot;${acctTitle}\&quot;,\n\t\t\t\t\&quot;acctType\&quot;: \&quot;${acctOwnership}\&quot;,\n\t\t\t\t\&quot;desc\&quot;: \&quot;${desc}\&quot;,\n\t\t\t\t\&quot;isBrokered\&quot;: true,\n\t\t\t\t\&quot;isElectronicStmt\&quot;: true,\n\t\t\t\t\&quot;isPaperStmt\&quot;: true,\n\t\t\t\t\&quot;isWthFed\&quot;: false,\n\t\t\t\t\&quot;isWthNra\&quot;: false,\n\t\t\t\t\&quot;isWthState\&quot;: false,\n\t\t\t\t\&quot;signedDocs\&quot;: [{\n\t\t\t\t\t\&quot;docSubType\&quot;: \&quot;1\&quot;,\n\t\t\t\t\t\&quot;docType\&quot;: 1,\n\t\t\t\t\t\&quot;signedBy\&quot;: {\n\t\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\t\&quot;ageBracket\&quot;: 0,\n\t\t\t\t\t\t\&quot;contactPref\&quot;: 0,\n\t\t\t\t\t\t\&quot;education\&quot;: 0,\n\t\t\t\t\t\t\&quot;employmentStatus\&quot;: 0,\n\t\t\t\t\t\t\&quot;ethnicity\&quot;: 0,\n\t\t\t\t\t\t\&quot;familiarName\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;gender\&quot;: 0,\n\t\t\t\t\t\t\&quot;incBracket\&quot;: 0,\n\t\t\t\t\t\t\&quot;maidenName\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;maritalStatus\&quot;: 0,\n\t\t\t\t\t\t\&quot;middleName\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;moGrossInc\&quot;: 0,\n\t\t\t\t\t\t\&quot;mothersMaidenName\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;name\&quot;: \&quot;Neha\&quot;,\n\t\t\t\t\t\t\&quot;nbrInHhold\&quot;: 0,\n\t\t\t\t\t\t\&quot;occupation\&quot;: 0,\n\t\t\t\t\t\t\&quot;prefix\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;residencyStatus\&quot;: 0,\n\t\t\t\t\t\t\&quot;spouse\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;studentType\&quot;: 0,\n\t\t\t\t\t\t\&quot;suffix\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;tinType\&quot;: 0,\n\t\t\t\t\t\t\&quot;webAddr\&quot;: \&quot;\&quot;\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;signedDtm\&quot;: \&quot;2020-02-06T05:00:00Z\&quot;,\n\t\t\t\t\t\&quot;version\&quot;: \&quot;1\&quot;\n\t\t\t\t}, {\n\t\t\t\t\t\&quot;docSubType\&quot;: \&quot;1\&quot;,\n\t\t\t\t\t\&quot;docType\&quot;: 2,\n\t\t\t\t\t\&quot;signedBy\&quot;: {\n\t\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\t\&quot;ageBracket\&quot;: 0,\n\t\t\t\t\t\t\&quot;contactPref\&quot;: 0,\n\t\t\t\t\t\t\&quot;education\&quot;: 0,\n\t\t\t\t\t\t\&quot;employmentStatus\&quot;: 0,\n\t\t\t\t\t\t\&quot;ethnicity\&quot;: 0,\n\t\t\t\t\t\t\&quot;familiarName\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;gender\&quot;: 0,\n\t\t\t\t\t\t\&quot;incBracket\&quot;: 0,\n\t\t\t\t\t\t\&quot;maidenName\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;maritalStatus\&quot;: 0,\n\t\t\t\t\t\t\&quot;middleName\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;moGrossInc\&quot;: 0,\n\t\t\t\t\t\t\&quot;mothersMaidenName\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;name\&quot;: \&quot;Neha\&quot;,\n\t\t\t\t\t\t\&quot;nbrInHhold\&quot;: 0,\n\t\t\t\t\t\t\&quot;occupation\&quot;: 0,\n\t\t\t\t\t\t\&quot;prefix\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;residencyStatus\&quot;: 0,\n\t\t\t\t\t\t\&quot;spouse\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;studentType\&quot;: 0,\n\t\t\t\t\t\t\&quot;suffix\&quot;: \&quot;\&quot;,\n\t\t\t\t\t\t\&quot;tinType\&quot;: 0,\n\t\t\t\t\t\t\&quot;webAddr\&quot;: \&quot;\&quot;\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;signedDtm\&quot;: \&quot;2020-02-06T05:00:00Z\&quot;,\n\t\t\t\t\t\&quot;version\&quot;: \&quot;1\&quot;\n\t\t\t\t}],\n\t\t\t\t\&quot;stmtFreq\&quot;: \&quot;0ME\&quot;,\n\t\t\t\t\&quot;tmZoneCode\&quot;: \&quot;usnyc\&quot;,\n\t\t\t\t\&quot;localeData\&quot;: {\n\t\t\t\t\t\&quot;referenceId\&quot;: \&quot;shilpa\&quot;\n\t\t\t\t}\n\t\t\t},\n\t\t\t\&quot;posn_depDtl\&quot;: [{\n\t\t\t\t\&quot;posn_dep\&quot;: {\n\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\&quot;acctgSeg\&quot;: {\n\t\t\t\t\t\t\&quot;deptId\&quot;: \&quot;350\&quot;,\n\t\t\t\t\t\t\&quot;vertical\&quot;: \&quot;01\&quot;\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;bal\&quot;: 0,\n\t\t\t\t\t\&quot;ccyCode\&quot;: \&quot;USD\&quot;,\n\t\t\t\t\t\&quot;posnName\&quot;: \&quot;${posnName}\&quot;,\n\t\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode}\&quot;,\n\t\t\t\t\t\&quot;subBals\&quot;: {\n\t\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\t\&quot;dec0\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec2\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec5\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t}\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;tmZoneCode\&quot;: \&quot;usnyc\&quot;\n\t\t\t\t},\n\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode}\&quot;\n\t\t\t}, {\n\t\t\t\t\&quot;posn_dep\&quot;: {\n\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\&quot;acctgSeg\&quot;: {\n\t\t\t\t\t\t\&quot;deptId\&quot;: \&quot;350\&quot;,\n\t\t\t\t\t\t\&quot;vertical\&quot;: \&quot;01\&quot;\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;bal\&quot;: 0,\n\t\t\t\t\t\&quot;ccyCode\&quot;: \&quot;USD\&quot;,\n\t\t\t\t\t\&quot;posnName\&quot;: \&quot;${posnName2}\&quot;,\n\t\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode2}\&quot;,\n\t\t\t\t\t\&quot;subBals\&quot;: {\n\t\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\t\&quot;dec0\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec2\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec5\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t}\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;tmZoneCode\&quot;: \&quot;usnyc\&quot;\n\t\t\t\t},\n\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode2}\&quot;\n\t\t\t}, {\n\t\t\t\t\&quot;posn_dep\&quot;: {\n\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\&quot;acctgSeg\&quot;: {\n\t\t\t\t\t\t\&quot;deptId\&quot;: \&quot;350\&quot;,\n\t\t\t\t\t\t\&quot;vertical\&quot;: \&quot;01\&quot;\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;bal\&quot;: 0,\n\t\t\t\t\t\&quot;ccyCode\&quot;: \&quot;USD\&quot;,\n\t\t\t\t\t\&quot;posnName\&quot;: \&quot;${posnName3}\&quot;,\n\t\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode3}\&quot;,\n\t\t\t\t\t\&quot;subBals\&quot;: {\n\t\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\t\&quot;dec0\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec2\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec5\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t}\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;tmZoneCode\&quot;: \&quot;usnyc\&quot;\n\t\t\t\t},\n\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode3}\&quot;\n\t\t\t}],\n\t\t\t\&quot;posn_lnDtl\&quot;: [{\n\t\t\t\t\&quot;posn_ln\&quot;: {\n\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\&quot;acctgSeg\&quot;: {\n\t\t\t\t\t\t\&quot;deptId\&quot;: \&quot;350\&quot;,\n\t\t\t\t\t\t\&quot;vertical\&quot;: \&quot;01\&quot;\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;availBal\&quot;: 0,\n\t\t\t\t\t\&quot;bal\&quot;: 0,\n\t\t\t\t\t\&quot;ccyCode\&quot;: \&quot;USD\&quot;,\n\t\t\t\t\t\&quot;crLimit\&quot;: ${credLimit4},\n\t\t\t\t\t\&quot;posnName\&quot;: \&quot;${posnName4}\&quot;,\n\t\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode4}\&quot;,\n\t\t\t\t\t\&quot;subBals\&quot;: {\n\t\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\t\&quot;dec0\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec2\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec5\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t}\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;tmZoneCode\&quot;: \&quot;usnyc\&quot;,\n\t\t\t\t\t\&quot;subBalAmts\&quot;: {\n\t\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\t\&quot;dec0\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec2\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec5\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t},\n\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode4}\&quot;\n\t\t\t}, {\n\t\t\t\t\&quot;posn_ln\&quot;: {\n\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\&quot;acctgSeg\&quot;: {\n\t\t\t\t\t\t\&quot;deptId\&quot;: \&quot;350\&quot;,\n\t\t\t\t\t\t\&quot;vertical\&quot;: \&quot;01\&quot;\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;availBal\&quot;: 0,\n\t\t\t\t\t\&quot;bal\&quot;: 0,\n\t\t\t\t\t\&quot;ccyCode\&quot;: \&quot;USD\&quot;,\n\t\t\t\t\t\&quot;crLimit\&quot;: ${credLimit5},\n\t\t\t\t\t\&quot;posnName\&quot;: \&quot;${posnName5}\&quot;,\n\t\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode5}\&quot;,\n\t\t\t\t\t\&quot;subBals\&quot;: {\n\t\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\t\&quot;dec0\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec2\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec5\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t}\n\t\t\t\t\t},\n\t\t\t\t\t\&quot;tmZoneCode\&quot;: \&quot;usnyc\&quot;,\n\t\t\t\t\t\&quot;subBalAmts\&quot;: {\n\t\t\t\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\t\t\t\&quot;dec0\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec2\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t},\n\t\t\t\t\t\t\&quot;dec5\&quot;: {\n\t\t\t\t\t\t\t\&quot;accrInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;avlInt\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;fee\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;ledger\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;negAccr\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;penalty\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthFed\&quot;: 0,\n\t\t\t\t\t\t\t\&quot;wthState\&quot;: 0\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t},\n\t\t\t\t\&quot;prodName\&quot;: \&quot;${prodCode5}\&quot;\n\t\t\t}]\n\t\t},\n\t\t\&quot;AcctPartyRel\&quot;: {\n\t\t\t\&quot;_schVn\&quot;: 0,\n\t\t\t\&quot;_vn\&quot;: 0,\n\t\t\t\&quot;partyAcctName\&quot;: \&quot;${acctTitle}\&quot;,\n\t\t\t\&quot;partyPct\&quot;: 100,\n\t\t\t\&quot;relType\&quot;: \&quot;1\&quot;\n\t\t}\n\t}]\n}&quot;,
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
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>9f303a97-3c31-4591-ad95-dbafd34f1a71</id>
      <masked>false</masked>
      <name>posnName2</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>c92fd1bd-b7d8-4b58-becd-2c761d44dd32</id>
      <masked>false</masked>
      <name>prodCode2</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>1280a46b-be0f-4c7d-aba0-5590cb4b68c5</id>
      <masked>false</masked>
      <name>posnName3</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>d2afc51e-35b0-4aae-af07-834c75b29689</id>
      <masked>false</masked>
      <name>prodCode3</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>d3f532ee-632a-449a-a2af-7a6620c5630d</id>
      <masked>false</masked>
      <name>posnName4</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>93012e48-9a67-4fa3-b17a-b979ff164ff2</id>
      <masked>false</masked>
      <name>prodCode4</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>614d4e2f-ddda-4996-902e-a24e72cef454</id>
      <masked>false</masked>
      <name>posnName5</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>bd58a6db-f622-41c5-a706-e1edf7e6f9e7</id>
      <masked>false</masked>
      <name>prodCode5</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>f36960c7-9995-4fad-be40-db0d02b76736</id>
      <masked>false</masked>
      <name>credLimit4</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>7b417710-0d01-4ebc-ad93-4a10bda65820</id>
      <masked>false</masked>
      <name>credLimit5</name>
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
