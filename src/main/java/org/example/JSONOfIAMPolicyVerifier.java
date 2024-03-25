package org.example;

import org.json.JSONObject;

//throw JsonException if iamPolicy is not a json
public class JSONOfIAMPolicyVerifier implements IAMPolicyVerifier {
    @Override
    public boolean verify(String iamPolicy) {
        JSONObject jsonObject = new JSONObject(iamPolicy);

        if (jsonObject.has("PolicyDocument")) {
            var policyDocumentObject = jsonObject.getJSONObject("PolicyDocument");

            if (policyDocumentObject.has("Statement")) {
                var statementArray = policyDocumentObject.getJSONArray("Statement");

                for (int i = 0; i < statementArray.length(); i++) {
                    var statementObject = statementArray.getJSONObject(i);

                    if (statementObject.has("Resource")) {
                        var resource = statementObject.getString("Resource");

                        // Based on example I assume that
                        // "Method shall return logical false if
                        // an input JSON Resource field contains a single asterisk"
                        // means equality with "*"
                        if (resource.equals("*")) {
                            return false;//main case
                        }
                    }
                }
            }
        }

        return true;//other cases
    }
}
