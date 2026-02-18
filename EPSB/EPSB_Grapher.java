import javax.swing.*;
import java.awt.*;

public class EPSB_Grapher extends Canvas
{
    public void paint(Graphics g)
    {
        int maxX = getWidth();
        int maxY = getHeight();

        // Drawing axis, numbers, and tick marks
        Graphics2D g2d = (Graphics2D) g;
        // g2d.setStroke(new BasicStroke(2f));
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        FontMetrics fm = g.getFontMetrics();

        g.drawLine(50, 900, 1800, 900);
        for(int index = 300; index <= 1800; index += 300)
        {
                // Disableing tickmarks on the x axix of the graph
                // g.drawLine(index, 900 - 10, index, 900 + 10);
                String label = "???";
                switch(index)
                {
                        case 300:
                                label = "Capitals";
                                break;
                        case 600:
                                label = "Lower Case";
                                break;
                        case 900:
                                label = "Leters";
                                break;
                        case 1200:
                                label = "Digits";
                                break;
                        case 1500:
                                label = "Special Symbols";
                                break;
                        case 1800:
                                label = "Length";
                                break;
                }
                int textWidth = fm.stringWidth(label);
                g.drawString(label, index - (textWidth / 2), 930);
        }

        g.drawLine(50, 50, 50, 900);
        for(int index = 50; index <= 900; index += 50)
        {
                g.drawLine(50 - 10 , index, 50 + 10, index);

                String label = "" + ((900 - index) / 50);
                g.drawString(label, 0, index + ((fm.getAscent() - fm.getDescent()) / 2));
        }

        // Getting EPSB info
        EPSB myEPSB = new EPSB();

        myEPSB.addNewPassword("coffeeMINT42");
        myEPSB.addNewPassword("42coffeeM!nt");
        myEPSB.addNewPassword("m!ntCoffee_4202");

        // Beginning of capitals
        // Raw EPSB data
        int maximumCapitals = myEPSB.capitals.get(myEPSB.capitals.size()-1);
        int minumumCapitals = myEPSB.capitals.get(0);
        double meanCapitalsD = myEPSB.getAverage(myEPSB.capitals);
        int medianCapitals = myEPSB.getMedian(myEPSB.capitals);
        int modeCapitals = myEPSB.getMode(myEPSB.capitals);
        // Translated corrdinates
        maximumCapitals = 900 - (maximumCapitals * 50);
        minumumCapitals = 900 - (minumumCapitals * 50);
        meanCapitalsD = (double) 900.0 - (double) (meanCapitalsD * 50.0);
        medianCapitals = 900 - (medianCapitals * 50);
        modeCapitals = 900 - (modeCapitals * 50);
        int meanCapitals = (int) meanCapitalsD;
        // Finding max-min line
        g.drawLine(300, maximumCapitals, 300, minumumCapitals);
        // Max, min, mean, median, and mode points
        g.fillOval(300 - (10 / 2), maximumCapitals - (10 / 2), 10, 10);
        g.fillOval(300 - (10 / 2), minumumCapitals - (10 / 2), 10, 10);
        g.drawString("*", 300 - fm.stringWidth("*")/2, meanCapitals);
        g.fillOval(300 - (10 / 2), medianCapitals - (10 / 2), 10, 10);
        g.drawString("@", 300 - fm.stringWidth("@")/2, modeCapitals + ((fm.getAscent() - fm.getDescent()) / 2));
        // End of capitals

        // Beginning of lower case
        // Raw EPSB data
        int maximumLowerCase = myEPSB.lowerCase.get(myEPSB.lowerCase.size()-1);
        int minumumLowerCase = myEPSB.lowerCase.get(0);
        double meanLowerCaseD = myEPSB.getAverage(myEPSB.lowerCase);
        int medianLowerCase = myEPSB.getMedian(myEPSB.lowerCase);
        int modeLowerCase = myEPSB.getMode(myEPSB.lowerCase);
        // Translated corrdinates
        maximumLowerCase = 900 - (maximumLowerCase * 50);
        minumumLowerCase = 900 - (minumumLowerCase * 50);
        meanLowerCaseD = (double) 900.0 - (double) (meanLowerCaseD * 50.0);
        medianLowerCase = 900 - (medianLowerCase * 50);
        modeLowerCase = 900 - (modeLowerCase * 50);
        int meanLowerCase = (int) meanLowerCaseD;
        // Finding max-min line
        g.drawLine(600, maximumLowerCase, 600, minumumLowerCase);
        // Max, min, mean, median, and mode points
        g.fillOval(600 - (10 / 2), maximumLowerCase - (10 / 2), 10, 10);
        g.fillOval(600 - (10 / 2), minumumLowerCase - (10 / 2), 10, 10);
        g.drawString("*", 600 - fm.stringWidth("*")/2, meanLowerCase);
        g.fillOval(600 - (10 / 2), medianLowerCase - (10 / 2), 10, 10);
        g.drawString("@", 600 - fm.stringWidth("@")/2, modeLowerCase + ((fm.getAscent() - fm.getDescent()) / 2));
        // End of lower case

        // Beginning of letters
        // Raw EPSB data
        int maximumLetters = myEPSB.letters.get(myEPSB.letters.size()-1);
        int minumumLetters = myEPSB.letters.get(0);
        double meanLettersD = myEPSB.getAverage(myEPSB.letters);
        int medianLetters = myEPSB.getMedian(myEPSB.letters);
        int modeLetters = myEPSB.getMode(myEPSB.letters);
        // Translated corrdinates
        maximumLetters = 900 - (maximumLetters * 50);
        minumumLetters = 900 - (minumumLetters * 50);
        meanLettersD = (double) 900.0 - (double) (meanLettersD * 50.0);
        medianLetters = 900 - (medianLetters * 50);
        modeLetters = 900 - (modeLetters * 50);
        int meanLetters = (int) meanLettersD;
        // Finding max-min line
        g.drawLine(900, maximumLetters, 900, minumumLetters);
        // Max, min, mean, median, and mode points
        g.fillOval(900 - (10 / 2), maximumLetters - (10 / 2), 10, 10);
        g.fillOval(900 - (10 / 2), minumumLetters - (10 / 2), 10, 10);
        g.drawString("*", 900 - fm.stringWidth("*")/2, meanLetters);
        g.fillOval(900 - (10 / 2), medianLetters - (10 / 2), 10, 10);
        g.drawString("@", 900 - fm.stringWidth("@")/2, modeLetters + ((fm.getAscent() - fm.getDescent()) / 2));
        // End of letters

        // Beginning of digits
        // Raw EPSB data
        int maximumDigits = myEPSB.numbers.get(myEPSB.numbers.size()-1);
        int minumumDigits = myEPSB.numbers.get(0);
        double meanDigitsD = myEPSB.getAverage(myEPSB.numbers);
        int medianDigits = myEPSB.getMedian(myEPSB.numbers);
        int modeDigits = myEPSB.getMode(myEPSB.numbers);
        // Translated corrdinates
        maximumDigits = 900 - (maximumDigits * 50);
        minumumDigits = 900 - (minumumDigits * 50);
        meanDigitsD = (double) 900.0 - (double) (meanDigitsD * 50.0);
        medianDigits = 900 - (medianDigits * 50);
        modeDigits = 900 - (modeDigits * 50);
        int meanDigits = (int) meanDigitsD;
        // Finding max-min line
        g.drawLine(1200, maximumDigits, 1200, minumumDigits);
        // Max, min, mean, median, and mode points
        g.fillOval(1200 - (10 / 2), maximumDigits - (10 / 2), 10, 10);
        g.fillOval(1200 - (10 / 2), minumumDigits - (10 / 2), 10, 10);
        g.drawString("*", 1200 - fm.stringWidth("*")/2, meanDigits);
        g.fillOval(1200 - (10 / 2), medianDigits - (10 / 2), 10, 10);
        g.drawString("@", 1200 - fm.stringWidth("@")/2, modeDigits + ((fm.getAscent() - fm.getDescent()) / 2));
        // End of digits

        // Beginning of symbols
        // Raw EPSB data
        int maximumSymbols = myEPSB.symbols.get(myEPSB.symbols.size()-1);
        int minumumSymbols = myEPSB.symbols.get(0);
        double meanSymbolsD = myEPSB.getAverage(myEPSB.symbols);
        int medianSymbols = myEPSB.getMedian(myEPSB.symbols);
        int modeSymbols = myEPSB.getMode(myEPSB.symbols);
        // Translated corrdinates
        maximumSymbols = 900 - (maximumSymbols * 50);
        minumumSymbols = 900 - (minumumSymbols * 50);
        meanSymbolsD = (double) 900.0 - (double) (meanSymbolsD * 50.0);
        medianSymbols = 900 - (medianSymbols * 50);
        modeSymbols = 900 - (modeSymbols * 50);
        int meanSymbols = (int) meanSymbolsD;
        // Finding max-min line
        g.drawLine(1500, maximumSymbols, 1500, minumumSymbols);
        // Max, min, mean, median, and mode points
        g.fillOval(1500 - (10 / 2), maximumSymbols - (10 / 2), 10, 10);
        g.fillOval(1500 - (10 / 2), minumumSymbols - (10 / 2), 10, 10);
        g.drawString("*", 1500 - fm.stringWidth("*")/2, meanSymbols);
        g.fillOval(1500 - (10 / 2), medianSymbols - (10 / 2), 10, 10);
        g.drawString("@", 1500 - fm.stringWidth("@")/2, modeSymbols + ((fm.getAscent() - fm.getDescent()) / 2));
        // End of symbols

        // Beginning of length
        // Raw EPSB data
        int maximumLength = myEPSB.length.get(myEPSB.length.size()-1);
        int minumumLength = myEPSB.length.get(0);
        double meanLengthD = myEPSB.getAverage(myEPSB.length);
        int medianLength = myEPSB.getMedian(myEPSB.length);
        int modeLength = myEPSB.getMode(myEPSB.length);
        // Translated corrdinates
        maximumLength = 900 - (maximumLength * 50);
        minumumLength = 900 - (minumumLength * 50);
        meanLengthD = (double) 900.0 - (double) (meanLengthD * 50.0);
        medianLength = 900 - (medianLength * 50);
        modeLength = 900 - (modeLength * 50);
        int meanLength = (int) meanLengthD;
        // Finding max-min line
        g.drawLine(1800, maximumLength, 1800, minumumLength);
        // Max, min, mean, median, and mode points
        g.fillOval(1800 - (10 / 2), maximumLength - (10 / 2), 10, 10);
        g.fillOval(1800 - (10 / 2), minumumLength - (10 / 2), 10, 10);
        g.drawString("*", 1800 - fm.stringWidth("*")/2, meanLength);
        g.fillOval(1800 - (10 / 2), medianLength - (10 / 2), 10, 10);
        g.drawString("@", 1800 - fm.stringWidth("@")/2, modeLength + ((fm.getAscent() - fm.getDescent()) / 2));
        // End of Length

        revalidate(); // IDK what this shit does, but I'm keeping it on becuase some guys on the internet told me to
        // repaint(); // This function takes 12% OF MY CPU. HOW?!
    }

    public static void main(String[] args)
    {
        EPSB_Grapher m = new EPSB_Grapher();
        JFrame f = new JFrame();
        f.add(m);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setTitle("EPSB Grapher");
        f.setSize(2000, 2000);
        f.setLocationRelativeTo(null); // Center the window
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        f.setVisible(true);
    }
}
