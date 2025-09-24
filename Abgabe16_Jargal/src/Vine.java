public class Vine {
    private String variety;
    private Date plantingDate;
    private int plantingMonth;
    private boolean diseased;
    private double yield;

//    constructor
    public Vine(String variety, Date plantingDate, int plantingMonth, boolean diseased, double yield){
        setVariety(variety);
        setPlantingDate(plantingDate);
        setPlantingMonth(plantingMonth);
        setDiseased(diseased);
        setYield(yield);

    }



//    Setters with validation
    public void setPlantingMonth(int plantingMonth){
        if (plantingMonth >= 1 && plantingMonth <= 12){
            this.plantingMonth = plantingMonth;
        } else {
            System.out.println("Error: Month must be bet ween 1 and 12");
        }
    }

    public void setYield(double yield){
        if (yield > 0 && yield < 5){
            this.yield = yield;
        } else {
            System.out.println("Error: Yield must be between 0 and 5");
        }
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public void setPlantingDate(Date plantingDate) {
        this.plantingDate = plantingDate;
    }

    public void setDiseased(boolean diseased) {
        this.diseased = diseased;
    }

//    Getters

    public String getVariety() {
        return variety;
    }

    public Date getPlantingDate() {
        return plantingDate;
    }

    public int getPlantingMonth() {
        return plantingMonth;
    }

    public boolean isDiseased() {
        return diseased;
    }

    public double getYield() {
        return yield;
    }


    @Override
    public String toString() {
        return String.format("Variety: %s, Planting Date: %s, Month: %d, Diseased: %s, Yield: %2f", variety, plantingDate, plantingMonth, diseased ?
                "yes" : "no",  yield);
    }
}
