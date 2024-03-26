package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var fileReader = new FileReader();
        var path = args[0];
        var content = fileReader.read(path);
        IAMPolicyVerifier iamPolicyVerifier = new JSONOfIAMPolicyVerifier();
        var verifyResult = iamPolicyVerifier.verify(content);
        System.out.println("Verify result: " + verifyResult);
    }
}