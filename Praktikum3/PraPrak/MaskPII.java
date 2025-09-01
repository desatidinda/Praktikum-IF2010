public class MaskPII {
    private String maskEmail(String email) {
        email = email.toLowerCase();
        String[] splitEmail = email.split("@");

        String name = splitEmail[0];
        String domain = splitEmail[1];

        String output = (name.charAt(0) + "*****" + name.charAt(name.length()-1) + "@" + domain);
        return output;
    }

    private String maskPhoneNumber(String phoneNumber) {
        String number = phoneNumber.replaceAll("[^0-9]", "");
        int panjang = number.length();
        if (panjang == 10) {
            String akhir = number.substring(6);
            phoneNumber =  "***-***-" + akhir;
        } 
        else if (panjang == 11) {
            String akhir = number.substring(7);
            phoneNumber =  "+*-***-***-" + akhir;
        } 
        else if (panjang == 12) {
            String akhir = number.substring(8);
            phoneNumber =  "+**-***-***-" + akhir;
        }
        else if (panjang == 13) {
            String akhir = number.substring(9);
            phoneNumber =  "+***-***-***-" + akhir;
        }
        return phoneNumber;
    }

    public String maskPII(String pii) {
        // dilakukan pengecekan String pii
        // jika pii merupakan email, panggil method maskEmail
        // jika pii merupakan phone number, panggil method maskPhoneNumber
        if (pii.contains("@") ) {
            return maskEmail(pii);
        }
        else {
            return maskPhoneNumber(pii);  
        } 
    }
}