package NickZelada;

/**
 * Converter would convert the currency from the original currency of the user
 * to the currency they wish to convert it to.
 *
 * @author Nick Zelada
 * @version 03/21/2019 I affirm that this program is entirely my own work and
 * other person's work is involved.
 */
public class Converter {

    private static final double EurToUsd = 1.42; // Euro to USD
    private static final double GbpToUsd = 1.64; // Pounds to USD
    private static final double GbpToEur = 1.13; // Pounds to Euro

    /**
     * Convert will convert the currency to the currency the user wishes to
     *
     * @param amount the amount they wish to convert from
     * @param fromTo the original currency they are converting from
     * @param toNew the new currency they want to convert to
     * @return the converted amount or original if they didn't convert
     */
    public static double convert(double amount, Money fromTo, Money toNew) {

        if (fromTo == Money.USD && toNew == Money.EUR) { // Convert USD to Euro

            return amount / EurToUsd; // returns Euro amount

        }
        if (fromTo == Money.USD && toNew == Money.GBP) { // Convert USD to GBP

            return amount / GbpToUsd; // returns GBP

        }

        if (fromTo == Money.EUR && toNew == Money.USD) { // Convert EUR to USD

            return amount * EurToUsd; // returns USD

        }
        if (fromTo == Money.EUR && toNew == Money.GBP) { // Convert GBP to EUR

            return amount / GbpToEur; // returns Euro

        }

        if (fromTo == Money.GBP && toNew == Money.USD) { // Convert GBP to USD

            return amount * GbpToUsd; // returns USD

        }
        if (fromTo == Money.GBP && toNew == Money.EUR) { // Convert GBP to EUR

            return amount * GbpToEur; // returns Euro

        }

        return amount; // returns amount inputed original
    }

    
}
/**
 * This represents the type of currencies
 * 
 */
enum Money {

        USD, EUR, GBP // US Dollar, Euro, British Pound

    }
