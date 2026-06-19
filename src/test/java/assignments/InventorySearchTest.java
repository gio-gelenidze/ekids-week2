package assignments;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * ტესტი დავალება 1-ისთვის
 *
 * ეს ტესტი შეამოწმებს, რომ:
 * 1. თუ მასივი სწორად შექმენი
 * 2. თუ for ციკლი სწორად დაწერი
 * 3. თუ "Key" სწორად პოულობ და სპეციალურ შეტყობინებას დაბეჭდი
 */
public class InventorySearchTest {

    @Test
    public void testInventorySearchFindsKey() {
        // დავიჭერთ პროგრამის გამოსავალს (რაც System.out.println დაბეჭდავს)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // ვუშვებთ მთავარ მეთოდს
        InventorySearch.main(new String[]{});

        // ვუბრუნებთ სტანდარტულ გამოსავალს
        System.setOut(System.out);
        String output = outContent.toString();

        // შეამოწმებს, რომ პროგრამა დაბეჭდა თითოეული ნივთი
        assertTrue("უნდა დაბეჭდო ყველა ნივთი", output.contains("Sword"));
        assertTrue("უნდა დაბეჭდო Shield", output.contains("Shield"));
        assertTrue("უნდა დაბეჭდო Potion", output.contains("Potion"));
        assertTrue("უნდა დაბეჭდო Key", output.contains("Key"));
        assertTrue("უნდა დაბეჭდო Coin", output.contains("Coin"));

        // შეამოწმებს, რომ გასაღები ნაპოვნია
        assertTrue("უნდა დაბეჭდო სპეციალური შეტყობინება Key-ზე",
                output.contains("გასაღები ნაპოვნია"));
    }

    @Test
    public void testOutputFormat() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        InventorySearch.main(new String[]{});

        System.setOut(System.out);
        String output = outContent.toString();

        // თემაზე გაწერილი სტანდარტული მესიჯი უნდა ჩანდეს
        assertTrue("უნდა იყოს სათაური", output.contains("ზურგჩანთა"));
    }
}
