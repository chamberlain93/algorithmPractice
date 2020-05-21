package com.chamberlain.codewars;

/**
 * Created by chamberlain on 2020/5/21.
 */
public class SpinWords {

    public String spinWordsFunction(String orignalStr) {
        String[] strArray = orignalStr.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length() < 5) {
                sb.append(strArray[i]);
                sb.append(" ");
            } else {
                char[] charArray = strArray[i].toCharArray();
                for (int j = 0; j < charArray.length / 2; j++) {
                    char tempChar = charArray[j];
                    charArray[j] = charArray[charArray.length - 1 - j];
                    charArray[charArray.length - 1 - j] = tempChar;
                }
                String tempStr = "";
                for (char c : charArray) {
                    tempStr += c;
                }
                sb.append(tempStr);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
