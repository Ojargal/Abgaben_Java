public class Vineyard {
    private String name;
    private Vine[] vines;
    private double sizeINHectares;
    private int count;

//    Constructor
    public Vineyard(String name, int n, double sizeINHectares){
        this.name = name;
        if (n < 5){
            System.out.println("Array size must be at least 5");
        }
        this.vines = new Vine[n];
        this.sizeINHectares = sizeINHectares;
        this.count = 0;
    }



    //    Methods
    public void print(){
        System.out.println("Vineyard: " + name);
        System.out.println("Size: " + sizeINHectares + " hectares");
        System.out.println("Vines (" + count + "/" + vines.length + "):");
        for (int i = 0; i < count; i++){
            System.out.println(" " + (i+1) + ". " + vines[i]);
        }
    }

    public boolean addAtEnd(Vine vine){
        if (count >= vines.length) return false;
        vines[count++] = vine;
        return true;
    }

    public boolean addAtBeginning(Vine vine){
        if (count >= vines.length) return false;

        // Shift all elements to the right
        for (int i = count; i > 0; i--){
            vines[i] = vines[i - 1];
        }
        vines[0] = vine;
        count++;
        return true;
    }

    public Vine removeDiseased(){
        for (int i = 0; i < count; i++){
            if (vines[i].isDiseased()){
                Vine removed = vines[i];
                // Shift subsequent elements to the left
                for (int j = i; j < count - 1; j++){
                    vines[j] = vines[j+1];
                }
                vines[--count] = null;
                return removed;
            }
        }
        return null;
    }

    public Vine[] removeAllDiseased(){
        int diseasedCount = countDiseased();
        Vine[] removedVines = new Vine[diseasedCount];

        for (int i = 0; i < diseasedCount; i++){
            removedVines[i] = removeDiseased();
        }
        return removedVines;
    }

    public int countDiseased() {
        int count = 0;
        for (int i = 0; i < this.count; i++){
            if (vines[i].isDiseased()){
                count++;
            }
        }
        return count;
    }

    public double calculateYield(){
        double totalYield   = 0;
        for (int i = 0; i < count; i++){
            totalYield += vines[i].getYield();
        }
        return ((vines.length - count) / (double)vines.length) * 100;
    }

    public double freeSpacePercentage(){
        return ((vines.length - count) / (double)vines.length) * 100;
    }

    public void sort(){
        // Bubble sort by planting date
        for (int i = 0; i < count-1; i++){
            for (int j = 0; j < count - i - 1; j++){
                if (!vines[j].getPlantingDate().isEarierThan(vines[j+1].getPlantingDate())){
                    // Swap
                    Vine temp = vines[j];
                    vines [j] = vines[j+1];
                    vines [j+1] = temp;
                }
            }
        }
    }
    public int countVines(){
        return count;
    }

    public void printGroupedByVariety(){
        // Temporary arrays for varieties and yields
        String[] varieties = new String[count];
        double[] yields = new double[count];
        int uniqueCount = 0;

        // Iterate through all vines
        for (int i = 0; i < count; i++){
            String currentVariety = vines[i].getVariety();
            double currentYield = vines[i].getYield();
            boolean found = false;

            //Check if variety has already been recorded
            for (int j = 0; j < uniqueCount; j++){
                if (varieties[j].equals(currentVariety)) {
                    yields[j] += currentYield;
                    found = true;
                    break;
                }
            }

            // Add new variety
            if (!found) {
                varieties[uniqueCount] = currentVariety;
                yields[uniqueCount] = currentYield;
                uniqueCount++;
            }
        }

        // Display results
        System.out.println("Yield by variety: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.printf("Variety %s, %.1f%n", varieties[i], yields[i]);
        }

    }


}
