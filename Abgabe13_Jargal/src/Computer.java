public class Computer {
    private String name;
    private USBStick usb0;
    private USBStick usb1;
    private int verkaufsPreisComputer;

    public Computer(String name, int verkaufsPreisComputer) {
        setName(name);
        setVerkaufsPreisComputer(verkaufsPreisComputer);
    }

    // Setter-Methoden mit Fehlerausgaben
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Fehler: Computername darf nicht leer sein!");
            this.name = "Unbekannt";
        } else {
            this.name = name;
        }
    }

    public void setVerkaufsPreisComputer(int verkaufsPreisComputer) {
        if (verkaufsPreisComputer <= 200) {
            System.out.println("Fehler: Verkaufspreis muss größer als 200 sein!");
            this.verkaufsPreisComputer = 201;
        } else {
            this.verkaufsPreisComputer = verkaufsPreisComputer;
        }
    }

    public void setUsb0(USBStick usb0) { this.usb0 = usb0; }
    public void setUsb1(USBStick usb1) { this.usb1 = usb1; }

    // Getter-Methoden
    public String getName() { return name; }
    public USBStick getUsb0() { return usb0; }
    public USBStick getUsb1() { return usb1; }
    public int getVerkaufsPreisComputer() { return verkaufsPreisComputer; }

    public void printComputer() {
        System.out.println("Computer:");
        System.out.println("  Name: " + name);
        System.out.println("  Verkaufspreis: " + verkaufsPreisComputer + "€");

        System.out.println("  USB-Port 0:");
        if (usb0 != null) {
            usb0.printUSBStick();
        } else {
            System.out.println("    Kein USB-Stick angeschlossen");
        }

        System.out.println("  USB-Port 1:");
        if (usb1 != null) {
            usb1.printUSBStick();
        } else {
            System.out.println("    Kein USB-Stick angeschlossen");
        }
    }

    public int summeVerkaufsPreis() {
        int summe = verkaufsPreisComputer;
        if (usb0 != null) summe += usb0.getVerkaufsPreisUSB();
        if (usb1 != null) summe += usb1.getVerkaufsPreisUSB();
        return summe;
    }
}