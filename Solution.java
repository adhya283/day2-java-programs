import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void countVowelsAndConsonants(String text) {
        if (text == null) return;
        int vowels = 0, consonants = 0;

        for (char ch : text.toCharArray()) {
            char lower = Character.toLowerCase(ch);
            if (lower >= 'a' && lower <= 'z') {
                if (lower == 'a' || lower == 'e' || lower == 'i' ||
                    lower == 'o' || lower == 'u')
                    vowels++;
                else
                    consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] parts = csvLine.split(",");
        if (parts.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = parts[0].trim();
        String rollNo = parts[1].trim();
        String dept = parts[2].trim();

        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static String validateFileExtension(String filename) {
        if (filename == null || !filename.contains("."))
            return "Rejected - invalid file type";

        int lastDotIndex = filename.lastIndexOf('.');
        String ext = filename.substring(lastDotIndex + 1).toLowerCase();

        List<String> allowedExtensions = Arrays.asList("pdf", "docx", "csv");

        if (allowedExtensions.contains(ext))
            return "Accepted";
        else
            return "Rejected - invalid file type";
    }

    public static String formatPhoneNumber(String phone) {
        if (phone == null)
            return "Invalid phone number";

        String trimmed = phone.trim();

        if (trimmed.length() != 10 || !trimmed.matches("\\d{10}"))
            return "Invalid phone number";

        String last4 = trimmed.substring(6);
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX ");
        sb.append(last4);

        return sb.toString();
    }

    public static String processBankReference(String ref) {
        if (ref == null)
            return "Invalid: wrong length";

        String trimmed = ref.trim();

        if (trimmed.length() != 14)
            return "Invalid bank code must be 4 letters / wrong length / non-digit body";

        String bankCode = trimmed.substring(0, 4);
        String numericPart = trimmed.substring(4);

        if (!bankCode.matches("[a-zA-Z]{4}"))
            return "Invalid bank code must be 4 letters";

        if (!numericPart.matches("\\d{10}"))
            return "Invalid: non-digit body";

        bankCode = bankCode.toUpperCase();

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append(numericPart.substring(0, 4)).append("-");
        sb.append(numericPart.substring(4, 8)).append("-");
        sb.append(numericPart.substring(8));

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Vowel & Consonant Counter ---");
        countVowelsAndConsonants("Java Programming");

        System.out.println("\n--- 2. CSV Student Record Parser ---");
        parseStudentRecord("Ananya Sharma,RA2111003010123,Dept-CSE");
        parseStudentRecord("Invalid Record,123");

        System.out.println("\n--- 3. File Extension Validator ---");
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));

        System.out.println("\n--- 4. Masked Phone Number Formatter ---");
        System.out.println(formatPhoneNumber("9876543210"));
        System.out.println(formatPhoneNumber("98765"));

        System.out.println("\n--- 5. Bank Transaction Reference Generator & Validator ---");
        System.out.println(processBankReference("  hdfc1234567890  "));
        System.out.println(processBankReference("12341234567890"));
    }
}