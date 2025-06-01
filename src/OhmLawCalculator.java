public class OhmLawCalculator {
    private static OhmLaw ohmLaw;
    private static InputValidator validator;

    public static void main(String[] args) {
        ohmLaw = new OhmLaw();
        validator = new InputValidator();

        System.out.println("=== Ohm's Law Calculator ===");
        System.out.println("V = I x R (Tegangan = Arus x Hambatan)");
        System.out.println("I = V ÷ R (Arus = Tegangan ÷ Hambatan)");
        System.out.println("R = V ÷ I (Hambatan = Tegangan ÷ Arus)");
        System.out.println();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = validator.getValidChoice("Pilih operasi (1-4): ", 1, 4);

            try {
                switch (choice) {
                    case 1:
                        calculateVoltage();
                        break;
                    case 2:
                        calculateCurrent();
                        break;
                    case 3:
                        calculateResistance();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Terima kasih telah menggunakan program ini!");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (running) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                validator.waitForEnter();
            }
        }

        validator.closeScanner();
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Hitung Tegangan (V)");
        System.out.println("2. Hitung Arus (I)");
        System.out.println("3. Hitung Hambatan (R)");
        System.out.println("4. Keluar");
    }

    private static void calculateVoltage() {
        System.out.println("\n=== Menghitung Tegangan (V) ===");
        double current = validator.getValidDouble("Masukkan nilai arus (Ampere): ");
        double resistance = validator.getValidDouble("Masukkan nilai hambatan (Ohm): ");
        
        double voltage = ohmLaw.calculateVoltage(current, resistance);
        System.out.printf("Tegangan (V) = %.2f Volt%n", voltage);
    }

    private static void calculateCurrent() {
        System.out.println("\n=== Menghitung Arus (I) ===");
        double voltage = validator.getValidDouble("Masukkan nilai tegangan (Volt): ");
        double resistance = validator.getValidDouble("Masukkan nilai hambatan (Ohm): ");
        
        double current = ohmLaw.calculateCurrent(voltage, resistance);
        System.out.printf("Arus (I) = %.2f Ampere%n", current);
    }

    private static void calculateResistance() {
        System.out.println("\n=== Menghitung Hambatan (R) ===");
        double voltage = validator.getValidDouble("Masukkan nilai tegangan (Volt): ");
        double current = validator.getValidDouble("Masukkan nilai arus (Ampere): ");
        
        double resistance = ohmLaw.calculateResistance(voltage, current);
        System.out.printf("Hambatan (R) = %.2f Ohm%n", resistance);
    }
} 